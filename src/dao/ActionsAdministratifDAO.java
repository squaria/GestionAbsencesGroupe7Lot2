package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Absence;
import model.AbsencePhysique;
import model.Profil;

/**
 * Classe DAO de lien avec la base de donnee 
 * pour les actions de l'administratif
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class ActionsAdministratifDAO extends IdentificationBdd {
	
	/**
	 * Constructeur de la classe ActionsAdministratifDAO
	 */
	public ActionsAdministratifDAO () {
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des absences
	 * @return listeAbsence
	 * 			liste des absences
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<Absence> listeAbsencesAdmin() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			ArrayList<Absence> listeAbsence = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT Lot2_Absence.abs_id, abs_date, abs_nbHeures, etu_nom, etu_prenom, cours_nom, abs_type, abs_justificatif, abs_valideeAdmin "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_Cours ON Lot2_Absence.abs_cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_AbsenceParEtudiant ON Lot2_Absence.abs_id = Lot2_AbsenceParEtudiant.abs_id "
					+ "JOIN Lot2_Etudiant ON Lot2_AbsenceParEtudiant.etu_id = Lot2_Etudiant.etu_id "
					+ "ORDER BY Lot2_Absence.abs_id ASC ");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeAbsence.add(new Absence(rs.getInt(1), rs.getString("abs_date"), rs.getFloat("abs_nbHeures"), 
				rs.getString("cours_nom"), rs.getString("etu_nom"), rs.getString("etu_prenom"),
				rs.getString("abs_type"), rs.getString("abs_justificatif"), rs.getString("abs_valideeAdmin")));
			}
			
			return listeAbsence;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des absences physiques
	 * @return listeAbsencePhysique
	 * 			liste des absences physiques
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<AbsencePhysique> listeAbsencesPhysiquesAdmin() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			Format formatter;
			String dateDebut;
			String dateFin;
			ArrayList<AbsencePhysique> listeAbsencePhysique = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT absPhys_dateDebut, absPhys_dateFin, grp_numero, Lot2_Etudiant.etu_id, etu_nom, etu_prenom, absPhys_justificatif, absPhys_valideeAdmin "
					+ "FROM Lot2_AbsencePhysique "
					+ "JOIN Lot2_AbsencePhysiqueParEtudiant ON Lot2_AbsencePhysique.absPhys_id = Lot2_AbsencePhysiqueParEtudiant.absPhys_id "
					+ "JOIN Lot2_Etudiant ON Lot2_AbsencePhysiqueParEtudiant.etu_id = Lot2_Etudiant.etu_id "
					+ "JOIN Lot2_Groupe ON Lot2_Etudiant.etu_grp_id = Lot2_Groupe.grp_id "
					+ "ORDER BY Lot2_AbsencePhysique.absPhys_id ASC");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				dateDebut = formatter.format(rs.getDate("absPhys_dateDebut"));
				dateFin = formatter.format(rs.getDate("absPhys_dateFin"));
				listeAbsencePhysique.add(new AbsencePhysique(dateDebut, dateFin,
						rs.getInt("grp_numero"), rs.getInt("etu_id"), rs.getString("etu_nom"), rs.getString("etu_prenom"), 
						rs.getString("absPhys_justificatif"), rs.getString("absPhys_valideeAdmin")));
			}
			
			return listeAbsencePhysique;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des absences d'un professeur
	 * @param profil
	 * 			profil d'un professeur
	 * @return listeAbsence
	 * 			liste des absences d'un professeur
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
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
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des absences des professeurs
	 * @return listeAbsProf
	 * 			liste des absences des professeurs
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<Absence> listeAbsencesProfRemplacant() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			Format formatter;
			String date;
			ArrayList<Absence> listeAbsProf = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT abs_date, Lot2_Professeur.prof_nom, Lot2_Professeur.prof_prenom,"
					+ "Lot2_Cours.cours_nom "
					+ "FROM Lot2_Absence "
					+ "JOIN Lot2_Cours ON Lot2_Absence.abs_cours_id = Lot2_Cours.cours_id "
					+ "JOIN Lot2_AbsenceParEnseignant ON Lot2_Absence.abs_id = Lot2_AbsenceParEnseignant.abs_id "
					+ "JOIN Lot2_Professeur ON Lot2_AbsenceParEnseignant.prof_id = Lot2_Professeur.prof_id "
					+ "ORDER BY Lot2_Absence.abs_id ASC");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				formatter = new SimpleDateFormat("dd/MM/yyyy");
				date = formatter.format(rs.getDate("abs_date"));
				listeAbsProf.add(new Absence(rs.getString("prof_nom"), rs.getString("prof_prenom"),
						rs.getString("cours_nom"), date, 0));
			}
			
			return listeAbsProf;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de remplacer un professeur absence pour un cours
	 * @param profId
	 * 			id du prof absent
	 * @param profIdRemp
	 * 			id du prof remplacant
	 * @param date
	 * 			date de l'absence
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int remplacerProf(int profId, int profIdRemp, String date) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Cours "
					+ "SET cours_prof_id = ? "
					+ "WHERE cours_id IN "
					+ "( SELECT cours_id "
					+ "FROM Lot2_PlanningGroupe "
					+ "WHERE cours_prof_id = ? AND plan_date = ? )");
			ps.setInt(1, profIdRemp);
			ps.setInt(2, profId);
			ps.setString(3, date);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de valider ou non une absence
	 * @param absId
	 * 			id de l'absence
	 * @param validee
	 * 			vrai si absence validee faux sinon
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int validerAbsence(int absId, boolean validee) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Absence "
					+ "SET abs_valideeAdmin = ? "
					+ "WHERE abs_id = ? ");

			if(validee)
				ps.setString(1, "Validee");
			else
				ps.setString(1, "Invalidee");
			
			ps.setInt(2, absId);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de creer un lien visio pour un cours
	 * @param coursId
	 * 			id du cours
	 * @param groupeId
	 * 			id du groupe
	 * @param dateDebut
	 * 			date de debut de l'absence physique
	 * @param dateFin
	 * 			date de fin de l'absence physique
	 * @param lienVisio
	 * 			lien visio a creer
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int creerLienVisio(int coursId, int groupeId, String dateDebut, String dateFin, String lienVisio) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_PlanningGroupe "
					+ "SET plan_lienVisio = ? "
					+ "WHERE grp_id = ? AND cours_id = ? AND plan_date BETWEEN ? AND ? ");
			ps.setString(1, lienVisio);
			ps.setInt(2, groupeId);
			ps.setInt(3, coursId);
			ps.setString(4, dateDebut);
			ps.setString(5, dateFin);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de valider ou non une absence physique
	 * @param absId
	 * 			id de l'absence
	 * @param grpId
	 * 			id du groupe de l'etudiant
	 * @param etuId
	 * 			id de l'etudiant
	 * @param validee
	 * 			vrai si absence validee faux sinon
	 * @param dateDebut
	 * 			date de debut de la periode de l'absence physique
	 * @param dateFin
	 * 			date de fin de la periode de l'absence physique
	 * @param lienVisio
	 * 			lien visio pour l'acces au cours a distance
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int validerAbsencePhysique(int absId, int grpId, int etuId, boolean validee,
			String dateDebut, String dateFin) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_AbsencePhysique "
					+ "SET absPhys_valideeAdmin = ? "
					+ "WHERE absPhys_id = ? AND absPhys_valideeAdmin IS NULL");

			if(validee)
				ps.setString(1, "Validee");
			else
				ps.setString(1, "Invalidee");
			
			ps.setInt(2, absId);
			
			effectuee = ps.executeUpdate();
			
			if(effectuee != 0 && !validee) {
				ps.close();
				ps = con.prepareStatement("SELECT Lot2_Cours.cours_id, plan_date, plan_heureDebut, plan_heureFin "
						+ "FROM Lot2_Cours "
						+ "JOIN Lot2_PlanningGroupe ON Lot2_Cours.cours_id = Lot2_PlanningGroupe.cours_id "
						+ "JOIN Lot2_Groupe ON Lot2_PlanningGroupe.grp_id = Lot2_Groupe.grp_id "
						+ "WHERE grp_numero = ? AND plan_date BETWEEN ? AND ? ");
				ps.setInt(1, grpId);
				ps.setString(2, dateDebut);
				ps.setString(3, dateFin);

				ResultSet rs = ps.executeQuery();
				Date date = null;
				float nbHeures = 0;
				int idCours = 0;
				int idAbs = 0;
				
				while(rs.next()) {
					date = rs.getDate("plan_date");
					nbHeures = rs.getFloat("plan_heureFin") - rs.getFloat("plan_heureDebut");
					idCours = rs.getInt("cours_id");
					idAbs = actionGest.getLastIdTable(4)+1;
					
					ps = con.prepareStatement("INSERT INTO Lot2_Absence(abs_id, abs_date, abs_nbHeures, abs_cours_id, abs_type, abs_justificatif, abs_valideeAdmin) "
							+ "VALUES (?,?,?,?,'Physique','','') ");
					ps.setInt(1, idAbs);
					ps.setDate(2, date);
					ps.setFloat(3, nbHeures);
					ps.setInt(4, idCours);
					
					effectuee = ps.executeUpdate();
					
					ps = con.prepareStatement("INSERT INTO Lot2_AbsenceParEtudiant(abs_id, etu_id) "
							+ "VALUES (?,?) ");
					ps.setInt(1, idAbs);
					ps.setInt(2, etuId);
					
					effectuee = ps.executeUpdate();
				}
			}
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de verifier si l'absence examen a bien ete validee
	 * @param absId
	 * 			id de l'absence
	 * @return absenceExamen
	 * 			false si non validee, true sinon
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
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
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de declancher des ratrapages pour une absence a un examen
	 * @param absId
	 * 			id de l'absence
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
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
