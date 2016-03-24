package model;

import java.util.ArrayList;
import java.util.Date;

public class Les {
	private Date datum;
	private Date beginTijd;
	private Date eindTijd;
	private String docent;
	private String lokaal;
	private String lesCode;
	private String klasCode;
	private ArrayList afwezigeStudenten;
	
	public Les(Date dT, Date bT, Date eT, String d, String lok, String les, String klas ){
		datum = dT;
		beginTijd = bT;
		eindTijd = eT;
		docent = d;
		lokaal = lok;
		lesCode = les;
		klasCode = klas;
	}
	
}
