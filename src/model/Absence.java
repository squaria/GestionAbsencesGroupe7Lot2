package model;

/**
 * Classe modele java d'une absence
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Absence {
	
	/**
	 * 
	 */
	private String date;
	/**
	 * 
	 */
	private double nbHeures;
	
	/**
	 * 
	 */
	private String nomCours;
	
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String justificatif;
	
	/**
	 * 
	 */
	private String valideeAdmin;
	
	/**
	 * @param date
	 * @param nbHeures
	 * @param type
	 * @param justificatif
	 */
	public Absence(String date, double nbHeures, String nomCours, String type, String justificatif, String valideeAdmin) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.nomCours = nomCours;
		this.type = type;
		this.justificatif = justificatif;
		this.valideeAdmin = valideeAdmin;
	}

	/**
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public double getNbHeures() {
		return nbHeures;
	}

	/**
	 * @param nbHeures
	 */
	public void setNbHeures(double nbHeures) {
		this.nbHeures = nbHeures;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public void detectionDuType() {
		if (type=="Absence classique")
			System.out.println("C'est une absence classique à un cours, un Td ou un Tp en présentiel");
		else {
			if (type=="Absence à distance")
				System.out.println("C'est une absence à un cours, un Td ou un Tp lors de la periode de fermeture de l'école");
			else
				System.out.println("Votre absence n'est pas répertoriéé");
		}
	}
	/**
	 * @return
	 */
	public String getJustificatif() {
		return justificatif;
	}

	/**
	 * @param justificatif
	 */
	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}

	
	/**
	 * @return
	 */
	public String getValideeAdmin() {
		return valideeAdmin;
	}

	/**
	 * @param valideeAdmin
	 */
	public void setValideeAdmin(String valideeAdmin) {
		this.valideeAdmin = valideeAdmin;
	}

	/**
	 * @return the nomCours
	 */
	public String getNomCours() {
		return nomCours;
	}

	/**
	 * @param nomCours the nomCours to set
	 */
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	
	
}
