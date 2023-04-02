package model;


public class PlanningEnseignant extends Planning {

	public PlanningEnseignant(int grpId, String coursNom, String date, int jour, float heureDebut, float heureFin) {
		super(grpId, coursNom, date, jour, heureDebut, heureFin);
	}
/*
	public PlanningEnseignant(ArrayList<Cours> listeCours) {
		super(listeCours);
	}*/
	
	/*
	public void consulterPlanningEn(String nomDuProf) {
		for(int i=0; i<listeCours.size();i++) {
			if( nomDuProf==listeCours.get(i).getEnseignantId())
				super.consulterPlanning();
		}
	}
	*/

}
