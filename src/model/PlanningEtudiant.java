package model;

import java.util.ArrayList;

public class PlanningEtudiant extends Planning {

	public PlanningEtudiant(ArrayList<Cours> listeCours) {
		super(listeCours);
		
	}
	
	/*
	public void consulterPlanningE(int numGrp) {
		for(int i=0; i<listeCours.size();i++) {
			while(listeCours.get(i).getGroupe().get(numGrp) != null)
				super.consulterPlanning();
			
		}
	}
	*/
}
