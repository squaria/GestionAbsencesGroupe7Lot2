package model;

/**
 * Classe modele java d'un profil utilisateur
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Profil {

	/**
	 * 
	 */
	protected String nom;
	/**
	 * 
	 */
	protected String prenom;
	/**
	 * 
	 */
	protected String email;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 */
	public Profil(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display() {
		System.out.println("Votre nom: "+nom+", prenom:"+prenom);
	}
}
