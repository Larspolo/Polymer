package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Klas implements Serializable {
	private String klasCode;
	private ArrayList<Les> mijnLessen = new ArrayList<Les>();
	
	public Klas(String kC) {
		klasCode = kC;
	}
	
	public String getKlasCode() {
		return klasCode;
	}
	
	public ArrayList<Les> getMijnLessen() {
		return mijnLessen;
	}
	
	public void addLes(Les les) {
		mijnLessen.add(les);
	}
	
	public void removeLes(Les les) {
		if(mijnLessen.contains(les)) {
			mijnLessen.remove(les);
		}
	}
	
	public String toString() {
		String s =  klasCode + "\n";
		
		for (Les l : mijnLessen) {
			s += "\t\t" + l + "\n";
		}
		
		return s;
	}
}
