package model;

/**
 * Classe modele java d'un cours
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
/**
 * @author Squaria
 *
 */
public class Cours {
	
	/**
	 * Attribut du nom du cours
	 */
	private String nom;
	
	/**
	 * Attribut de l'id de l'enseignant associe au cours
	 */
	private int enseignantId;
	
	/**
	 * Attribut du nom de l'enseignant associe au cours
	 */
	private String enseignantNom;
	
	/**
	 * Attribut du nombre d'heures en amphi du cours
	 */
	private float nbHeuresAmphi;
	
	/**
	 * Attribut du nombre d'heures en TD du cours
	 */
	private float nbHeuresTD;
	
	/**
	 * Attribut du nombre d'heures en TP du cours
	 */
	private float nbHeuresTP;
	
	/**
	 * Attribut du nombre d'heures en Examen du cours
	 */
	private float nbHeuresExamen;
	
	/**
	 * Constructeur de la classe Cours avec l'id de l'enseignant
	 * @param nom
	 * 			nom du cours
	 * @param enseignantId
	 * 			id de l'enseignant associe au cours
	 * @param nbHeuresAmphi
	 * 			nombre d'heures en amphi du cours
	 * @param nbHeuresTD
	 * 			nombre d'heures en TD du cours
	 * @param nbHeuresTP
	 * 			nombre d'heures en TP du cours
	 * @param nbHeuresExamen
	 * 			nombre d'heures en Examen du cours
	 */
	public Cours(String nom, int enseignantId,
			float nbHeuresAmphi, float nbHeuresTD, float nbHeuresTP, float nbHeuresExamen) {
		this.nom = nom;
		this.enseignantId = enseignantId;
		this.nbHeuresAmphi = nbHeuresAmphi;
		this.nbHeuresTD = nbHeuresTD;
		this.nbHeuresTP = nbHeuresTP;
		this.nbHeuresExamen = nbHeuresExamen;
	}
	
	/**
	 * Constructeur de la classe Cours avec l'id de l'enseignant
	 * @param nom
	 * 			nom du cours
	 * @param enseignantNom
	 * 			nom de l'enseignant associe au cours
	 * @param nbHeuresAmphi
	 * 			nombre d'heures en amphi du cours
	 * @param nbHeuresTD
	 * 			nombre d'heures en TD du cours
	 * @param nbHeuresTP
	 * 			nombre d'heures en TP du cours
	 * @param nbHeuresExamen
	 * 			nombre d'heures en Examen du cours
	 */
	public Cours(String nom, String enseignantNom,
			float nbHeuresAmphi, float nbHeuresTD, float nbHeuresTP, float nbHeuresExamen) {
		this.nom = nom;
		this.enseignantNom = enseignantNom;
		this.nbHeuresAmphi = nbHeuresAmphi;
		this.nbHeuresTD = nbHeuresTD;
		this.nbHeuresTP = nbHeuresTP;
		this.nbHeuresExamen = nbHeuresExamen;
	}

	/**
	 * Constructeur de la classe Cours vide
	 */
	public Cours() {
	}

	/**
	 * Getter du nom du cours
	 * @return nom
	 * 			nom du cours
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter du nom du cours
	 * @param nom
	 * 			nom du cours
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de l'id de l'enseignant associe au cours
	 * @return enseignantId
	 * 			id de l'enseignant associe au cours
	 */
	public int getEnseignantId() {
		return enseignantId;
	}

	/**
	 * Setter de l'id de l'enseignant associe au cours
	 * @param enseignant
	 * 			id de l'enseignant associe au cours
	 */
	public void setEnseignantId(int enseignantId) {
		this.enseignantId = enseignantId;
	}
	
	/**
	 * Getter du nombre d'heures en amphi du cours
	 * @return nbHeuresAmphi
	 * 			nombre d'heures en amphi du cours
	 */
	public float getNbHeuresAmphi() {
		return nbHeuresAmphi;
	}

	/**
	 * Setter du nombre d'heures en amphi du cours
	 * @param nbHeuresAmphi
	 * 			nombre d'heures en amphi du cours
	 */
	public void setNbHeuresAmphi(float nbHeuresAmphi) {
		this.nbHeuresAmphi = nbHeuresAmphi;
	}

	/**
	 * Getter du nombre d'heures en TD du cours
	 * @return nbHeuresTD
	 * 			nombre d'heures en TD du cours
	 */
	public float getNbHeuresTD() {
		return nbHeuresTD;
	}

	/**
	 * Setter du nombre d'heures en TD du cours
	 * @param nbHeuresTD
	 * 			nombre d'heures en TD du cours
	 */
	public void setNbHeuresTD(float nbHeuresTD) {
		this.nbHeuresTD = nbHeuresTD;
	}

	/**
	 * Getter du nombre d'heures en TP du cours
	 * @return nbHeuresTP
	 * 			nombre d'heures en TP du cours
	 */
	public float getNbHeuresTP() {
		return nbHeuresTP;
	}

	/**
	 * Setter du nombre d'heures en TP du cours
	 * @param nbHeuresTP
	 * 			nombre d'heures en TP du cours
	 */
	public void setNbHeuresTP(float nbHeuresTP) {
		this.nbHeuresTP = nbHeuresTP;
	}

	/**
	 * Getter du nombre d'heures en Examen du cours
	 * @return nbHeuresExamen
	 * 			nombre d'heures en Examen du cours
	 */
	public float getNbHeuresExamen() {
		return nbHeuresExamen;
	}

	/**
	 * Setter du nombre d'heures en Examen du cours
	 * @param nbHeuresExamen
	 * 			nombre d'heures en Examen du cours
	 */
	public void setNbHeuresExamen(float nbHeuresExamen) {
		this.nbHeuresExamen = nbHeuresExamen;
	}

	/**
	 * Getter du nom de l'enseignant associe au cours
	 * @return the enseignantNom
	 * 			nom de l'enseignant associe au cours
	 */
	public String getEnseignantNom() {
		return enseignantNom;
	}

	/**
	 * Setter du nom de l'enseignant associe au cours
	 * @param enseignantNom
	 * 			nom de l'enseignant associe au cours
	 */
	public void setEnseignantNom(String enseignantNom) {
		this.enseignantNom = enseignantNom;
	}
	
	
	/**
	 * Methode pour la verification de format nombre reel a partir d'une chaine de caracteres
	 * @param heure
	 * 			chaine de caracteres heure
	 * @return isFloat
	 * 			true si la chaine est un format de nombre reel, false sinon
	 */
	public boolean isFloatHeure(String heure) {
		boolean isFloat = true;
		try {
			Float.parseFloat(heure);
		}
		catch (NumberFormatException e) {
			isFloat = false;
		}
		return isFloat;
	}
}
