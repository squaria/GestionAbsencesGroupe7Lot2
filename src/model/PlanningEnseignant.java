package model;

/**
 * Classe modele java d'un planning enseignant fille de la classe Planning
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class PlanningEnseignant extends Planning {

	/**
	 * Constructeur de la classe PlanningEnseignant
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
	public PlanningEnseignant(int grpId, String coursNom, String date, float heureDebut, float heureFin) {
		super(grpId, coursNom, date, heureDebut, heureFin);
	}

}
