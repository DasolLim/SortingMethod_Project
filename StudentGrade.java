package LA2Q2;

import java.util.Vector;

public class StudentGrade implements Comparable<StudentGrade>{
    //reference variable for firstName, lastName, grade
    private String firstName, lastName;
    private int grade;

    //constructor with parameter
    public StudentGrade (String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //these are collection of setter and getter methods for firstName, lastName, and grade
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getGrade(){
        return grade;
    }

    //this is toString method that outputs in sample output format
    public String toString(){
        return String.format("\b\b%16s : \t%3d\n",(getFirstName() + " " + getLastName()), getGrade());
    }

    //compareTo method to for comparing the student grades
    public int compareTo(StudentGrade studentScore) {
        int value = 0;
        //if greater than output 1
        if(this.grade> studentScore.grade)
            value = 1;
        //if smaller than output -1
        else if(this.grade< studentScore.grade)
            value = -1;
        else
            //if same than output 0
            value = 0;
        return value;
    }

}
