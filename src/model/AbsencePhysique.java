package model;

/**
 * Classe modele java d'une absence physique
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class AbsencePhysique extends Absence {
	/**
	 * Attribut de la date de debut de l'absence physique
	 */
	private String dateDebut;
	
	/**
	 * Attribut de la date de fin de l'absence physique
	 */
	private String dateFin;
	
	/**
	 * Attribut de l'id du groupe de l'etudiant concerne
	 */
	private int grpId;
	
	private int etuId;

	/**
	 * Constructeur de la classe AbsencePhysique fille de la classe Absence
	 * @param dateDebut
	 * 			date de debut de l'absence physique
	 * @param dateFin
	 * 			date de fin de l'absence physique
	 * @param grpId
	 * 			id du groupe de l'etudiant concerne
	 * @param etuId
	 * 			id de l'etudiant concerne
	 * @param nomEtu 
	 * 			nom de l'etudiant de l'absence
	 * @param prenomEtu 
	 * 			prenom de l'etudiant de l'absence
	 * @param justificatif 
	 * 			justificatif de l'absence
	 * @param valideeAdmin 
	 * 			validation par l'administratif de l'absence
	 */
	public AbsencePhysique(String dateDebut, String dateFin, int grpId, int etuId, String nomEtu, String prenomEtu, String justificatif, String valideeAdmin) {
		super(nomEtu, prenomEtu, justificatif, valideeAdmin);
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.grpId = grpId;
		this.etuId = etuId;
	}

	/**
	 * Getter de la date de debut de l'absence physique
	 * @return dateDebut
	 * 			date de debut de l'absence physique
	 */
	public String getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter de la date de debut de l'absence physique
	 * @param dateDebut
	 * 			date de debut de l'absence physique
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter de la date de fin de l'absence physique
	 * @return dateFin
	 * 			date de fin de l'absence physique
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * Setter de la date de fin de l'absence physique
	 * @param dateFin 
	 * 			date de fin de l'absence physique
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter de l'id du groupe de l'etudiant concerne
	 * @return grpId
	 * 			id du groupe de l'etudiant concerne
	 */
	public int getGrpId() {
		return grpId;
	}

	/**
	 * Setter de l'id du groupe de l'etudiant concerne
	 * @param grpId 
	 * 			id du groupe de l'etudiant concerne
	 */
	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	/**
	 * Getter de l'id de l'etudiant concerne
	 * @return etuId
	 * 			id de l'etudiant concerne
	 */
	public int getEtuId() {
		return etuId;
	}

	/**
	 * Setter de l'id de l'etudiant concerne
	 * @param etuId 
	 * 			id de l'etudiant concerne
	 */
	public void setEtuId(int etuId) {
		this.etuId = etuId;
	}
	
}
