/*Name: Samantha Garcia
 *Date: December 10, 2016
 *Description: This program  takes in a dictionary file and compares the words to an 
 *inputed essay and shows the error and score of the student.
 *
 *This is a class project.
 *I received help from: Jesse Martinez and Paul Calzada
 */
import java.util.ArrayList;
import java.io.*;

public class HighSchoolStudent extends Student {

	private String nameOfSchool;
	
	public HighSchoolStudent(String name, String id, String essay, ArrayList <String> errorList, String nameOfSchool) {
		super(name, id, essay, errorList);
		this.nameOfSchool = nameOfSchool;
	}
	
	public String getSchoolName() {
		return nameOfSchool;
	}
	
	public void setSchoolName(String nameOfSchool) {
		this.nameOfSchool = nameOfSchool;
	}
	
	//Received Help from: Jesse Martinez
	
	
	@Override
	public void writeToFile() {	
		File out = new File(getId() +"_graded.txt");
		try {
			 PrintWriter output = new PrintWriter (getId() + "_graded.txt");
			 output.print("High School Student " + getName());
			 output.println("Student ID: " + getId());
			 output.println("School Name: " + getSchoolName());
			 output.println(getPrintableErrorList());
			 output.close();
			}
			
			catch (IOException ex) {
			System.out.println("Be teh duck");
			}
		//End Help from: Jesse Martinez
		 
	}
	
}
