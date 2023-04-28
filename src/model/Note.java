package model;

public class Note {
	private int etuId;
	private int coursId;
	private String coursNom;
	private float valeur;
	private String date;
	private String rattrapage;
	
	public Note(int etuId, int coursId, float valeur, String date, String rattrapage) {
		this.etuId = etuId;
		this.coursId = coursId;
		this.valeur = valeur;
		this.date = date;
		this.rattrapage = rattrapage;
	}
	
	public Note(String coursNom, float valeur, String date, String rattrapage) {
		this.coursNom = coursNom;
		this.valeur = valeur;
		this.date = date;
		this.rattrapage = rattrapage;
	}
	
	public int getEtuId() {
		return etuId;
	}
	public void setEtuId(int etuId) {
		this.etuId = etuId;
	}
	public int getCoursId() {
		return coursId;
	}
	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the rattrapage
	 */
	public String getRattrapage() {
		return rattrapage;
	}
	/**
	 * @param rattrapage the rattrapage to set
	 */
	public void setRattrapage(String rattrapage) {
		this.rattrapage = rattrapage;
	}
	/**
	 * @return the coursNom
	 */
	public String getCoursNom() {
		return coursNom;
	}
	/**
	 * @param coursNom the coursNom to set
	 */
	public void setCoursNom(String coursNom) {
		this.coursNom = coursNom;
	}
	
	

}
