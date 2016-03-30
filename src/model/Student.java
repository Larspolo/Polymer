package model;

import java.io.Serializable;

public class Student implements Serializable {
	private int studentCode;
	private String wachtwoord;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private Klas mijnKlas = null;
	private boolean afwezig = false;
	
	public Student(int sC, String vn, String tv, String an, String ww) {
		studentCode = sC;
		
		voornaam = vn;
		tussenvoegsel = tv;
		achternaam = an;
		
		wachtwoord = ww;
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
	
	public boolean wijzigAfwezig() {
		afwezig = !afwezig;
		
		return afwezig;
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
