package model;

import java.util.ArrayList;

/**
 * Classe modele java d'un cours
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Cours {
	/**
	 * 
	 */
	private String nom;
	/**
	 * 
	 */
	private String enseignant;

	/**
	 * 
	 */
	private ArrayList<String> planningCours;
	
	/**
	 * 
	 */
	private ArrayList<Integer> groupe; 
	
	/**
	 * 
	 */
	private int nbHeuresAmphi;
	
	/**
	 * 
	 */
	private int nbHeuresTD;
	
	/**
	 * 
	 */
	private int nbHeuresTP;
	
	/**
	 * 
	 */
	private int nbHeuresExamen;
	
	/**
	 * @param nom
	 * @param enseignant
	 * @param nbHeuresAmphi
	 * @param nbHeuresTD
	 * @param nbHeuresTP
	 * @param nbHeuresExamen
	 */
	public Cours(String nom, String enseignant, ArrayList<String> planningCours, ArrayList<Integer> groupe,
			int nbHeuresAmphi, int nbHeuresTD, int nbHeuresTP, int nbHeuresExamen) {
		this.nom = nom;
		this.enseignant = enseignant;
		this.planningCours = new ArrayList<>();
		this.groupe = new ArrayList<>();
		this.nbHeuresAmphi = nbHeuresAmphi;
		this.nbHeuresTD = nbHeuresTD;
		this.nbHeuresTP = nbHeuresTP;
		this.nbHeuresExamen = nbHeuresExamen;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public String getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant
	 */
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	/**
	 * @return
	 */
	public ArrayList<String> getPlanningCours() {
		return planningCours;
	}

	/**
	 * @param planningCours
	 */
	public void setPlanningCours(ArrayList<String> planningCours) {
		this.planningCours = planningCours;
	}

	/**
	 * @return
	 */
	public ArrayList<Integer> getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe
	 */
	public void setGroupe(ArrayList<Integer> groupe) {
		this.groupe = groupe;
	}

	/**
	 * @return
	 */
	public int getNbHeuresAmphi() {
		return nbHeuresAmphi;
	}

	/**
	 * @param nbHeuresAmphi
	 */
	public void setNbHeuresAmphi(int nbHeuresAmphi) {
		this.nbHeuresAmphi = nbHeuresAmphi;
	}

	/**
	 * @return
	 */
	public int getNbHeuresTD() {
		return nbHeuresTD;
	}

	/**
	 * @param nbHeuresTD
	 */
	public void setNbHeuresTD(int nbHeuresTD) {
		this.nbHeuresTD = nbHeuresTD;
	}

	/**
	 * @return
	 */
	public int getNbHeuresTP() {
		return nbHeuresTP;
	}

	/**
	 * @param nbHeuresTP
	 */
	public void setNbHeuresTP(int nbHeuresTP) {
		this.nbHeuresTP = nbHeuresTP;
	}

	/**
	 * @return
	 */
	public int getNbHeuresExamen() {
		return nbHeuresExamen;
	}

	/**
	 * @param nbHeuresExamen
	 */
	public void setNbHeuresExamen(int nbHeuresExamen) {
		this.nbHeuresExamen = nbHeuresExamen;
	}
	
	public void modifierCours(String nom,String enseignant,ArrayList<String> planningCours,ArrayList<Integer> groupe,
			int nbHeuresAmphi,int nbHeuresTD,int nbHeuresTP,int nbHeuresExamen) {
		setNom(nom);
		setEnseignant(enseignant);
		setPlanningCours(planningCours);
		setGroupe(groupe);
		setNbHeuresAmphi(nbHeuresAmphi);
		setNbHeuresTD(nbHeuresTD);
		setNbHeuresTP(nbHeuresTP);
		setNbHeuresExamen(nbHeuresExamen);
		
	}
	public void display() {
		System.out.println("Le cours de "+nom+ " donné par Mr/Mme "+enseignant+" a pour nombre d'heures en amphi"+nbHeuresAmphi+" heures,pour nombre d'heures de td "+nbHeuresTD+" heures, pour nombre d'heures de tp"+nbHeuresTP+" et a pour nombre d'heures d'examen "+nbHeuresExamen+"heures.");
	}
}
