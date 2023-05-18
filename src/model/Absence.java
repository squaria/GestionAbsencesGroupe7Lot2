package model;

/**
 * Classe modele java d'une absence
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Absence {

	/**
	 * Attribut de la date de l'absence
	 */
	private String date;
	/**
	 * Attribut du nombre d'heures de l'absence
	 */
	private Float nbHeures;

	/**
	 * Attribut du nom du cours de l'absence
	 */
	private String nomCours;

	/**
	 * Attribut de l'id du cours de l'absence
	 */
	private int coursId;
	
	private int absId;

	/**
	 * Attribut du nom de l'etudiant de l'absence
	 */
	private String nomEtu;

	/**
	 * Attribut du prenom de l'etudiant de l'absence
	 */
	private String prenomEtu;
	
	/**
	 * Attribut du nom du professeur de l'absence
	 */
	private String nomProf;

	/**
	 * Attribut du prenom du professeur de l'absence
	 */
	private String prenomProf;

	/**
	 * Attribut du type de l'absence
	 */
	private String type;
	
	/**
	 * Attribut du justificatif de l'absence
	 */
	private String justificatif;

	/**
	 * Attribut de la validation par l'administratif de l'absence
	 */
	private String valideeAdmin;

	/**
	 * Constructeur de la classe absence sans l'id du cours
	 * @param date 
	 * 			date de l'absence
	 * @param nbHeures 
	 * 			nombre d'heures de l'absence
	 * @param nomCours 
	 * 			nom du cours de l'absence
	 * @param type 
	 * 			type de l'absence
	 * @param justificatif 
	 * 			justificatif de l'absence
	 * @param valideeAdmin 
	 * 			validation par l'administratif de l'absence
	 */
	public Absence(String date, Float nbHeures, String nomCours, String type, String justificatif,
			String valideeAdmin) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.nomCours = nomCours;
		this.type = type;
		this.justificatif = justificatif;
		this.valideeAdmin = valideeAdmin;
	}

	/**
	 * Constructeur de la classe absence avec l'id du cours
	 * @param date 
	 * 			date de l'absence
	 * @param nbHeures 
	 * 			nombre d'heures de l'absence
	 * @param coursId 
	 * 			id du cours de l'absence
	 * @param type 
	 * 			type de l'absence
	 * @param justificatif 
	 * 			justificatif de l'absence
	 * @param valideeAdmin 
	 * 			validation par l'administratif de l'absence
	 */
	public Absence(String date, Float nbHeures, int coursId, String type, String justificatif, String valideeAdmin) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.coursId = coursId;
		this.type = type;
		this.justificatif = justificatif;
		this.valideeAdmin = valideeAdmin;
	}

	/**
	 * Constructeur de la classe absence sans l'id du cours
	 * @param date 
	 * 			date de l'absence
	 * @param nbHeures 
	 * 			nombre d'heures de l'absence
	 * @param nomCours 
	 * 			nom du cours de l'absence
	 * @param nomEtu 
	 * 			nom de l'etudiant de l'absence
	 * @param prenomEtu 
	 * 			prenom de l'etudiant de l'absence
	 * @param type 
	 * 			type de l'absence
	 * @param justificatif 
	 * 			justificatif de l'absence
	 * @param valideeAdmin 
	 * 			validation par l'administratif de l'absence
	 */
	public Absence(int absId, String date, Float nbHeures, String nomCours, String nomEtu, String prenomEtu, String type,
			String justificatif, String valideeAdmin) {
		this.absId = absId;
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
	 * Constructeur de la classe absence sans l'id du cours et sans l'intervention de l'administratif
	 * @param date 
	 * 			date de l'absence
	 * @param nbHeures 
	 * 			nombre d'heures de l'absence
	 * @param nomCours 
	 * 			nom du cours de l'absence
	 * @param type 
	 * 			type de l'absence
	 */
	public Absence(String date, Float nbHeures, String nomCours, String type) {
		this.date = date;
		this.nbHeures = nbHeures;
		this.nomCours = nomCours;
		this.type = type;
	}

	/**
	 * Constructeur de la classe absence pour la classe fille AbsencePhysique
	 * @param nomEtu 
	 * 			nom de l'etudiant de l'absence
	 * @param prenomEtu 
	 * 			prenom de l'etudiant de l'absence
	 * @param justificatif 
	 * 			justificatif de l'absence
	 * @param valideeAdmin 
	 * 			validation par l'administratif de l'absence
	 */
	public Absence(String nomEtu, String prenomEtu, String justificatif, String valideeAdmin) {
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.justificatif = justificatif;
		this.valideeAdmin = valideeAdmin;
	}
	
	/**
	 * Constructeur de la classe absence pour le prof remplacant
	 * @param nomProf
	 * 			nom du professeur de l'absence
	 * @param prenomProf
	 * 			prenom du professeur de l'absence
	 * @param nomCours 
	 * 			nom du cours de l'absence
	 * @param date
	 * 			date de l'absence
	 */
	public Absence(String nomProf, String prenomProf, String nomCours, String date, int I) {
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		this.nomCours = nomCours;
		this.date = date;
		I = 0;
	}
	
	/**
	 * Getter de la date de l'absence
	 * @return date
	 * 			date de l'absence
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter de la date de l'absence
	 * @param date
	 * 			date de l'absence
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Getter du nombre d'heures de l'absence
	 * @return nbHeures
	 * 			nombre d'heures de l'absence
	 */
	public Float getNbHeures() {
		return nbHeures;
	}

	/**
	 * Setter du nombre d'heures de l'absence
	 * @param nbHeures
	 * 			nombre d'heures de l'absence
	 */
	public void setNbHeures(Float nbHeures) {
		this.nbHeures = nbHeures;
	}

	/**
	 * Getter du type de l'absence
	 * @return type
	 * 			type de l'absence
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter du type de l'absence
	 * @param type
	 * 			type de l'absence
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter du justificatif de l'absence
	 * @return justificatif
	 * 			justificatif de l'absence
	 */
	public String getJustificatif() {
		return justificatif;
	}

	/**	 
	 * Setter du justificatif de l'absence
	 * @param justificatif
	 * 			justificatif de l'absence
	 */
	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}

	/**
	 * Getter de la validation par l'administratif de l'absence
	 * @return valideeAdmin
	 * 			validation par l'administratif de l'absence
	 */
	public String getValideeAdmin() {
		return valideeAdmin;
	}

	/**
	 * Setter de la validation par l'administratif de l'absence
	 * @param valideeAdmin
	 * 			validation par l'administratif de l'absence
	 */
	public void setValideeAdmin(String valideeAdmin) {
		this.valideeAdmin = valideeAdmin;
	}

	/**
	 * Getter du nom du cours de l'absence
	 * @return the nomCours
	 * 			nom du cours de l'absence
	 */
	public String getNomCours() {
		return nomCours;
	}

	/**
	 * Setter du nom du cours de l'absence
	 * @param nomCours
	 * 			nom du cours de l'absence
	 * 
	 */
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}

	/**
	 * Getter de l'id du cours de l'absence
	 * @return coursId
	 * 			id du cours de l'absence
	 */
	public int getCoursId() {
		return coursId;
	}

	/**
	 * Setter de l'id du cours de l'absence
	 * @param coursId
	 * 			id du cours de l'absence
	 */
	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}

	/**
	 * Getter du nom de l'etudiant de l'absence
	 * @return nomEtu
	 * 			nom de l'etudiant de l'absence
	 */
	public String getNomEtu() {
		return nomEtu;
	}

	/**
	 * Setter du nom de l'etudiant de l'absence
	 * @param nomEtu
	 * 			nom de l'etudiant de l'absence
	 */
	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}

	/**
	 * Getter du prenom de l'etudiant de l'absence
	 * @return prenomEtu
	 * 			prenom de l'etudiant de l'absence
	 */
	public String getPrenomEtu() {
		return prenomEtu;
	}

	/**
	 * Setter du prenom de l'etudiant de l'absence
	 * @param prenomEtu
	 * 			prenom de l'etudiant de l'absence
	 */
	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}

	/**
	 * Getter du nom du professeur de l'absence
	 * @return nomProf
	 * 			nom du professeur de l'absence
	 */
	public String getNomProf() {
		return nomProf;
	}

	/**
	 * Setter du nom du professeur de l'absence
	 * @param nomProf
	 * 			nom du professeur de l'absence
	 */
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	/**
	 * Getter du prenom du professeur de l'absence
	 * @return prenomProf
	 * 			prenom du professeur de l'absence
	 */
	public String getPrenomProf() {
		return prenomProf;
	}

	/**
	 * Setter du prenom du professeur de l'absence
	 * @param prenomProf
	 * 			prenom du professeur de l'absence
	 */
	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	/**
	 * Getter du prenom de l'id de l'absence
	 * @return the absId
	 * 			id de l'absence
	 */
	public int getAbsId() {
		return absId;
	}

	/**
	 * Setter du prenom de l'id de l'absence
	 * @param absId
	 * 			id de l'absence
	 */
	public void setAbsId(int absId) {
		this.absId = absId;
	}

}
