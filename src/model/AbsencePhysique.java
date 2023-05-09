package model;

/**
 * Classe modele java d'une absence physique
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class AbsencePhysique extends Absence {
	/**
	 * 
	 */
	private String dateDebut;
	
	/**
	 * 
	 */
	private String dateFin;
	
	/**
	 * 
	 */
	private int grpId;

	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param nomEtu
	 * @param prenomEtu
	 * @param justificatif
	 * @param valideeAdmin
	 */
	public AbsencePhysique(String dateDebut, String dateFin, int grpId, String nomEtu, String prenomEtu, String justificatif, String valideeAdmin) {
		super(nomEtu, prenomEtu, justificatif, valideeAdmin);
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.grpId = grpId;
	}

	/**
	 * @return the dateDebut
	 */
	public String getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the etuId
	 */
	public int getGrpId() {
		return grpId;
	}

	/**
	 * @param etuId the etuId to set
	 */
	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}
	
}
