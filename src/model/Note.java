package model;

/**
 * Classe modele java d'une note d'un etudiant
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Note {
	
	/**
	 * Attribut de l'id de l'etudiant
	 */
	private int etuId;
	
	/**
	 * Attribut de l'id du cours
	 */
	private int coursId;
	
	/**
	 * Attribut du nom du cours
	 */
	private String coursNom;
	
	/**
	 * Attribut de la valeur de la note
	 */
	private float valeur;
	
	/**
	 * Attribut de la date de la note
	 */
	private String date;
	
	/**
	 * Attribut de la possibilite d'un rattrapage associe a la note
	 */
	private String rattrapage;
	
	
	/**
	 * Constructeur de la classe Note avec l'id de l'etudiant
	 * @param etuId
	 * 			l'id de l'etudiant
	 * @param coursId
	 * 			l'id du cours
	 * @param valeur
	 * 			la valeur de la note
	 * @param date
	 * 			la date de la note
	 * @param rattrapage
	 * 			la possibilite d'un rattrapage associe a la note
	 */
	public Note(int etuId, int coursId, float valeur, String date, String rattrapage) {
		this.etuId = etuId;
		this.coursId = coursId;
		this.valeur = valeur;
		this.date = date;
		this.rattrapage = rattrapage;
	}
	
	/**
	 * Constructeur de la classe Note avec le nom du cours
	 * @param coursNom
	 * 			nom du cours
	 * @param valeur
	 * 			la valeur de la note
	 * @param date
	 * 			la date de la note
	 * @param rattrapage
	 * 			la possibilite d'un rattrapage associe a la note
	 */
	public Note(String coursNom, float valeur, String date, String rattrapage) {
		this.coursNom = coursNom;
		this.valeur = valeur;
		this.date = date;
		this.rattrapage = rattrapage;
	}
	
	/**
	 * Getter de l'id de l'etudiant
	 * @return etuId
	 * 			id de l'etudiant
	 */
	public int getEtuId() {
		return etuId;
	}
	
	/**
	 * Setter de l'id de l'etudiant
	 * @param etuId
	 * 			id de l'etudiant
	 */
	public void setEtuId(int etuId) {
		this.etuId = etuId;
	}
	
	/**
	 * Getter de l'id du cours
	 * @return coursId
	 * 			id du cours
	 */
	public int getCoursId() {
		return coursId;
	}
	
	/**
	 * Setter de l'id du cours
	 * @param coursId
	 * 			id du cours
	 */
	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}
	
	/**
	 * Getter de la valeur de la note
	 * @return valeur
	 * 			la valeur de la note
	 */
	public float getValeur() {
		return valeur;
	}
	
	/**
	 * Setter de la valeur de la note
	 * @param valeur
	 * 			la valeur de la note
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Getter de la date de la note
	 * @return date
	 * 			la date de la note
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Setter de la date de la note
	 * @param date
	 * 			la date de la note
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Getter de la possibilite d'un rattrapage associe a la note
	 * @return rattrapage
	 * 			la possibilite d'un rattrapage associe a la note
	 */
	public String getRattrapage() {
		return rattrapage;
	}
	
	/**
	 * Setter de la possibilite d'un rattrapage associe a la note
	 * @param rattrapage
	 * 			la possibilite d'un rattrapage associe a la note
	 */
	public void setRattrapage(String rattrapage) {
		this.rattrapage = rattrapage;
	}
	
	/**
	 * Getter du nom du cours
	 * @return coursNom
	 * 			nom du cours
	 */
	public String getCoursNom() {
		return coursNom;
	}
	
	/**
	 * Setter du nom du cours
	 * @param coursNom
	 * 			nom du cours
	 */
	public void setCoursNom(String coursNom) {
		this.coursNom = coursNom;
	}
	
}
