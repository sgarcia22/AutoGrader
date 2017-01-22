/*Name: Samantha Garcia
 *Date: December 10, 2016
 *Description: This program  takes in a dictionary file and compares the words to an 
 *inputed essay and shows the error and score of the student.
 *
 *This is a class project.
 *This class was written by the professor for the student's use. I did not write this class.
 */
import java.io.IOException;
import java.util.Scanner;

public class Project5 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        final boolean SUCCESS = true;
        Dictionary dict = new Dictionary();

        while (dict.getVocabularySize() <= 0) {
            System.out.println("Please specify the file name (without extension) of the dictionary.");
            if (dict.loadDictionaryFromFile(input.nextLine() + ".txt") == SUCCESS && dict.getVocabularySize() > 0)
                System.out.println("Dictionary load successfully.");
            else
                System.out.println("Failed to load dictionary. Please try again.");
        }

        Grader grader = new Grader(dict);
        Student student;
        String id;

        while (true) {
            System.out.println("Please specify the ID of the student whose essay will be graded.");
            id = input.nextLine();
            if (id != null && id.trim().equalsIgnoreCase("exit"))
                break;

            if (!grader.isAvailable())
                grader.reset();

            if (grader.gradeStudent(id) == SUCCESS) {
                student = grader.getStudent();
                student.writeToFile();
                System.out.println("Student " + id + " has been graded.");
            } else {
                System.out.println("Grading student " + id + " failed. Please try another one.");
            }


        }
    }

}
