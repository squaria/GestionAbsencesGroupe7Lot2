package model;

/**
 * Classe modele java d'un profil professeur
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Professeur extends Profil {
	/**
	 * 
	 */
	private String numTelephone;

	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param numTelephone
	 */
	public Professeur(String nom, String prenom, String email, String numTelephone) {
		super(nom, prenom, email);
		this.numTelephone = numTelephone;
	}

	/**
	 * @return
	 */
	public String getNumTelephone() {
		return numTelephone;
	}

	/**
	 * @param numTelephone
	 */
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
}
