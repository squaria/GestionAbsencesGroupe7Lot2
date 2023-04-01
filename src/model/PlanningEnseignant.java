package model;


public class PlanningEnseignant extends Planning {

	public PlanningEnseignant(int grpId, int coursId, String date, float heureDebut, float heureFin) {
		super(grpId, coursId, date, heureDebut, heureFin);
		// TODO Auto-generated constructor stub
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
