package model;

/**
 * Classe modele java d'un cours
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Cours {
	/**
	 * 
	 */
	private String nom;
	/**
	 * 
	 */
	private String enseignant;
	/**
	 * 
	 */
	private int nbHeuresAmphi;
	/**
	 * 
	 */
	private int nbHeuresTD;
	/**
	 * 
	 */
	private int nbHeuresTP;
	/**
	 * 
	 */
	private int nbHeuresExamen;
	
	/**
	 * @param nom
	 * @param enseignant
	 * @param nbHeuresAmphi
	 * @param nbHeuresTD
	 * @param nbHeuresTP
	 * @param nbHeuresExamen
	 */
	public Cours(String nom, String enseignant, int nbHeuresAmphi, int nbHeuresTD, int nbHeuresTP, int nbHeuresExamen) {
		this.nom = nom;
		this.enseignant = enseignant;
		this.nbHeuresAmphi = nbHeuresAmphi;
		this.nbHeuresTD = nbHeuresTD;
		this.nbHeuresTP = nbHeuresTP;
		this.nbHeuresExamen = nbHeuresExamen;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public String getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant
	 */
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	/**
	 * @return
	 */
	public int getNbHeuresAmphi() {
		return nbHeuresAmphi;
	}

	/**
	 * @param nbHeuresAmphi
	 */
	public void setNbHeuresAmphi(int nbHeuresAmphi) {
		this.nbHeuresAmphi = nbHeuresAmphi;
	}

	/**
	 * @return
	 */
	public int getNbHeuresTD() {
		return nbHeuresTD;
	}

	/**
	 * @param nbHeuresTD
	 */
	public void setNbHeuresTD(int nbHeuresTD) {
		this.nbHeuresTD = nbHeuresTD;
	}

	/**
	 * @return
	 */
	public int getNbHeuresTP() {
		return nbHeuresTP;
	}

	/**
	 * @param nbHeuresTP
	 */
	public void setNbHeuresTP(int nbHeuresTP) {
		this.nbHeuresTP = nbHeuresTP;
	}

	/**
	 * @return
	 */
	public int getNbHeuresExamen() {
		return nbHeuresExamen;
	}

	/**
	 * @param nbHeuresExamen
	 */
	public void setNbHeuresExamen(int nbHeuresExamen) {
		this.nbHeuresExamen = nbHeuresExamen;
	}
	
	
}
