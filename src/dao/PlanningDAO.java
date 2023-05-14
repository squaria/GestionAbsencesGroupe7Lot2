package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.PlanningEnseignant;
import model.PlanningGroupe;

/**
 * Classe DAO de lien avec la base de donnee 
 * pour tout les interactions avec les plannings de groupe et enseignant
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class PlanningDAO extends IdentificationBdd {

	/**
	 * Constructeur de la classe PlanningDAO
	 */
	public PlanningDAO() {
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir le numero de groupe d'un etudiant
	 * @param etuId
	 * 			id de l'etudiant
	 * @return etuGrp
	 * 			numero de groupe de l'etudiant
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int getGroupeEtudiant(int etuId) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			int etuGrp = 0;
			ps = con.prepareStatement("SELECT grp_numero FROM Lot2_Etudiant "
					+ "JOIN Lot2_Groupe ON Lot2_Etudiant.etu_grp_id = Lot2_Groupe.grp_id "
					+ "WHERE Lot2_Etudiant.etu_id = ?");
			ps.setInt(1, etuId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				etuGrp = rs.getInt("etu_grp_id");
			}
			
			return etuGrp;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir le planning d'un groupe
	 * @param grpNum
	 * 			numero du groupe
	 * @param dateDebut
	 * 			date de debut de selection
	 * @param dateFin
	 * 			date de fin de selection
	 * @return listeCours
	 * 			liste des cours du planning d'un groupe
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
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
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir le planning d'un professeur
	 * @param profId
	 * 			id du professeur
	 * @param dateDebut
	 * 			date de debut de selection
	 * @param dateFin
	 * 			date de fin de selection
	 * @return listeObj
	 * 			tableau contenant deux arraylist, une liste des cours et
	 * 			une liste des dates de ces cours
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public Object[] planningProf(int profId, String dateDebut, String dateFin) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			Object[] listeObj = {-1,-1};
			ArrayList<PlanningEnseignant> listeCours = new ArrayList<>();
			ArrayList<Date> listeDate = new ArrayList<>();
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
				listeDate.add(rs.getDate("plan_date"));
			}
			listeObj[0] = listeCours;
			listeObj[1] = listeDate;
			return listeObj;
		}
	}
}
