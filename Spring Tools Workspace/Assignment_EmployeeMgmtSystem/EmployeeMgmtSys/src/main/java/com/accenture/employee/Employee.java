package com.accenture.employee;

public class Employee {
	private String eID;
	private String eFNAME;
	private String eLNAME;
	private int eSAL;
	private String eADDR;
	public String geteID() {
		return eID;
	}
	public void seteID(String eID) {
		this.eID = eID;
	}
	public String geteFNAME() {
		return eFNAME;
	}
	public void seteFNAME(String eFNAME) {
		this.eFNAME = eFNAME;
	}
	public String geteLNAME() {
		return eLNAME;
	}
	public void seteLNAME(String eLNAME) {
		this.eLNAME = eLNAME;
	}
	public int geteSAL() {
		return eSAL;
	}
	public void seteSAL(int eSAL) {
		this.eSAL = eSAL;
	}
	public String geteADDR() {
		return eADDR;
	}
	public void seteADDR(String eADDR) {
		this.eADDR = eADDR;
	}
	@Override
	public String toString() {
		return "Employee [eID=" + eID + ", eFNAME=" + eFNAME + ", eLNAME=" + eLNAME + ", eSAL=" + eSAL + ", eADDR="
				+ eADDR + "]";
	}
	
	
}
