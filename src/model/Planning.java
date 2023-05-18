package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe modele java d'un planning
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Planning {
	
	/**
	 * Attribut de l'id du groupe d'etudiants
	 */
	protected int grpId;
	
	/**
	 * Attribut de l'id du cours
	 */
	protected int coursId;
	
	/**
	 * Attribut du nom du cours
	 */
	protected String coursNom;
	
	/**
	 * Attribut de la date du planning
	 */
	protected String date;
	
	/**
	 * Attribut de l'heure du debut de cours
	 */
	protected float heureDebut;
	
	/**
	 * Attribut de l'heure de fin de cours
	 */
	protected float heureFin;
	
	
	/**
	 * Constructeur de la Classe mere Planning avec l'id du groupe et du cours
	 * @param grpId
	 * 			id du groupe d'etudiants
	 * @param coursId
	 * 			id du cours
	 * @param date
	 * 			date du planning
	 * @param heureDebut
	 * 			heure du debut de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public Planning(int grpId, int coursId, String date, float heureDebut, float heureFin) {
		this.grpId = grpId;
		this.coursId = coursId;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	/**
	 * Constructeur de la Classe mere Planning avec l'id du groupe et le nom du cours
	 * @param grpId
	 * 			id du groupe d'etudiants
	 * @param coursNom
	 * 			nom du cours
	 * @param date
	 * 			date du planning
	 * @param heureDebut
	 * 			heure du debut de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public Planning(int grpId, String coursNom, String date, float heureDebut, float heureFin) {
		this.grpId = grpId;
		this.coursNom = coursNom;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	/**
	 * Constructeur de la Classe mere Planning avec le nom du cours
	 * @param coursNom
	 * 			nom du cours
	 * @param date
	 * 			date du planning
	 * @param heureDebut
	 * 			heure du debut de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public Planning(String coursNom, String date, float heureDebut, float heureFin) {
		this.coursNom = coursNom;;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	/**
	 * Constructeur de la Classe mere Planning vide
	 */
	public Planning() {
	}

	/**
	 * Getter de l'id du groupe d'etudiants
	 * @return grpId
	 * 			id du groupe d'etudiants
	 */
	public int getGrpId() {
		return grpId;
	}

	/**
	 * Setter de l'id du groupe d'etudiants
	 * @param grpId
	 * 			id du groupe d'etudiants
	 */
	public void setGrpId(int grpId) {
		this.grpId = grpId;
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

	/**
	 * Getter de la date du planning
	 * @return date 
	 * 			date du planning
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter de la date du planning
	 * @param date
	 * 			date du planning
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Getter de l'heure du debut de cours
	 * @return heureDebut
	 * 			heure du debut de cours
	 */
	public float getHeureDebut() {
		return heureDebut;
	}

	/**
	 * Setter de l'heure du debut de cours
	 * @param heureDebut
	 * 			heure du debut de cours
	 */
	public void setHeureDebut(float heureDebut) {
		this.heureDebut = heureDebut;
	}

	/**
	 * Getter de l'heure de fin de cours
	 * @return heureFin
	 * 			heure de fin de cours
	 */
	public float getHeureFin() {
		return heureFin;
	}

	/**
	 * Setter de l'heure de fin de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public void setHeureFin(float heureFin) {
		this.heureFin = heureFin;
	}
	
	/**
	 * Methode pour la verification de format nombre entier a partir d'une chaine de caracteres
	 * @param groupe
	 * 			le groupe d'etudiants
	 * @return isInt
	 * 			true si la chaine est un format de nombre entier, false sinon
	 */
	public boolean isIntGroupe(String groupe) {
		boolean isInt = true;
		try {
			Integer.parseInt(groupe);
		}
		catch (NumberFormatException e) {
			isInt = false;
		}
		return isInt;
	}
	
	/**
	 * Methode pour la verification de format nombre entier et date correcte a partir de JJ/MM/YYYY
	 * @param day
	 * 			le jour de la date
	 * @param month
	 * 			le mois de la date
	 * @param year
	 * 			l'annee de la date
	 * @return isInt
	 * 			true si la chaine est un format de nombre entier, false sinon
	 */
	public boolean isIntDay(String day, String month, String year) {
		boolean isInt = true;
		Calendar monthStart = new GregorianCalendar(intYear(year), intMonth(month) - 1, 1);
		try {
			if(Integer.parseInt(day) < 1 || Integer.parseInt(day) > monthStart.getActualMaximum(Calendar.DAY_OF_MONTH))
				isInt = false;
		}
		catch (NumberFormatException e) {
			isInt = false;
		}
		return isInt;
	}
	
	/**
	 * Methode pour la verification de format nombre entier et mois correct a partir d'une chaine de caracteres
	 * @param text
	 * 			chaine de caracteres
	 * @return month
	 * 			mois de la date
	 */
	public int intMonth(String text) {
		int month = 0;
		try {
			if(Integer.parseInt(text) >= 1 && Integer.parseInt(text) <= 12)
				month = Integer.parseInt(text);
		}
		catch (NumberFormatException e) {
			month = 0;
		}
		return month;
	}
	
	/**
	 * Methode pour la verification de format nombre entier et annee correcte a partir d'une chaine de caracteres
	 * @param text
	 * 			chaine de caracteres
	 * @return year
	 * 			annee de la date
	 */
	public int intYear(String text) {
		int year = 0;
		try {
			if(Integer.parseInt(text) > 1 && Integer.parseInt(text) < 9999)
				year = Integer.parseInt(text);
		}
		catch (NumberFormatException e) {
			year = 0;
		}
		return year;
	}
	
}

