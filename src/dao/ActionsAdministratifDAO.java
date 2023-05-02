package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Absence;
import model.Profil;

public class ActionsAdministratifDAO extends IdentificationBdd {
	
	public ActionsAdministratifDAO () {
		
	}
	
	public ArrayList<Absence> listeAbsencesAdmin() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			ArrayList<Absence> listeAbsence = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT abs_date, abs_nbHeures, etu_nom, etu_prenom, cours_nom, abs_type, abs_justificatif, abs_valideeAdmin "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_Cours ON Lot2_Absence.abs_cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_AbsenceParEtudiant ON Lot2_Absence.abs_id = Lot2_AbsenceParEtudiant.abs_id "
					+ "JOIN Lot2_Etudiant ON Lot2_AbsenceParEtudiant.etu_id = Lot2_Etudiant.etu_id "
					+ "WHERE abs_valideeAdmin IS NULL "
					+ "ORDER BY Lot2_Absence.abs_id ASC");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeAbsence.add(new Absence(rs.getString("abs_date"), rs.getFloat("abs_nbHeures"), 
				rs.getString("cours_nom"), rs.getString("etu_nom"), rs.getString("etu_prenom"),
				rs.getString("abs_type"), rs.getString("abs_justificatif"), rs.getString("abs_valideeAdmin")));
			}
			
			return listeAbsence;
		}
	}
	
	public ArrayList<Absence> listeAbsencesProf(Profil profil) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Absence> listeAbsence = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT abs_date, abs_nbHeures, cours_nom, abs_type "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_Cours ON Lot2_Absence.abs_cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_AbsenceParEnseignant ON Lot2_Absence.abs_id = Lot2_AbsenceParEnseignant.abs_id "
					+ "JOIN Lot2_Professeur ON Lot2_AbsenceParEnseignant.prof_id = Lot2_Professeur.prof_id "
					+ "WHERE prof_nom = ? AND prof_prenom = ? AND prof_email = ?");
			ps.setString(1, profil.getNom());
			ps.setString(2, profil.getPrenom());
			ps.setString(3, profil.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeAbsence.add(new Absence(rs.getString("abs_date"), rs.getFloat("abs_nbHeures"), rs.getString("cours_nom"),
				rs.getString("abs_type")));
			}
			
			return listeAbsence;
		}
	}
	
	public int validerAbsence(int absId, boolean validee) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Absence "
					+ "SET abs_valideeAdmin = ? "
					+ "WHERE abs_id = ? AND abs_valideeAdmin IS NULL");

			if(validee)
				ps.setString(1, "Validee");
			else
				ps.setString(1, "Invalidee");
			
			ps.setInt(2, absId);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	public boolean absenceExamenValidee(int absId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			boolean absenceExamen = false;
			PreparedStatement ps = con.prepareStatement("SELECT abs_type "
					+ "FROM Lot2_Absence "
					+ "WHERE abs_id = ?");
			ps.setInt(1, absId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next() && rs.getString("abs_type") != null) {
				if(rs.getString("abs_type").equals("Examen"))
					absenceExamen = true;
			}
			
			return absenceExamen;
		}
	}
	
	public int declancherRatrapages(int absId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			int effectuee = 0;
			int etuId = 0;
			int coursId = 0;
			
			PreparedStatement ps = con.prepareStatement("SELECT Lot2_AbsenceParEtudiant.etu_id, abs_cours_id "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_AbsenceParEtudiant ON Lot2_Absence.abs_id = Lot2_AbsenceParEtudiant.abs_id "
					+ "WHERE abs_id = ? "
					+ "ORDER BY Lot2_Absence.abs_id ASC");
			ps.setInt(1, absId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				etuId = rs.getInt("Lot2_AbsenceParEtudiant.etu_id");
				coursId = rs.getInt("abs_cours_id");
			}
			
			ps = con.prepareStatement("UPDATE Lot2_Note "
					+ "SET note_valeur = NULL, note_rattrapage = ? "
					+ "WHERE etu_id = ? AND cours_id = ?");
			ps.setString(1, "Convoquee");
			ps.setInt(2, etuId);
			ps.setInt(3, coursId);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
		}
	}
}
