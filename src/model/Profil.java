package model;

/**
 * Classe modele java d'un profil utilisateur
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Profil {

	/**
	 * Attribut du nom du profil utilisateur
	 */
	protected String nom;
	/**
	 * Attribut du prenom du profil utilisateur
	 */
	protected String prenom;
	/**
	 * Attribut de l'email du profil utilisateur
	 */
	protected String email;
	
	/**
	 * Constructeur de la classe mere Profil
	 * @param nom
	 * 			nom du profil utilisateur
	 * @param prenom
	 * 			prenom du profil utilisateur
	 * @param email
	 * 			email du profil utilisateur
	 */
	public Profil(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	/**
	 * Getter du nom du profil utilisateur
	 * @return nom
	 * 			nom du profil utilisateur
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Getter du prenom du profil utilisateur
	 * @return prenom
	 * 			prenom du profil utilisateur
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Getter de l'email du profil utilisateur
	 * @return email
	 * 			email du profil utilisateur
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter du nom du profil utilisateur
	 * @param nom
	 * 			nom du profil utilisateur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Setter du prenom du profil utilisateur
	 * @param prenom
	 * 			prenom du profil utilisateur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Setter de l'email du profil utilisateur
	 * @param email
	 * 			email du profil utilisateur
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
