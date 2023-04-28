package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Absence;
import model.Cours;
import model.Etudiant;
import model.Note;
import model.Profil;

public class ActionsProfesseurDAO extends IdentificationBdd {
	public ActionsProfesseurDAO() {
	}
	
	public int getEtuId(Profil profil) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int etudiant = 0;
			
			PreparedStatement ps = con.prepareStatement("SELECT etu_id "
						+ "FROM Lot2_Etudiant "
						+ "WHERE etu_nom = ? AND etu_prenom = ? AND etu_email = ?");
			ps.setString(1, profil.getNom());
			ps.setString(2, profil.getPrenom());
			ps.setString(3, profil.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				etudiant = rs.getInt("etu_id");
			}
		return etudiant;
		}
	}
	
	public ArrayList<Absence> listeAbsencesProf() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Absence> listeAbsence = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT abs_date, abs_nbHeures, cours_nom, abs_type "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_Cours ON Lot2_Absence.abs_cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_AbsenceParEnseignant ON Lot2_Absence.abs_id = Lot2_AbsenceParEnseignant.abs_id ");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeAbsence.add(new Absence(rs.getString("abs_date"), rs.getFloat("abs_nbHeures"), rs.getString("cours_nom"),
				rs.getString("abs_type")));
			}
			
			return listeAbsence;
		}
	}
	
	public ArrayList<Cours> listeCoursProf(int profId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Cours> listeCours = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT cours_nom, cours_NbHeuresAmphi, "
					+ "cours_NbHeuresTD, cours_NbHeuresTP, cours_NbHeuresExamen "
					+ "FROM Lot2_Cours "
					+ "WHERE cours_prof_id = ?");
			ps.setInt(1, profId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeCours.add(new Cours(rs.getString("cours_nom"), profId, rs.getFloat("cours_NbHeuresAmphi"),
						rs.getFloat("cours_NbHeuresTD"), rs.getFloat("cours_NbHeuresTP"),
						rs.getFloat("cours_NbHeuresExamen")));
			}
			
			return listeCours;
		}
	}
	
	public int creerAbsence(Absence absence) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Absence "
					+ "VALUES (?,?,?,?,?,?,?)");
			
			ps.setInt(1, actionGest.getLastIdTable(4)+1);
			ps.setString(2, absence.getDate());
			ps.setFloat(3, absence.getNbHeures());
			ps.setInt(4, absence.getCoursId());
			ps.setString(5, absence.getType());
			ps.setString(6, absence.getJustificatif());
			ps.setString(7, absence.getValideeAdmin());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}

	public int noteZero(Note note) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Note "
					+ "VALUES (?,?,?,?)");
			
			ps.setInt(1, note.getEtuId());
			ps.setInt(2, note.getCoursId());
			ps.setFloat(3, note.getValeur());
			ps.setString(4, note.getDate());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
		}
	}
	
	public ArrayList<Etudiant> listeEtudiant(int groupeId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Etudiant> listeEtudiant = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT etu_id, etu_nom, etu_prenom, etu_email, fil_nom, grp_numero "
					+ "FROM Lot2_Etudiant "
					+ "JOIN Lot2_Filiere ON fil_id = etu_fil_id "
					+ "JOIN Lot2_Groupe ON grp_id = etu_grp_id "
					+ "WHERE etu_grp_id = ? "
					+ "ORDER BY etu_id ASC");
			ps.setInt(1, groupeId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeEtudiant.add(new Etudiant(rs.getString("etu_nom"), rs.getString("etu_prenom"),
						rs.getString("etu_email"), rs.getString("fil_nom"), groupeId));
			}
			
			return listeEtudiant;
		}
	}
	
	public String getNbHeures(int coursId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			String coursNom = null;
			ps = con.prepareStatement("SELECT cours_nom FROM Lot2_Cours "
					+ "WHERE cours_id = ?");
			ps.setInt(1, coursId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				coursNom = rs.getString("cours_nom");
			}
			
			return coursNom;
		}
	}
}
