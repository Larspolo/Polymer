package model;

import java.io.*;
import java.util.ArrayList;

public class Opleiding{
    private String naam;
	public ArrayList<Student> alleStudenten = new ArrayList<Student>();
    private Klas mijnKlas;

        public Opleiding(String nm){
            naam = nm;
        }

        public void toevoegenStudent(String filePath) throws IOException {

		FileReader fr1 = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr1);

		String regel = br.readLine();
		while (regel != null) {
			String[] studentGegevens = regel.split(",");
			String sStudentnr = studentGegevens[0];
			String sAchternaam = studentGegevens[1];
			String sTussenvoegsel = studentGegevens[2];
			String sVoornaam = studentGegevens[3];

			Student s1 = new Student(sVoornaam, sAchternaam, sTussenvoegsel, Integer.parseInt(sStudentnr));
			alleStudenten.add(s1);
			regel = br.readLine();
		}

		fr1.close();
		br.close();
	}

        public void toevoegenKlas(Klas mK){
            mijnKlas = mK;
        }

    }
