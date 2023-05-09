package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.PlanningEnseignant;
import model.PlanningGroupe;

public class PlanningDAO extends IdentificationBdd {

	public PlanningDAO() {
	}
	
	public int getGroupeEtudiant(int etuId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			int etuGrp = 0;
			ps = con.prepareStatement("SELECT etu_grp_id FROM Lot2_Etudiant "
					+ "WHERE etu_id = ?");
			ps.setInt(1, etuId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				etuGrp = rs.getInt("etu_grp_id");
			}
			
			return etuGrp;
		}
	}
	
	public ArrayList<PlanningGroupe> planningGroupe(int grpNum, String dateDebut, String dateFin) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<PlanningGroupe> listeCours = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT cours_nom, "
					+ "prof_nom, plan_date, plan_heureDebut, plan_heureFin "
					+ "FROM Lot2_PlanningGroupe "
					+ "JOIN Lot2_Cours ON Lot2_PlanningGroupe.cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_Groupe ON Lot2_PlanningGroupe.grp_id = Lot2_Groupe.grp_id "
					+ "JOIN Lot2_Professeur ON cours_prof_id = prof_id "
					+ "WHERE Lot2_Groupe.grp_numero = ? AND plan_date BETWEEN ? AND ?");
			
			ps.setInt(1, grpNum);
			ps.setString(2, dateDebut);
			ps.setString(3, dateFin);
			
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {

				listeCours.add(new PlanningGroupe(rs.getString("cours_nom"),
						rs.getString("prof_nom"), rs.getString("plan_date"),
						rs.getFloat("plan_heureDebut"), rs.getFloat("plan_heureFin")));
			}
			
			return listeCours;
		}
		
	}
	
	public ArrayList<PlanningEnseignant> planningProf(int profId, String dateDebut, String dateFin) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<PlanningEnseignant> listeCours = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT cours_nom, "
					+ "grp_numero, plan_date, plan_heureDebut, plan_heureFin "
					+ "FROM Lot2_PlanningGroupe "
					+ "JOIN Lot2_Cours ON Lot2_PlanningGroupe.cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_Groupe ON Lot2_PlanningGroupe.grp_id = Lot2_Groupe.grp_id "
					+ "JOIN Lot2_Professeur ON cours_prof_id = prof_id "
					+ "WHERE prof_id = ? AND plan_date BETWEEN ? AND ?");
			
			ps.setInt(1, profId);
			ps.setString(2, dateDebut);
			ps.setString(3, dateFin);
			
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {

				listeCours.add(new PlanningEnseignant(rs.getInt("grp_numero"), rs.getString("cours_nom"),
						rs.getString("plan_date"), rs.getFloat("plan_heureDebut"),
						rs.getFloat("plan_heureFin")));
			}
			
			return listeCours;
		}
	}
}
