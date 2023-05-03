package model;

/**
 * Classe modele java d'un profil administratif
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Administratif extends Profil {

	/**
	 * Constructeur de la classe Administratif fille de la classe Profil
	 * @param nom
	 * 			nom du profil administratif
	 * @param prenom
	 * 			prenom du profil administratif
	 * @param email
	 * 			email du profil administratif
	 */
	public Administratif(String nom, String prenom, String email) {
		super(nom, prenom, email);
	}
}
