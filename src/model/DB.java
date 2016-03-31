package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DB implements Serializable {
	
	public static ArrayList loadFile(String filePath) throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		ArrayList object = (ArrayList) obj;
		
		ois.close();
		fis.close();
		
		return object;
	}
	
	public static void writeFile(ArrayList objects,String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(objects);
		
		oos.close();
		fos.close();
	}
}
