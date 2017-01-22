/*Name: Samantha Garcia
 *Date: December 10, 2016
 *Description: This program  takes in a dictionary file and compares the words to an 
 *inputed essay and shows the error and score of the student.
 *
 *This is a class project.
 *I received help from: Jesse Martinez and Paul Calzada
 */
 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;



public class Grader {

	private boolean available;
	private Student student = null;
	private Dictionary dict;
	
	
	public Grader (Dictionary dictt) {
		dict = dictt;
		available = true;
		dict = new Dictionary();
		dict.loadDictionaryFromFile("dictionary.txt");
	}
	
	//Received help from: Paul Calzada and Jesse Martinez
	public boolean gradeStudent (String filename) {
		Scanner in = null;
		ArrayList<String> ErrorList = new ArrayList<String>();
		File grade = new File(filename + ".txt");
		
		try {
			
		in = new Scanner(grade);
		
		}
		catch (FileNotFoundException ex) {
			return false;
		}
		
		try {
			String studentVar = in.nextLine();
			String name = in.nextLine();
			String id = in.nextLine();
			String unknown = in.nextLine();
			String unknown2 = "";
			
			if (studentVar.equalsIgnoreCase("Graduate Student")) 
				unknown2 = in.nextLine();
			
			String essay = "";
			String nextWord = "";
			while (in.hasNext()) {
				
				 
				nextWord = in.next();
				nextWord.toLowerCase();
				String fixWord = "";
				
				
				for (int i = 0; i < nextWord.length(); i++) {
					if(!((nextWord.charAt(i) == '.') || (nextWord.charAt(i) == ';') || (nextWord.charAt(i) == '!') || (nextWord.charAt(i) == '?') || (nextWord.charAt(i) == ',') || (nextWord.charAt(i) == ':'))) {
					fixWord += nextWord.charAt(i);
					}
				}
				
				
				if (!dict.isWord(fixWord)) { 
					ErrorList.add(fixWord);
					}
				
				
				essay += (nextWord);
				
			}

			if (studentVar.equals("HighSchool Student")) {
				student = new HighSchoolStudent(name, id, essay, ErrorList, unknown);
			}
			if (studentVar.equals("Undergraduate Student")) {
				student = new UndergraduateStudent(name, id, essay, ErrorList, unknown);
			}
			if (studentVar.equals("Graduate Student")){
				 student = new GraduateStudent(name, id, essay, ErrorList, unknown, unknown2);
			}
			
			available = false;
			return true;
		}
		
		catch (Exception e) {
			reset();
			return false;
			
		}
		//End help from: Paul Calzada and Jesse Martinez
		
		
	}
	
	public boolean isAvailable() {
		if (student == null && available == true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void reset() {
		student = null;
		available = true;
	}
}
