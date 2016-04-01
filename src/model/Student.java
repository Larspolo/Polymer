package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private int studentCode;
	private String wachtwoord;
	
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	
	private ArrayList<Vak> mijnVakken = new ArrayList<Vak>();
	private Klas mijnKlas = null;
	private boolean ziek;
	
	public Student(int sC, String vn, String tv, String an, String ww) {
		studentCode = sC;
		
		voornaam = vn;
		tussenvoegsel = tv;
		achternaam = an;
		
		wachtwoord = ww;
		
		ziek = false;
	}
	
	public int getStudentCode() {
		return studentCode;
	}
	
	public boolean controleerWachtwoord(String ww) {
		return ww.equals(wachtwoord);
	}
	
	public void setMijnKlas(Klas k) {
		mijnKlas = k;
	}
	
	public Klas getMijnKlas() {
		return mijnKlas;
	}
	
	public void wijzigWachtwoord(String w) {
		wachtwoord = w;
	}
	
	public void setAfwezig(Student s, Les l) {
		l.setAfwezige(s);
	}
	
	public ArrayList<Vak> getVakken() {
		return mijnVakken;
	}
	
	public void addVak(Vak v) {
		mijnVakken.add(v);
	}
	
	public void removeVak(Vak v) {
		mijnVakken.remove(v);
	}
	
	public void ziekMelden() {
		ziek = !ziek;
	}
	
	public boolean getZiek() {
		return ziek;
	}
	
	public boolean equals(Object obj) {
		boolean r = true;
		
		r = r && ((Student)obj).studentCode == studentCode;
		
		return r;
	}
	
	public String toString() {
		return studentCode + " - " + tussenvoegsel + " " + achternaam +  ", " + voornaam +  ", " + wachtwoord + "\n";
	}
}
