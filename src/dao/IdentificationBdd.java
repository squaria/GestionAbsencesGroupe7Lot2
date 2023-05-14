package dao;

/**
 * Classe DAO de lien avec la base de donnee 
 * pour la connexion a la base de donnee
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class IdentificationBdd {

	//String URL = "jdbc:oracle:thin:@//srvoracledb.intranet.int:1521/orcl.intranet.
	//final static String URL= "jdbc:oracle:thin:@//192.168.4.183:1521/orcl.intranet.int";
	
	/**
	 * Attribut statique de l'url de connexion a la base de donnee
	 */
	final static String URL = "jdbc:oracle:thin:@//oracle.esigelec.fr:1521/orcl.intranet.int";
	
	/**
	 * Attribut statique de l'identifiant de connexion a la base de donnee
	 */
	final static String LOGIN = "C##_G7_G4_APP";
	
	/**
	 * Attribut statique du mot de passe de connexion a la base de donnee
	 */
	final static String PWD = "APP_7_4";
}