package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Les implements Serializable {
	private LocalDateTime begintijd;
	private LocalDateTime eindtijd;
	private ArrayList<Student> afwezigen;
	
	public Les() {
		this(LocalDateTime.now(),LocalDateTime.now().plusHours(1));
	}
	
	public Les(LocalDateTime bt, LocalDateTime et) {
		begintijd = bt;
		eindtijd = et;
	}
	
	public void setAfwezige(Student student) {
		if(!afwezigen.contains(student)) {
			afwezigen.add(student);
		}
	}
	
	public String toString() {
		return begintijd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " om " + begintijd.format(DateTimeFormatter.ofPattern("HH:mm")) + " tot " + eindtijd.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
}
