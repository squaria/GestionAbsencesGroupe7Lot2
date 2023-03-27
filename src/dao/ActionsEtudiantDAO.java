package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Absence;

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
					listeAbsence.add(new Absence(rs.getString("abs_date"), rs.getDouble("abs_nbHeures"), rs.getString("cours_nom"),
					rs.getString("abs_type"), rs.getString("abs_justificatif"), rs.getString("abs_valideeAdmin")));
				}

				return listeAbsence;
			}
		}
	}
