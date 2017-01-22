/*Name: Samantha Garcia
 *Date: December 10, 2016
 *Description: This program  takes in a dictionary file and compares the words to an 
 *inputed essay and shows the error and score of the student.
 *
 *This is a class project.
 *I received help from: Jesse Martinez and Paul Calzada
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GraduateStudent extends Student {

	private String major;
	private String advisor;
	
	public GraduateStudent (String name, String id, String essay, ArrayList<String> errorList, String major, String advisor) {
		super(name, id, essay, errorList);
		this.major = major;
		this.advisor = advisor;
	}
 
	public String getMajor () {
		return major;
	}
	
	public void setMajor (String major) {
		this.major = major;
	}
	
	public String getAdvisor () {
		return advisor;
	}
	
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	
	//Received Help from: Jesse Martinez
	public void writeToFile() {
		File out = new File(getId() +"_graded.txt");
		try {
		PrintWriter output = new PrintWriter (getId() + "_graded.txt");
		 output.print("Graduate Student " + getName());
		 output.println("Student ID: " + getId());
		 output.println("Major: " + getMajor());
		 output.println("Advisor: " + getAdvisor());
		 output.println(getPrintableErrorList());
		 output.close();
		}
		catch (IOException ex) {
		}
		//End Help from: Jesse Martinez
	}
	
}
