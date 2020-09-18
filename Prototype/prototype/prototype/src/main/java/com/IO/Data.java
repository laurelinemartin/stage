package com.IO;

/** 
 * @author Laureline MARTIN
 * Classe des données
 */
public class Data {
	private double RR;	//Respiration
	private double GSR;	//Réponse galvanique de la peau
	private double HR;	//Rythme cardiaque
	private double BT;	//Température corporelle
	private double lat; //Latitude}
	private double lon; //Longitude
	private boolean pres;   //Presence dans la piece	
	/**
	 * Constructeur sans argument
	 */
	public Data() {
		this.RR = 0.0;
		this.setGSR(0.0);
		this.setHR(0.0);
		this.setBT(0.0);
		this.setLat(0.0);
		this.setLon(0.0);
		this.setPres(false);
	}
	
	/**
	 * Constructeur avec tous les paramètres
	 * @param double RR  Respiraton
	 * @param double GSR  Galvanic Skin Response
	 * @param double HR  Heart Rate
	 * @param double BT  Body Temperature
	 * @param double lat  Latitude
	 * @param double lon  Longitude
	 * @param int presence Presence dans piece
	 */
	public Data(double RR, double GSR, double HR, double BT, double lat, double lon, boolean presence) {
		this.RR = RR;
		this.GSR = GSR;
		this.HR = HR;
		this.BT = BT;
		this.setLat(lat);
		this.setLon(lon);
		this.setPres(presence);
	}
	
	public double getRR() 			{ return RR; }
	public void setRR(double RR) 	{ this.RR = RR; }
	public double getGSR() 			{ return GSR; }
	public void setGSR(double gSR) 	{ GSR = gSR; }
	public double getHR() 			{ return HR; }
	public void setHR(double hR)	{ HR = hR; }
	public double getBT() 			{ return BT;}
	public void setBT(double bT) 	{ BT = bT; }
	public double getLat() 			{ return lat; }
	public void setLat(double lat) 	{ this.lat = lat; }
	public double getLon() 			{ return lon; }
	public void setLon(double lon) 	{ this.lon = lon; }
	public boolean getPres() 			{ return pres; }
	public void setPres(boolean pres) 	{ this.pres = pres; }
	
	public static String toStringPhysio(Data d) {
		String s = null;
		s += "RR = " + Double.toString(d.RR);
		s += " GSR = " + Double.toString(d.GSR);
		s += " HR = " + Double.toString(d.HR);
		s += " BT = " + Double.toString(d.BT);
		return s;
	}
	public static String toStringRR(Data d) 	{ return Double.toString(d.RR); }
	public static String toStringGSR(Data d)	{ return Double.toString(d.GSR); }
	public static String toStringHR(Data d) 	{ return Double.toString(d.HR); }
	public static String toStringBT(Data d)		{ return Double.toString(d.BT); }
	public static String toStringLat(Data d)	{ return Double.toString(d.lat); }
	public static String toStringLon(Data d)	{ return Double.toString(d.lon); }
	public static String toStringPres(Data d)	{ return Boolean.toString(d.pres); }
}
