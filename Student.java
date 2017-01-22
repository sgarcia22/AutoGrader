/*Name: Samantha Garcia
 *Date: December 10, 2016
 *Description: This program  takes in a dictionary file and compares the words to an 
 *inputed essay and shows the error and score of the student.
 *
 *This is a class project.
 */

import java.util.ArrayList;

public abstract class Student {
    private String name;
    private String id;
    private String essay;
    private ArrayList<String> errorList;

    public Student(String name, String id, String essay, ArrayList<String> errorList) {
        this.name = name;
        this.id = id;
        this.essay = essay;
        this.errorList = errorList;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(ArrayList<String> errorList) {
        this.errorList = errorList;
    }

    public String getPrintableErrorList() {
        String output = null;
        if (errorList != null) {
            StringBuilder buffer = new StringBuilder();
            int idx = 0;
            for (String word : errorList) {
                idx += 1;
                buffer.append("(" + idx + ")" + word + System.lineSeparator());
            }
            output = buffer.toString();
        }
        return output;
    }

    abstract void writeToFile();
}
