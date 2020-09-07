package com.IO;

public class Data {
	private double RR;	//Respiration
	private double GSR;	//Réponse galvanique de la peau
	private double HR;	//Rythme cardiaque
	private double BT;	//Température corporelle
	
	/**
	 * Constructeur sans argument
	 */
	public Data() {
		this.RR = 0.0;
		this.setGSR(0.0);
		this.setHR(0.0);
		this.setBT(0.0);
	}
	
	/**
	 * Constructeur avec tous les paramètres
	 * @param double RR  Respiraton
	 * @param double GSR  Galvanic Skin Response
	 * @param double HR  Heart Rate
	 * @param double BT  Body Temperature
	 */
	public Data(double RR, double GSR, double HR, double BT) {
		this.RR = RR;
		this.GSR = GSR;
		this.HR = HR;
		this.BT = BT;
	}
	
	public double getRR() { return RR; }
	public void setRR(double RR) { this.RR = RR; }
	public double getGSR() { return GSR; }
	public void setGSR(double gSR) { GSR = gSR; }
	public double getHR() { return HR; }
	public void setHR(double hR) { HR = hR; }
	public double getBT() { return BT;}
	public void setBT(double bT) { BT = bT; }
	
	public static String toStringAll(Data d) {
		String s = null;
		s += "RR = " + Double.toString(d.RR);
		s += " GSR = " + Double.toString(d.GSR);
		s += " HR = " + Double.toString(d.HR);
		s += " BT = " + Double.toString(d.BT)
;		return s;
	}
}
