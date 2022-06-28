package it.polito.tdp.crimes.model;

public class Distretti {
	
	private int idDistr;
	private double lon;
	private double lan;
	
	public Distretti(int idDistr, double lon, double lan) {
		super();
		this.idDistr = idDistr;
		this.lon = lon;
		this.lan = lan;
	}

	public int getIdDistr() {
		return idDistr;
	}

	public void setIdDistr(int idDistr) {
		this.idDistr = idDistr;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLan() {
		return lan;
	}

	public void setLan(double lan) {
		this.lan = lan;
	}

	@Override
	public String toString() {
		return "Distretti [idDistr=" + idDistr + ", lon=" + lon + ", lan=" + lan + "]";
	}

}
