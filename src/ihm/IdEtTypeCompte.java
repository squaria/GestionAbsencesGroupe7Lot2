package ihm;

/**
 * Classe contenant l'id et le type de compte 
 * enregistre en statique apres connexion
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class IdEtTypeCompte {
	
	/**
	 * Attribut statique de l'id de la table SQL du compte connecte
	 */
	public static int id = 1;

	/**
	 * Attribut statique du type de compte connecte
	 * 0 : etu, 1 : prof, 2: admin, 3: gest
	 */
	public static int typeCompte = 2;
}
