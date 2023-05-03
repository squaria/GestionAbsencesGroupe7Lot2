package model;

/**
 * Classe modele java d'un planning enseignant fille de la classe Planning
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class PlanningGroupe extends Planning {
	
	/**
	 * Attribut du nom du professeur
	 */
	private String profNom;

	
	/**
	 * Constructeur de la classe PlanningGroupe avec l'id du groupe et du cours
	 * @param grpId
	 * 			id du groupe d'etudiants
	 * @param coursId
	 * 			id du cours
	 * @param date
	 * 			date du planning
	 * @param heureDebut
	 * 			heure du debut de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public PlanningGroupe(int grpId, int coursId, String date, float heureDebut, float heureFin) {
		super(grpId, coursId, date, heureDebut, heureFin);
	}
	
	/**
	 * Constructeur de la classe PlanningGroupe avec l'id du groupe et le nom du cours
	 * @param grpId
	 * 			id du groupe d'etudiants
	 * @param coursNom
	 * 			nom du cours
	 * @param date
	 * 			date du planning
	 * @param heureDebut
	 * 			heure du debut de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public PlanningGroupe(int grpId, String coursNom, String date, float heureDebut, float heureFin) {
		super(grpId, coursNom, date, heureDebut, heureFin);
	}
	
	/**
	 * Constructeur de la classe PlanningGroupe avec le nom du professeur
	 * @param coursNom
	 * 			nom du cours
	 * @param profNom
	 * 		nom du professeur
	 * @param date
	 * 			date du planning
	 * @param heureDebut
	 * 			heure du debut de cours
	 * @param heureFin
	 * 			heure de fin de cours
	 */
	public PlanningGroupe(String coursNom, String profNom, String date, float heureDebut, float heureFin) {
		super(coursNom, date, heureDebut, heureFin);
		this.profNom = profNom;
	}

	/**
	 * Getter du nom du professeur
	 * @return profNom
	 * 			nom du professeur
	 */
	public String getProfNom() {
		return profNom;
	}

	/**
	 * Setter du nom du professeur
	 * @param profNom
	 * 			nom du professeur
	 */
	public void setProfNom(String profNom) {
		this.profNom = profNom;
	}
	
}
