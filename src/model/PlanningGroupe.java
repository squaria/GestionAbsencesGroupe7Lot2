package model;


public class PlanningGroupe extends Planning {

	public PlanningGroupe(int grpId, int coursId, String date, float heureDebut, float heureFin) {
		super(grpId, coursId, date, heureDebut, heureFin);
		// TODO Auto-generated constructor stub
	}
	
	public PlanningGroupe(int grpId, String coursNom, String date, int jour, float heureDebut, float heureFin) {
		super(grpId, coursNom, date, jour, heureDebut, heureFin);
		// TODO Auto-generated constructor stub
	}

	/*
	public PlanningEtudiant(ArrayList<Cours> listeCours) {
		super(listeCours);
		
	}*/
	
	/*
	public void consulterPlanningE(int numGrp) {
		for(int i=0; i<listeCours.size();i++) {
			while(listeCours.get(i).getGroupe().get(numGrp) != null)
				super.consulterPlanning();
			
		}
	}
	*/
}
