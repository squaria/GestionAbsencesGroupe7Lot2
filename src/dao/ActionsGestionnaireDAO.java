package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Administratif;
import model.Cours;
import model.Etudiant;
import model.Groupe;
import model.PlanningGroupe;
import model.Professeur;
import model.Profil;

/**
 * Classe DAO de lien avec la base de donnee 
 * pour les actions du gestionnaire
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class ActionsGestionnaireDAO extends IdentificationBdd {
	
	/**
	 * Constructeur de la classe ActionsGestionnaireDAO
	 */
	public ActionsGestionnaireDAO() {
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de supprimer un utilisateur
	 * @param profil
	 * 			profil d'un utilisateur
	 * @param typeUtilisateur
	 * 			type de l'utilisateur
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int suppr(Profil profil, int typeUtilisateur) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;

			int effectuee = 0;
			
			switch(typeUtilisateur) {
			case 0:
				ps = con.prepareStatement("DELETE FROM Lot2_Etudiant "
						+ "WHERE etu_nom = ? AND etu_prenom = ? AND etu_email = ?");
				break;
			case 1:
				ps = con.prepareStatement("DELETE FROM Lot2_Professeur "
						+ "WHERE prof_nom = ? AND prof_prenom = ? AND prof_email = ?");
				break;
			case 2:
				ps = con.prepareStatement("DELETE FROM Lot2_Administratif "
						+ "WHERE admin_nom = ? AND admin_prenom = ? AND admin_email = ?");
				break;
			}
			ps.setString(1, profil.getNom());
			ps.setString(2, profil.getPrenom());
			ps.setString(3, profil.getEmail());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de supprimer un cours
	 * @param nomCours
	 * 			nom du cours
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int supprCours(String nomCours) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("DELETE FROM Lot2_Cours "
					+ "WHERE cours_nom = ?");;

			ps.setString(1, nomCours);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des cours
	 * @return listeCours
	 * 			liste des cours
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<Cours> listeCours() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			ArrayList<Cours> listeCours = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT cours_nom, prof_nom, "
					+ "cours_NbHeuresAmphi, cours_NbHeuresTD, "
					+ "cours_NbHeuresTP, cours_NbHeuresExamen "
					+ "FROM Lot2_Cours "
					+ "JOIN Lot2_Professeur ON cours_prof_id = prof_id "
					+ "ORDER BY cours_id ASC");

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				listeCours.add(new Cours(rs.getString("cours_nom"), rs.getString("prof_nom"), 
						rs.getFloat("cours_NbHeuresAmphi"), rs.getFloat("cours_NbHeuresTD"), 
						rs.getFloat("cours_NbHeuresTP"), rs.getFloat("cours_NbHeuresExamen")));
			}
			
			return listeCours;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des groupes pour un cours
	 * @param coursId
	 * 			id du cours
	 * @return listeGroupe
	 * 			liste des groupes pour un cours
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<Groupe> getListeGroupeCours(int coursId) throws Exception {
			
			try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
				ArrayList<Groupe> listeGroupe = new ArrayList<>();
				PreparedStatement ps = con.prepareStatement("SELECT DISTINCT grp_numero, grp_capaciteMax "
						+ "FROM Lot2_Cours "
						+ "JOIN Lot2_PlanningGroupe ON Lot2_PlanningGroupe.cours_id = Lot2_Cours.cours_id "
						+ "JOIN Lot2_Groupe ON Lot2_PlanningGroupe.grp_id = Lot2_Groupe.grp_id "
						+ "WHERE Lot2_Cours.cours_id = ? "
						+ "ORDER BY grp_numero ASC");
				ps.setInt(1, coursId);
	
				
				ResultSet rs = ps.executeQuery();
	
				while(rs.next()) {
					listeGroupe.add(new Groupe(rs.getInt("grp_numero"), rs.getInt("grp_capaciteMax")));
				}
			return listeGroupe;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des professeurs
	 * @return listeProf
	 * 			liste des professeurs
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<Professeur> getListeProfesseur() throws Exception {
		
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			ArrayList<Professeur> listeProf = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT prof_id, prof_nom, prof_prenom, prof_email, prof_numTelephone "
					+ "FROM Lot2_Professeur "
					+ "ORDER BY prof_id ASC");
	
			
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				listeProf.add(new Professeur(rs.getString("prof_nom"), rs.getString("prof_prenom"), 
						rs.getString("prof_email"), rs.getString("prof_numTelephone")));
			}
		return listeProf;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir la liste des etudiants
	 * @return listeEtudiant
	 * 			liste des etudiants
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public ArrayList<Etudiant> getListeEtudiant() throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			
			ArrayList<Etudiant> listeEtudiant = new ArrayList<>();
			PreparedStatement ps = con.prepareStatement("SELECT etu_id, etu_nom, etu_prenom, etu_email, fil_nom, grp_numero "
					+ "FROM Lot2_Etudiant "
					+ "JOIN Lot2_Filiere ON fil_id = etu_fil_id "
					+ "JOIN Lot2_Groupe ON grp_id = etu_grp_id "
					+ "ORDER BY etu_id ASC");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				listeEtudiant.add(new Etudiant(rs.getString("etu_nom"), rs.getString("etu_prenom"),
						rs.getString("etu_email"), rs.getString("fil_nom"), rs.getInt("grp_numero")));
			}
			
			return listeEtudiant;
		}
	}

	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir les informations d'un etudiant
	 * @param profil
	 * 			profil d'un etudiant
	 * @return etudiant
	 * 			informations d'un etudiant
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public Etudiant getEtudiant(Profil profil) throws Exception {
		
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			Etudiant etudiant = null;
			
			PreparedStatement ps = con.prepareStatement("SELECT etu_nom, etu_prenom, etu_email, grp_numero, fil_nom FROM Lot2_Etudiant "
						+ "JOIN Lot2_Filiere ON etu_fil_id = fil_id "
						+ "JOIN Lot2_Groupe ON etu_grp_id = grp_id "
						+ "WHERE etu_nom = ? AND etu_prenom = ? AND etu_email = ?");
			ps.setString(1, profil.getNom());
			ps.setString(2, profil.getPrenom());
			ps.setString(3, profil.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				etudiant = new Etudiant(profil.getNom(), profil.getPrenom(), profil.getEmail(),
						rs.getString("fil_nom"), rs.getInt("grp_numero"));
			}
		return etudiant;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir les informations d'un professeur
	 * @param profil
	 * 			profil d'un professeur
	 * @return professeur
	 * 			informations d'un professeur
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public Professeur getProfesseur(Profil profil) throws Exception {
		
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			Professeur professeur = null;
			
			PreparedStatement ps = con.prepareStatement("SELECT prof_nom, prof_prenom, prof_email, prof_numTelephone "
					+ "FROM Lot2_Professeur "
					+ "WHERE prof_nom = ? AND prof_prenom = ? AND prof_email = ?");
			ps.setString(1, profil.getNom());
			ps.setString(2, profil.getPrenom());
			ps.setString(3, profil.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				professeur = new Professeur(profil.getNom(), profil.getPrenom(), profil.getEmail(),
						rs.getString("prof_numTelephone"));
			}
		return professeur;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir les informations d'un administratif
	 * @param profil
	 * 			profil d'un administratif
	 * @return administratif
	 * 			informations d'un administratif
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public Administratif getAdministratif(Profil profil) throws Exception {
		
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			Administratif administratif = null;
			
			PreparedStatement ps = con.prepareStatement("SELECT admin_nom, admin_prenom, admin_email "
					+ "FROM Lot2_Administratif "
					+ "WHERE admin_nom = ? AND admin_prenom = ? AND admin_email = ?");
			ps.setString(1, profil.getNom());
			ps.setString(2, profil.getPrenom());
			ps.setString(3, profil.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				administratif = new Administratif(profil.getNom(), profil.getPrenom(), profil.getEmail());
			}
		return administratif;
		}
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de modifier un profil etudiant
	 * @param profil
	 * 			profil d'un etudiant
	 * @param etudiant
	 * 			informations d'un etudiant
	 * @param pwd
	 * 			mot de passe du compte
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int modEtudiant(Profil profil, Etudiant etudiant, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			int filiere = 1;
			
			if(etudiant.getFiliere().equals("Apprentissage"))
				filiere = 2;
			
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Etudiant "
					+ "SET etu_nom = NVL(?, etu_nom), etu_prenom = NVL(?, etu_prenom), etu_pwd = NVL(?, etu_pwd), "
					+ "etu_email = NVL(?, etu_email), etu_fil_id = NVL(NULLIF(?,0), etu_fil_id), etu_grp_id = NVL(NULLIF(?,0), etu_grp_id)"
					+ "WHERE etu_nom = ? AND etu_prenom = ? AND etu_email = ?");

		
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, pwd);
			ps.setString(4, etudiant.getEmail());
			ps.setInt(5, filiere);
			ps.setInt(6, etudiant.getGroupe());
			ps.setString(7, profil.getNom());
			ps.setString(8, profil.getPrenom());
			ps.setString(9, profil.getEmail());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de modifier un profil professeur
	 * @param profil
	 * 			profil d'un professeur
	 * @param professeur
	 * 			informations d'un professeur
	 * @param pwd
	 * 			mot de passe du compte
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int modProfesseur(Profil profil, Professeur professeur, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Professeur "
					+ "SET prof_nom = NVL(?, prof_nom), prof_prenom = NVL(?, prof_prenom), prof_pwd = NVL(?, prof_pwd), "
					+ "prof_email = NVL(?, prof_email), prof_numTelephone = NVL(?, prof_numTelephone) "
					+ "WHERE prof_nom = ? AND prof_prenom = ? AND prof_email = ?");

			
			ps.setString(1, professeur.getNom());
			ps.setString(2, professeur.getPrenom());
			ps.setString(3, pwd);
			ps.setString(4, professeur.getEmail());
			ps.setString(5, professeur.getNumTelephone());
			ps.setString(6, profil.getNom());
			ps.setString(7, profil.getPrenom());
			ps.setString(8, profil.getEmail());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de modifier un profil administratif
	 * @param profil
	 * 			profil d'un administratif
	 * @param administratif
	 * 			informations d'un administratif
	 * @param pwd
	 * 			mot de passe du compte
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int modAdministratif(Profil profil, Administratif administratif, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Administratif "
					+ "SET admin_nom = NVL(?, admin_nom), admin_prenom = NVL(?, admin_prenom), "
					+ "admin_pwd = NVL(?, admin_pwd), admin_email = NVL(?, admin_email) "
					+ "WHERE admin_nom = ? AND admin_prenom = ? AND admin_email = ?");

			
			ps.setString(1, administratif.getNom());
			ps.setString(2, administratif.getPrenom());
			ps.setString(3, pwd);
			ps.setString(4, administratif.getEmail());
			ps.setString(5, profil.getNom());
			ps.setString(6, profil.getPrenom());
			ps.setString(7, profil.getEmail());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de modifier un cours
	 * @param cours
	 * 			informations d'un cours
	 * @param nomCours
	 * 			nom du cours
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int modCours(Cours cours, String nomCours) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("UPDATE Lot2_Cours "
					+ "SET cours_nom = NVL(?, cours_nom), cours_prof_id = NVL(NULLIF(?,0), cours_prof_id), "
					+ "cours_NbHeuresAmphi = NVL(NULLIF(?,0.0), cours_NbHeuresAmphi), cours_NbHeuresTD = NVL(NULLIF(?,0.0), cours_NbHeuresTD), "
					+ "cours_NbHeuresTP = NVL(NULLIF(?,0.0), cours_NbHeuresTP), cours_NbHeuresExamen = NVL(NULLIF(?,0.0), cours_NbHeuresExamen) "
					+ "WHERE cours_nom = ?");

			ps.setString(1, cours.getNom());
			ps.setInt(2, cours.getEnseignantId());
			ps.setFloat(3, cours.getNbHeuresAmphi());
			ps.setFloat(4, cours.getNbHeuresTD());
			ps.setFloat(5, cours.getNbHeuresTP());
			ps.setFloat(6, cours.getNbHeuresExamen());
			ps.setString(7, nomCours);
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'obtenir le dernier id d'une table
	 * @param table
	 * 			selection de la table
	 * @return lastIdTable
	 * 			dernier id d'une table
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int getLastIdTable(int table) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;
			int lastIdTable = 0;
			
			switch(table) {
			case 0:
				ps = con.prepareStatement("SELECT etu_id FROM Lot2_Etudiant");
				break;
			case 1:
				ps = con.prepareStatement("SELECT prof_id FROM Lot2_Professeur");
				break;
			case 2:
				ps = con.prepareStatement("SELECT admin_id FROM Lot2_Administratif");
				break;
			case 3:
				ps = con.prepareStatement("SELECT cours_id FROM Lot2_Cours");
				break;
			case 4:
				ps = con.prepareStatement("SELECT abs_id FROM Lot2_Absence");
				break;
			case 5:
				ps = con.prepareStatement("SELECT grp_id FROM Lot2_Groupe");
				break;
			case 6:
				ps = con.prepareStatement("SELECT absPhys_id FROM Lot2_AbsencePhysique");
				break;				
			}
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				lastIdTable++;
			}
			
			return lastIdTable;
		}
		
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de creer un compte etudiant
	 * @param etudiant
	 * 			information d'un compte etudiant
	 * @param pwd
	 * 			mot de passe du compte
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int creerEtudiant(Etudiant etudiant, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;

			int effectuee = 0;
			int filiere = 1;
			
			if(etudiant.getFiliere().equals("Apprentissage"))
				filiere = 2;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Etudiant "
					+ "VALUES (?,?,?,?,?,?,?)");

			ps.setInt(1, getLastIdTable(0)+1);
			ps.setString(2, etudiant.getNom());
			ps.setString(3, etudiant.getPrenom());
			ps.setString(4, pwd);
			ps.setString(5, etudiant.getEmail());
			ps.setInt(6, filiere);
			ps.setInt(7, etudiant.getGroupe());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de creer un compte professeur
	 * @param professeur
	 * 			information d'un compte professeur
	 * @param pwd
	 * 			mot de passe du compte
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int creerProfesseur(Professeur professeur, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;

			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Professeur "
					+ "VALUES (?,?,?,?,?,?)");

			ps.setInt(1, getLastIdTable(1)+1);
			ps.setString(2, professeur.getNom());
			ps.setString(3, professeur.getPrenom());
			ps.setString(4, pwd);
			ps.setString(5, professeur.getEmail());
			ps.setString(6, professeur.getNumTelephone());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de creer un compte administratif
	 * @param administratif
	 * 			information d'un compte administratif
	 * @param pwd
	 * 			mot de passe du compte
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int creerAdministratif(Administratif administratif, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;

			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Administratif "
					+ "VALUES (?,?,?,?,?)");

			ps.setInt(1, getLastIdTable(2)+1);
			ps.setString(2, administratif.getNom());
			ps.setString(3, administratif.getPrenom());
			ps.setString(4, pwd);
			ps.setString(5, administratif.getEmail());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de creer un cours
	 * @param cours
	 * 			informations d'un cours
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int creerCours(Cours cours) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;

			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Cours "
					+ "VALUES (?,?,?,?,?,?,?)");
			
			ps.setInt(1, getLastIdTable(3)+1);
			ps.setString(2, cours.getNom());
			ps.setInt(3, cours.getEnseignantId());
			ps.setFloat(4, cours.getNbHeuresAmphi());
			ps.setFloat(5, cours.getNbHeuresTD());
			ps.setFloat(6, cours.getNbHeuresTP());
			ps.setFloat(7, cours.getNbHeuresExamen());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de creer un groupe
	 * @param groupe
	 * 			informations d'un groupe d'etudiants
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int creerGroupe(Groupe groupe) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			PreparedStatement ps = null;

			int effectuee = 0;
			
			ps = con.prepareStatement("INSERT INTO Lot2_Groupe "
					+ "VALUES (?,?,?)");
			
			ps.setInt(1, groupe.getGrpNum());
			ps.setInt(2, groupe.getGrpNum());
			ps.setInt(3, groupe.getCapaciteMax());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de savoir si un groupe est deja cree
	 * @param grp
	 * 			le groupe a tester
	 * @return grpExiste
	 * 			faux s'il n'existe pas deja, vrai sinon
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public boolean isGrpDejaCree(int grp) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			boolean grpExiste = false;
			
			PreparedStatement ps = con.prepareStatement("SELECT grp_numero FROM Lot2_Groupe");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				if(grp == rs.getInt("grp_numero"))
					grpExiste = true;
			}
			
			return grpExiste;
		}
		
	} 
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant d'ajouter un cours a un planning de groupe
	 * @param planningGroupe
	 * 			planning de groupe
	 * @return effectuee
	 * 			nombre de lignes retournee par l'execution de la requete SQL
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int ajouterCoursPlanning(PlanningGroupe planningGroupe) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int effectuee = 0;
			PreparedStatement ps = con.prepareStatement("INSERT INTO Lot2_PlanningGroupe "
					+ "VALUES (?,?,?,?,?,'')");
			ps.setInt(1, planningGroupe.getGrpId());
			ps.setInt(2, planningGroupe.getCoursId());
			ps.setString(3, planningGroupe.getDate());
			ps.setFloat(4, planningGroupe.getHeureDebut());
			ps.setFloat(5, planningGroupe.getHeureFin());
			
			effectuee = ps.executeUpdate();
			
			return effectuee;
			}
		}
}
