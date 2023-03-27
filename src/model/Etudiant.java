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
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param filiere
	 * @param groupe
	 */
	public Etudiant(String nom, String prenom, String email, String filiere, int groupe)
	{
		super(nom, prenom, email);
		this.filiere = filiere;
		this.groupe = groupe;
	}

	/**
	 * @return
	 */
	public String getFiliere() {
		return filiere;
	}

	/**
	 * @param filiere
	 */
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	/**
	 * @return
	 */
	public int getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe
	 */
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	
	
}
