package model;

/**
 * Classe modele java d'un profil etudiant
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Etudiant extends Profil {

	/**
	 * 
	 */
	private String filiere;
	
	/**
	 * 
	 */
	private int groupe;
	
	/**
	 * Constructeur de la classe Etudiant fille de la classe Profil
	 * @param nom
	 * 			nom du profil Etudiant
	 * @param prenom
	 * 			prenom du profil Etudiant
	 * @param email
	 * 			email du profil Etudiant
	 * @param filiere
	 * 			filiere du profil Etudiant
	 * @param groupe
	 * 			groupe du profil Etudiant
	 */
	public Etudiant(String nom, String prenom, String email, String filiere, int groupe)
	{
		super(nom, prenom, email);
		this.filiere = filiere;
		this.groupe = groupe;
	}

	/**
	 * Getter de la filiere du profil Etudiant
	 * @return filiere
	 * 			filiere du profil Etudiant
	 */
	public String getFiliere() {
		return filiere;
	}

	/**
	 * Setter de la filiere du profil Etudiant
	 * @param filiere
	 * 			filiere du profil Etudiant
	 */
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	/**
	 * Getter du groupe du profil Etudiant
	 * @return groupe
	 * 			groupe du profil Etudiant
	 */
	public int getGroupe() {
		return groupe;
	}

	/**
	 * Setter du groupe du profil Etudiant
	 * @param groupe
	 * 			groupe du profil Etudiant
	 */
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	
}
