package model;

//import java.util.ArrayList;

/**
 * Classe modele java d'un profil gestionnaire
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Gestionnaire extends Profil {

	/**
	 * Constructeur de la classe Gestionnaire fille de la classe mere Profil
	 * @param nom
	 * 			nom du profil Gestionnaire
	 * @param prenom
	 * 			prenom du profil Gestionnaire
	 * @param email
	 * 			email du profil Gestionnaire
	 */
	public Gestionnaire(String nom, String prenom, String email) {
		super(nom, prenom, email);
	}
}
