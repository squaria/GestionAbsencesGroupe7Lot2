package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Absence;
import model.Cours;

public class ActionsProfesseurDAO extends IdentificationBdd {
	public ActionsProfesseurDAO() {
	}
	/*
	public String getCoursNom(int coursId) throws Exception {
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
	}*/
	
	public int creerAbsence(Absence absence) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Absence "
					+ "VALUES (?,?,?,?,?,?)");
			
			ps.setInt(1, actionGest.getLastIdTable(4)+1);
			ps.setString(2, absence.getDate());
			ps.setFloat(3, absence.getNbHeures());
			ps.setInt(4, absence.getCoursId());
			ps.setString(5, absence.getType());
			ps.setString(6, absence.getJustificatif());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
}
