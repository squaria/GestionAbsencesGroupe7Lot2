package model;

import java.util.ArrayList;

/**
 * Classe modele java d'un profil etudiant
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Etudiant extends Profil {

	/**
	 * 
	 */
	private String filiere;
	
	/**
	 * 
	 */
	private int groupe;
	
	private ArrayList<Absence> abs;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param filiere
	 * @param groupe
	 */
	public Etudiant(String nom, String prenom, String email, String filiere, int groupe)
	{
		super(nom, prenom, email);
		this.filiere = filiere;
		this.groupe = groupe;
		this.abs = new ArrayList<>();
	}

	/**
	 * @return
	 */
	public String getFiliere() {
		return filiere;
	}

	/**
	 * @param filiere
	 */
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	/**
	 * @return
	 */
	public int getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe
	 */
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	
	/**
	 * @param date
	 * @param nbHeures
	 * @param nomCours
	 * @param type
	 * @param justificatif
	 * @param valideeAdmin
	 */
	public void declarerUneAbsence(String date, double nbHeures, String nomCours, String type, String justificatif, String valideeAdmin) {
		Absence ab = new Absence(date, nbHeures, nomCours, type, justificatif, valideeAdmin);
		abs.add(ab);
	}
	
	/**
	 * 
	 */
	public void ConsulterAbsencesEtudiant() {
		System.out.println("Vos absences :");
		for(int i=0; i< abs.size();i++) {
			System.out.println( abs.get(i));
		}
	}
	
	/**
	 * @param just
	 * @param date
	 */
	public void deposerJustificatif(String just, String date) {
		for(int i=0; i<abs.size();i++) {
			if( date==abs.get(i).getDate())
				abs.get(i).setJustificatif(just);
		}
	}
	
	
}
