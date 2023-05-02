package model;

public class Groupe {
	private int grpNum;
	private int capaciteMax;

	public Groupe(int grpNum, int capaciteMax) {
		this.grpNum = grpNum;
		this.capaciteMax = capaciteMax;
	}

	/**
	 * @return the grpNum
	 */
	public int getGrpNum() {
		return grpNum;
	}

	/**
	 * @param grpNum the grpNum to set
	 */
	public void setGrpNum(int grpNum) {
		this.grpNum = grpNum;
	}

	/**
	 * @return the capaciteMax
	 */
	public int getCapaciteMax() {
		return capaciteMax;
	}

	/**
	 * @param capaciteMax the capaciteMax to set
	 */
	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
	}
	
}
