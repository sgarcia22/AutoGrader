/*Name: Samantha Garcia
 *Date: December 10, 2016
 *Description: This program  takes in a dictionary file and compares the words to an 
 *inputed essay and shows the error and score of the student.
 *
 *This is a class project.
 *
 *I received help from: Jesse Martinez and Paul Calzada
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	
	private ArrayList<String> dictionary = new ArrayList<>();
 
	
	
	public int getVocabularySize() { 
		return dictionary.size();

	}
	//Received Help from: Paul Calzada
	
	public boolean loadDictionaryFromFile(String filepath) {
		File dict = new File(filepath);
		if (dict.exists()) {
			
			try {
				Scanner in = new Scanner(dict);
				while(in.hasNext()) {
					dictionary.add((in.next()).toLowerCase());
				}				
			} 
			catch (FileNotFoundException ex) {
				
				return false;
				
			}

			return true;
		}
		
		else {
			
			return false;
			
		}
	}
	//End Help from: Paul Calzada
	
	//Received Help from: Jesse Martinez
	public boolean isWord(String word) { 
	
		if (dictionary.contains(word)) {
			return true;
		}
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace(".", "");
			word = word.replace(";", "");
			word = word.replace(":", "");
			word = word.replace(",", "");
			
		if (dictionary.contains(word.toUpperCase()) || dictionary.contains(word.toLowerCase())) {
		
			return true;
		}
		else {
			return false;
		}
}
	//End Help from: Jesse Martinez
	
}
