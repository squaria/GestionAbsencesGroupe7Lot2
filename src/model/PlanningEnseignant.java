package model;

import java.util.ArrayList;

public class PlanningEnseignant extends Planning {

	public PlanningEnseignant(ArrayList<Cours> listeCours) {
		super(listeCours);
	}
	
	/*
	public void consulterPlanningEn(String nomDuProf) {
		for(int i=0; i<listeCours.size();i++) {
			if( nomDuProf==listeCours.get(i).getEnseignantId())
				super.consulterPlanning();
		}
	}
	*/

}
