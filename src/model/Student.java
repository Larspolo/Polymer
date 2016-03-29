package model;

public class Student {
    private static boolean ziek = false;
    private String gebruikersNaam, wachtwoord, voornaam, tussenvoegsel, beschrijving;
    private int studentNr;
    private Klas mijnKlas;

    public Student(String gbNm, String ww, String vn, String tvgsl, int snr, boolean zk) {
        gebruikersNaam = gbNm;
        wachtwoord = ww;
        voornaam = vn;
        tussenvoegsel = tvgsl;
        studentNr = snr;
        ziek = zk;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public int getStudentNr() {
        return studentNr;
    }

    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setWachtwoord(String w) {
        wachtwoord = w;
    }

    public void toevoegenAfwezigheid(String bScVng) {
        beschrijving = bScVng;
    }

    public void setZiek(boolean zk) {
        ziek = zk;
    }

    public boolean controleerWachtwoord(String ww) {
        return ww.equals(wachtwoord);
    }

    public Klas getMijnKlas() {
        return mijnKlas;
    }

    public void setMijnKlas(Klas k) {
        mijnKlas = k;
    }
}
