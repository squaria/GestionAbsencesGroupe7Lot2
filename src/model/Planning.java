package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Planning {
	
	protected int grpId;
	protected int coursId;
	protected String coursNom;
	protected String date;
	protected int jour;
	protected float heureDebut;
	protected float heureFin;
	
	public Planning(int grpId, int coursId, String date, float heureDebut, float heureFin) {
		this.grpId = grpId;
		this.coursId = coursId;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	public Planning(int grpId, String coursNom, String date, int jour, float heureDebut, float heureFin) {
		this.grpId = grpId;
		this.coursNom = coursNom;;
		this.date = date;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public Planning(String coursNom, String date, float heureDebut, float heureFin) {
		this.coursNom = coursNom;;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	public Planning() {
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getCoursId() {
		return coursId;
	}

	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}

	public String getCoursNom() {
		return coursNom;
	}

	public void setCoursNom(String coursNom) {
		this.coursNom = coursNom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(float heureDebut) {
		this.heureDebut = heureDebut;
	}

	public float getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(float heureFin) {
		this.heureFin = heureFin;
	}
	
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
	
	public int intMonth(String text) {
		int month = 0;
		try {
			if(Integer.parseInt(text) > 1 && Integer.parseInt(text) < 12)
				month = Integer.parseInt(text);
		}
		catch (NumberFormatException e) {
			month = 0;
		}
		return month;
	}
	
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
	
	/*
	protected ArrayList<Cours> listeCours;
	public Planning(ArrayList<Cours> listeCours) {
		super();
		this.listeCours = new ArrayList<>();
	}
	public ArrayList<Cours> getListeCours() {
		return listeCours;
	}
	public void setListeCours(ArrayList<Cours> listeCours) {
		this.listeCours = listeCours;
	}
	public void supprimerCours(String nomDuCours) {
		for(int i=0; i<listeCours.size();i++) {
			if( nomDuCours==listeCours.get(i).getNom())
				listeCours.remove(i);
		}
	}
	public void consulterPlanning() {
		System.out.println("Les cours de cette semaine sont");
		for(int i=0; i<listeCours.size();i++) {
			System.out.println(listeCours.get(i).getNom());
		}}*/
}

