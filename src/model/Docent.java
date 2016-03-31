package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Docent implements Serializable {
	private String gebruikersNaam;
	private String wachtwoord;
	private ArrayList<Vak> mijnVakken;
	private ArrayList<Klas> mijnKlassen;
	
	public Docent(String gbNm, String ww) {
		mijnVakken = new ArrayList<Vak>();
		gebruikersNaam = gbNm;
		wachtwoord = ww;
	}
	
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}
	
	public ArrayList<Vak> getVakken() {
		return mijnVakken;
	}
	
	public void setKlas(Klas k) {
		mijnKlassen.add(k);
	}
	
	public ArrayList<Klas> getKlas() {
		return mijnKlassen;
	}
	
	public boolean controleerWachtwoord(String ww) {
		return wachtwoord.equals(ww);
	}
	
	public void voegVakToe(Vak nwV) {
		mijnVakken.add(nwV);
	}
	
	
	public String toString() {
		String s = gebruikersNaam + "\n";
		
		if(mijnVakken.size() == 0) {
			s += "\t\t" + "Geen vakken gevonden" + "\n";
		}
		for(Vak v : mijnVakken) {
			s += "\t\t" + v + "\n";
		}
		
		return s;
	}
}
