package dao;

import java.sql.*;

public class ConnexionUtilisateurDAO extends IdentificationBdd {
	
	public ConnexionUtilisateurDAO() {
		super();
	}
	
	public int[] checkConnexion(String email, String pwd) throws Exception {
		try (Connection con = DriverManager.getConnection(URL, LOGIN, PWD);) {
			int[] returnValue = {-1,-1};
			String[] tabStatement = new String[]{
				"SELECT * FROM LOT2_Etudiant WHERE etu_email = ? AND etu_pwd = ?",
				"SELECT * FROM LOT2_Professeur WHERE prof_email = ? AND prof_pwd = ?",
				"SELECT * FROM LOT2_Administratif WHERE admin_email = ? AND admin_pwd = ?",
				"SELECT * FROM LOT2_Gestionnaire WHERE gest_email = ? AND gest_pwd = ?"
			};
			
			for(int i = 0; i<3; i++) {
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
