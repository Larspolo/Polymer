package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Student {
	private int studentCode;
	private String wachtwoord;
	private String voornaam;
	private String tussenvoegsel;
	private String achternaam;
	private Klas mijnKlas;
	
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
	
	public static ArrayList<Student> loadStudentsFile() throws IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		
		FileReader file = new FileReader("studenten.csv");
		BufferedReader bFile = new BufferedReader(file);
		
		String row;
		while((row = bFile.readLine()) != null) {
			String[] columns = row.split(",");
			
			students.add(new Student((int)Double.parseDouble(columns[0]), columns[1], columns[2], columns[3], columns[4]));
		}

		bFile.close();
		file.close();
		
		return students;
	}
	
	public static void writeStudentsFile(ArrayList<Student> students) throws IOException {
		FileWriter file = new FileWriter("studenten.csv");
		PrintWriter pFile = new PrintWriter(file);
		
		for(Student s : students) {
			pFile.println(s);
			System.out.println(s.studentCode + "," + s.voornaam + "," + s.tussenvoegsel + "," + s.achternaam + "," + s.wachtwoord);
		}
		
		pFile.close();
		file.close();
	}
	
	public String toString() {
		return "\t" + studentCode + " - " + tussenvoegsel + " " + achternaam +  ", " + voornaam +  ", " + wachtwoord + "\n";
	}
}
