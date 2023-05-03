package model;

/**
 * Classe modele java d'un groupe d'etudiants
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class Groupe {
	
	/**
	 * Attribut du numero du groupe d'etudiants
	 */
	private int grpNum;
	
	/**
	 * Attribut de la capacite maximale du groupe d'etudiants
	 */
	private int capaciteMax;

	/**
	 * Constructeur de la classe Groupe
	 * @param grpNum
	 * 			numero du groupe d'etudiants
	 * @param capaciteMax
	 * 			capacite maximale du groupe d'etudiants
	 */
	public Groupe(int grpNum, int capaciteMax) {
		this.grpNum = grpNum;
		this.capaciteMax = capaciteMax;
	}

	/**
	 * Getter du numero du groupe d'etudiants
	 * @return grpNum
	 * 			numero du groupe d'etudiants
	 */
	public int getGrpNum() {
		return grpNum;
	}

	/**
	 * Setter du numero du groupe d'etudiants
	 * @param grpNum
	 * 			numero du groupe d'etudiants
	 */
	public void setGrpNum(int grpNum) {
		this.grpNum = grpNum;
	}

	/**
	 * Getter capacite maximale du groupe d'etudiants
	 * @return capaciteMax
	 * 			capacite maximale du groupe d'etudiants
	 */
	public int getCapaciteMax() {
		return capaciteMax;
	}

	/**
	 * Setter capacite maximale du groupe d'etudiants
	 * @param capaciteMax
	 * 			capacite maximale du groupe d'etudiants
	 */
	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
	}
	
}
