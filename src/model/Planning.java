package model;
import java.util.*;
public class Planning {
	

	
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
		}
}
	
	
}
