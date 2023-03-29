package model;

//import java.util.ArrayList;

/**
 * Classe modele java d'un profil gestionnaire
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Gestionnaire extends Profil {

	/*
	private ArrayList<Administratif> pA;
	private ArrayList<Professeur> pP;
	private ArrayList<Etudiant> pE;*/
	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 */
	public Gestionnaire(String nom, String prenom, String email) {
		super(nom, prenom, email);
		/*this.pA= new ArrayList<>();
		this.pP= new ArrayList<>();
		this.pE= new ArrayList<>();*/
	}
	/*public void creerAdministrateur(String nom, String prenom, String email) {
		Administratif pf = new Administratif(nom,prenom,email);
		pA.add(pf);
	}
	public void creerProf(String nom, String prenom, String numTel) {
		Professeur pp = new Professeur(nom,prenom,numTel);
		pP.add(pp);
	}
	public void creerEtudiant(String nom, String prenom) {
		Etudiant pC = new Etudiant(nom,prenom);
		pE.add(pC);
	}
	public void supprimerAdministrateur(String nomDeAdmin) {
		for(int i=0; i<pA.size();i++) {
			if( nomDeAdmin==pA.get(i).getNom())
				pA.remove(i);
		}
	}
	public void supprimerProf(String nomDeProf) {
		for(int i=0; i<pP.size();i++) {
			if( nomDeProf==pP.get(i).getNom())
				pP.remove(i);
		}
	}
	public void supprimerEtudiant(String nomDeEtu) {
		for(int i=0; i<pE.size();i++) {
			if( nomDeEtu==pE.get(i).getNom())
				pE.remove(i);
		}
	}
	public void modifierAdministrateur(String nomDeAdmin, String nvNom, String nvPrenom) {
		for(int i=0; i<pA.size();i++) {
			if( nomDeAdmin==pA.get(i).getNom()) {
				pA.get(i).setNom(nvNom);
				pA.get(i).setPrenom(nvPrenom);
			}
		}
	}
	public void modifierProf(String nomDeProf, String nvNom, String nvPrenom, String nvNumDeTel) {
		for(int i=0; i<pP.size();i++) {
			if( nomDeProf==pP.get(i).getNom()) {
				pP.get(i).setNom(nvNom);
				pP.get(i).setPrenom(nvPrenom);
				pP.get(i).setNumTel(nvNumDeTel);
			}
		}
	}
	public void modifierEtudiant(String nomDeEtu, String nvNom, String nvPrenom, String nvFiliere, String nvEmail, int nvGrp) {
		for(int i=0; i<pE.size();i++) {
			if( nomDeEtu==pE.get(i).getNom()) {
				pE.get(i).setNom(nvNom);
				pE.get(i).setPrenom(nvPrenom);
				pE.get(i).setFiliere(nvFiliere);
				pE.get(i).setEmail(nvEmail);
				pE.get(i).setGroupe(nvGrp);
			}
		}
	}*/
}
