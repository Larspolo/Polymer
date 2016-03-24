package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Klas {
	private String klasCode;
	private ArrayList<Les> alleLessen = new ArrayList<Les>();
	
	public Klas(String kC) {
		klasCode = kC;
	}
	public void toevoegenLes(String filePath) throws IOException {

		FileReader fr1 = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr1);

		String regel = br.readLine();
		while (regel != null) {
			String[] lesGegevens = regel.split(",");
			String sDatum = lesGegevens[0];
			String sBeginTijd = lesGegevens[1];
			String sEindTijd = lesGegevens[2];
			String sLesCode = lesGegevens[3];
			String sDocent = lesGegevens[4];
			String sLokaal = lesGegevens[5];
			String sKlasCode = lesGegevens[6];

			Les l1 = new Les(sDatum, sBeginTijd, sEindTijd, sDocent, sLokaal, sLesCode, sKlasCode);

			alleLessen.add(l1);

			regel = br.readLine();
		}

		fr1.close();
		br.close();

	}
	public void getLessen() {
		alleLessen.forEach(les -> System.out.println(les));
	}
	
	public String getKlasCode() {
		return klasCode;
	}
}
