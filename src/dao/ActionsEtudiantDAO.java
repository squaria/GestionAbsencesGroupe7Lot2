package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ihm.IdEtTypeCompte;
import model.Absence;
import model.Note;

public class ActionsEtudiantDAO extends IdentificationBdd {

	public ActionsEtudiantDAO() {
		super();
	}
	
	public ArrayList<Absence> listeAbsences(int id) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Absence> listeAbsence = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT abs_date, abs_nbHeures, cours_nom, abs_type, abs_justificatif, abs_valideeAdmin "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_Cours ON Lot2_Absence.abs_cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_AbsenceParEtudiant ON Lot2_Absence.abs_id = Lot2_AbsenceParEtudiant.abs_id "
					+ "WHERE Lot2_AbsenceParEtudiant.etu_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeAbsence.add(new Absence(rs.getString("abs_date"), rs.getFloat("abs_nbHeures"), rs.getString("cours_nom"),
				rs.getString("abs_type"), rs.getString("abs_justificatif"), rs.getString("abs_valideeAdmin")));
			}
			
			return listeAbsence;
		}
	}
	
	public ArrayList<Note> listeNotes(int etuId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Note> listeNotes = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT cours_nom, note_valeur, note_date, note_rattrapage "
					+ "FROM Lot2_Note "
					+ "JOIN Lot2_Cours ON Lot2_Note.cours_id = Lot2_Cours.cours_id "
					+ "WHERE Lot2_Note.etu_id = ?");
			ps.setInt(1, etuId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeNotes.add(new Note(rs.getString("cours_nom"), rs.getFloat("note_valeur"), 
						rs.getString("note_date"), rs.getString("note_rattrapage")));
			}
			
			return listeNotes;
		}
	}
	
	public int deposerJustificatif(int absenceId, String justificatif) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Absence "
					+ "SET abs_justificatif = ? "
					+ "WHERE abs_id = ?");

			ps.setString(1, justificatif);
			ps.setInt(2, absenceId);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
		}
	}
	

	public int deposerJustificatifAbsPhysique(String justificatif, String dateDebut, String dateFin) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
			int effectuee = 0;
			int abs_id = actionGest.getLastIdTable(6);
			PreparedStatement ps = con.prepareStatement("INSERT INTO Lot2_AbsencePhysique(absPhys_id, absPhys_dateDebut, "
					+ "absPhys_dateFin, absPhys_justificatif, absPhys_valideeAdmin) "
					+ "VALUES (?, ?, ?, ?, '') ");
			
			ps.setInt(1, abs_id+1);
			ps.setString(2, dateDebut);
			ps.setString(3, dateFin);
			ps.setString(4, justificatif);
			
			effectuee = ps.executeUpdate();
			
			if(effectuee != 0) {
				ps = con.prepareStatement("INSERT INTO Lot2_AbsencePhysiqueParEtudiant(absPhys_id, etu_id) "
						+ "VALUES (?, ?) ");
				ps.setInt(1, abs_id+1);
				ps.setInt(2, IdEtTypeCompte.id);
				
				effectuee = ps.executeUpdate();
			}
			
			return effectuee;
		}
	}
	
	public float quotaNonRespecte(int etuId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			float calcul = 0;
			PreparedStatement ps = con.prepareStatement("SELECT abs_nbHeures, abs_valideeAdmin "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_AbsenceParEtudiant ON Lot2_Absence.abs_id = Lot2_AbsenceParEtudiant.abs_id "
					+ "WHERE Lot2_AbsenceParEtudiant.etu_id = ?");
			ps.setInt(1, etuId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				if(rs.getString("abs_valideeAdmin") == null)
					calcul += rs.getFloat("abs_nbHeures");
				else
					if(rs.getString("abs_valideeAdmin").equals("Invalidee"))
						calcul += rs.getFloat("abs_nbHeures");
			}
			
			return calcul;
		}
	}


}
