package dao;

import java.sql.*;

/**
 * Classe DAO de lien avec la base de donnee 
 * pour la connexion utilisateur
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class ConnexionUtilisateurDAO extends IdentificationBdd {
	
	/**
	 * Constructeur de la classe ConnexionUtilisateurDAO
	 */
	public ConnexionUtilisateurDAO() {
	}
	
	/**
	 * Methode de jointure entre le logiciel java et la BDD Oracle 
	 * permettant de comparer les identifiants de connexion entres par
	 * l'utilisateur a ceux dans la BDD
	 * @param email
	 * 			email entre par l'utilisateur
	 * @param pwd
	 * 			mot de passe entre par l'utilisateur
	 * @return returnValue
	 * 			tableau de valeurs dont la premiere represente le type de compte
	 * 			et la deuxieme l'id de l'utilisateur
	 * @throws Exception
	 * 			dans le cas d'une erreur SQL ou d'une erreur de connexion a la BDD
	 */
	public int[] checkConnexion(String email, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int[] returnValue = {-1,-1};
			String[] tabStatement = new String[]{
				"SELECT * FROM LOT2_Etudiant WHERE etu_email = ? AND etu_pwd = ?",
				"SELECT * FROM LOT2_Professeur WHERE prof_email = ? AND prof_pwd = ?",
				"SELECT * FROM LOT2_Administratif WHERE admin_email = ? AND admin_pwd = ?",
				"SELECT * FROM LOT2_Gestionnaire WHERE gest_email = ? AND gest_pwd = ?"
			};
			
			for(int i = 0; i<4; i++) {
				PreparedStatement ps = con.prepareStatement(tabStatement[i]);
				ps.setString(1, email);
				ps.setString(2, pwd);
				
				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				ResultSet rs = ps.executeQuery();
				// passe a la premiere (et unique) ligne retournee
				if (rs.next()) {
					returnValue[0] = i;
					switch(i) {
					case 0:
						returnValue[1] = rs.getInt("etu_id");
						break;
					case 1:
						returnValue[1] = rs.getInt("prof_id");
						break;
					case 2:
						returnValue[1] = rs.getInt("admin_id");
						break;
					case 3:
						returnValue[1] = rs.getInt("gest_id");
						break;
					}
				}
			}
		return returnValue;
		}
	}
}
