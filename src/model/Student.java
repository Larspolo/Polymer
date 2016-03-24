package model;

public class Student {
	private String gebruikersNaam;
	private String wachtwoord;
    private String voornaam;
    private String tussenvoegsel;
    private String beschrijving;
    private int studentNr;
    private static boolean ziek = false;
	private Klas mijnKlas;
	
	public Student(String gbNm, String ww, String vn, String tvgsl, int snr, boolean zk) {
		gebruikersNaam = gbNm;
		wachtwoord = ww;
        voornaam = vn;
        tussenvoegsel = tvgsl;
        studentNr = snr;
        ziek = zk;
	}
	
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}

	public getWachtwoord() { return wachtwoord; }

    public void setWachtwoord(String w) { wachtwoord = w; }

    public getStudentNr() { return studentNr; }

    public void toevoegenAfwezigheid(String bScVng){ beschrijving = bScVng; }

    public void setZiek(boolean zk){ziek = zk;}

	public boolean controleerWachtwoord(String ww) {
		return ww.equals(wachtwoord);
	}
	
	public void setMijnKlas(Klas k) {
		mijnKlas = k;
	}
	
	public Klas getMijnKlas() {
		return mijnKlas;
	}
}
