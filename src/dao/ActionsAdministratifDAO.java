package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Absence;
import model.Cours;

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
}
