package model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PrIS {
	private ArrayList<Docent> deDocenten;
	private ArrayList<Student> deStudenten;
	private int session = 0;
	private ArrayList<Klas> deKlassen;
	private ArrayList<Les> deLessen;
	
	/**
	 * De constructor maakt een set met standaard-data aan. Deze data
	 * moet nog vervangen worden door gegevens die uit een bestand worden
	 * ingelezen, maar dat is geen onderdeel van deze demo-applicatie!
	 * 
	 * De klasse PrIS (PresentieInformatieSysteem) heeft nu een meervoudige
	 * associatie met de klassen Docent en Student. Uiteraard kan dit nog veel
	 * verder uitgebreid en aangepast worden! 
	 * 
	 * De klasse fungeert min of meer als ingangspunt voor het domeinmodel. Op
	 * dit moment zijn de volgende methoden aanroepbaar:
	 * 
	 * String login(String gebruikersnaam, String wachtwoord)
	 * Docent getDocent(String gebruikersnaam)
	 * Student getStudent(String gebruikersnaam)
	 * ArrayList<Student> getStudentenVanKlas(String klasCode)
	 * 
	 * Methode login geeft de rol van de gebruiker die probeert in te loggen,
	 * dat kan 'student', 'docent' of 'undefined' zijn! Die informatie kan gebruikt 
	 * worden om in de Polymer-GUI te bepalen wat het volgende scherm is dat getoond 
	 * moet worden.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public PrIS() throws IOException, ClassNotFoundException {
		deDocenten = new ArrayList<Docent>();
		deStudenten = new ArrayList<Student>();
		deKlassen = new ArrayList<Klas>();
		deLessen = new ArrayList<Les>();
		
		
		Les l1 = new Les(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "D08:02");
		Les l2 = new Les(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3), "D06:12");
		deLessen.add(l1);
		deLessen.add(l2);
		DB.writeFile(deLessen,"lessen.csv");

		Klas k1 = new Klas("SIE-V1D");
		k1.addLes(l1);
		k1.addLes(l2);
		deKlassen.add(k1);
		DB.writeFile(deKlassen,"klassen.csv");
		
		Docent d1 = new Docent("Wim", "geheim");
		Docent d2 = new Docent("Hans", "geheim");
		Docent d3 = new Docent("Jan", "geheim");
		deDocenten.add(d1);
		deDocenten.add(d2);
		deDocenten.add(d3);
		d1.voegVakToe(new Vak("TCIF-V1AUI-15", "Analyse en User Interfaces"));
		d1.voegVakToe(new Vak("TICT-V1GP-15", "Group Project"));
		d1.voegVakToe(new Vak("TICT-V1OODC-15", "Object Oriented Design & Construction"));
		DB.writeFile(deDocenten,"docenten.csv");
		
		Student s1 = new Student(1677500, "Lars", "van", "Hijfte", "pro?");
		Student s2 = new Student(1234567, "Jari", "van den", "Brink", "jup!");
		deStudenten.add(s1);
		deStudenten.add(s2);
		DB.writeFile(deStudenten,"studenten.csv");

		deDocenten = DB.loadFile("docenten.csv");
		deStudenten = DB.loadFile("studenten.csv");
		
		deStudenten.get(1).wijzigWachtwoord("Pa$$" + (int)(Math.random()*1000));
		deStudenten.get(0).setMijnKlas(deKlassen.get(0));
		
		DB.writeFile(deStudenten,"students.csv");
		DB.writeFile(deDocenten,"docenten.csv");
		
	}
	
	
	public String login(int code, String wachtwoord) {
		for (Docent d : deDocenten) {
			if (d.getGebruikersNaam().equals(code)) {
				if (d.controleerWachtwoord(wachtwoord)) {
					session =  code;
					return "docent";
				}
			}
		}
		
		for (Student s : deStudenten) {
			if (s.getStudentCode() == code) {
				if (s.controleerWachtwoord(wachtwoord)) {
					session = code;
					return "student";
				}
			}
		}
		return "invalid";
	}
	
	public Docent getDocent(String studentCode) {
		Docent resultaat = null;
		
		for (Docent d : deDocenten) {
			if (d.getGebruikersNaam().equals(studentCode)) {
				resultaat = d;
				break;
			}
		}
		
		return resultaat;
	}
	
	public Student getStudent(int studentCode) {
		Student resultaat = null;
		
		for (Student s : deStudenten) {
			if (s.getStudentCode() == studentCode) {
				resultaat = s;
				break;
			}
		}
		
		return resultaat;
	}
	
	public Les getLes(String les) {
		Les resultaat = null;
		
		for (Les l : deLessen) {
			if (l.toString().equals(les)) {
				resultaat = l;
				break;
			}
		}
		
		return resultaat;
	}
	
	public ArrayList<Student> getStudentenVanKlas(String klasCode) {
		ArrayList<Student> resultaat = new ArrayList<Student>();
		
		for (Student s : deStudenten) {
			if (s.getMijnKlas().getKlasCode().equals(klasCode)) {
				resultaat.add(s);
			}
		}
		
		return resultaat;
	}
	
	public String toString() {
		String s = "";
		
		s += "Studenten:\n";
		for(Student st : deStudenten) {
			s += "\t" + st;
		}
		
		s += "\nDocenten:\n";
		for(Docent d : deDocenten) {
			s += "\t" + d;
		}
		
		s += "\nKlassen:\n";
		for(Klas k : deKlassen) {
			s += "\t" + k;
		}
		
		return s;
	}
}
