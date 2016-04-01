package model;

import java.io.Serializable;

public class Vak implements Serializable {
	public String vakCode;
	public String vakNaam;
	
	public Vak(String vC, String vN) {
		vakCode = vC;
		vakNaam = vN;
	}
	
	public String getVakNaam() {
		return vakNaam;
	}
	
	public String getVakCode() {
		return vakCode;
	}
	
	public boolean equals(Object obj) {		
		return ((Vak) obj).vakCode == vakCode;
	}
	
	public String toString() {
		return vakNaam;
	}
}
