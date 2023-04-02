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
	private Float nbHeures;
	
	/**
	 * 
	 */
	private String nomCours;
	
	private int coursId;
	
	private String nomEtu;
	
	private String prenomEtu;
	
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
	public Absence(String date, Float nbHeures, String nomCours, String type, String justificatif, String valideeAdmin) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.nomCours = nomCours;
		this.type = type;
		this.justificatif = justificatif;
		this.valideeAdmin = valideeAdmin;
	}
	
	public Absence(String date, Float nbHeures, int coursId, String type, String justificatif, String valideeAdmin) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.coursId = coursId;
		this.type = type;
		this.justificatif = justificatif;
		this.valideeAdmin = valideeAdmin;
	}
	
	public Absence(String date, Float nbHeures, String nomCours, String nomEtu, String prenomEtu, String type, String justificatif, String valideeAdmin) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.nomCours = nomCours;
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
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
	public Float getNbHeures() {
		return nbHeures;
	}

	/**
	 * @param nbHeures
	 */
	public void setNbHeures(Float nbHeures) {
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

	public int getCoursId() {
		return coursId;
	}

	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}

	public String getNomEtu() {
		return nomEtu;
	}

	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}

	public String getPrenomEtu() {
		return prenomEtu;
	}

	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}
	
	
}
