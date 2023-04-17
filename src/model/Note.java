package model;

public class Note {
	private int etuId;
	private int coursId;
	private float valeur;
	private String date;
	public Note(int etuId, int coursId, float valeur, String date) {
		this.etuId = etuId;
		this.coursId = coursId;
		this.valeur = valeur;
		this.date = date;
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
	
	

}
