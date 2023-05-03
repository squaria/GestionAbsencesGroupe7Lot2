package model;

/**
 * Classe modele java d'un profil professeur
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Professeur extends Profil {
	
	/**
	 * Attribut du numero de telephone du profil Professeur
	 */
	private String numTelephone;

	/**
	 * Constructeur de la classe Professeur fille de la classe Profil
	 * @param nom
	 * 			nom du profil Professeur
	 * @param prenom
	 * 			prenom du profil Professeur
	 * @param email
	 * 			email du profil Professeur
	 * @param numTelephone
	 * 			numero de telephone du profil Professeur
	 */
	public Professeur(String nom, String prenom, String email, String numTelephone) {
		super(nom, prenom, email);
		this.numTelephone = numTelephone;
	}

	/**
	 * Getter du numero de telephone du profil Professeur
	 * @return numTelephone
	 * 			numero de telephone du profil Professeur
	 */
	public String getNumTelephone() {
		return numTelephone;
	}

	/**
	 * Setter du numero de telephone du profil Professeur
	 * @param numTelephone
	 * 			numero de telephone du profil Professeur
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
}
