package LA2Q2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Dasol_SortNameAndGrade {

    public static void main (String args[]){
        myHeader(2, 2);

        //creating three different arrays given 8 lastname, firstname, and grades
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26), (int)(60 + Math.random()*26), (int)(60 + Math.random()*26), (int)(60 + Math.random()*26)
                , (int)(60 + Math.random()*26), (int)(60 + Math.random()*26), (int)(60 + Math.random()*26), (int)(60 + Math.random()*26)};

        //create a vector class instance sg with StudentGrade tag
        Vector<StudentGrade> sg = new Vector<StudentGrade>();

        //using loop, add each StudentGrade object to Vector class
        for (int i=0;i<fnArray.length;i++){
            //add each StudentGrade Object to the Vector Class with its add method
            sg.addElement(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        //printing out the unsorted sg content
        System.out.println("\nThe Unsorted Array ........");
        System.out.println(sg+ "\b");

        Collections.sort(sg);
        //sorts array based on the grade
        System.out.println("Sorted by Grades ........");
        System.out.println(sg+ "\b");

        //creating an array of StudentGrade type with fnArray length
        StudentGrade[] array = new StudentGrade[fnArray.length];

        //Vector copyInto() method
        sg.copyInto(array);

        //printing sorted array with the help of printArray method

        //using insertion sorting method, we are sorting the array first names
        insertionSort(array,1);
        //output statement
        System.out.println("Sorted by First Names ........");
        printArray(array);

        //using insertion sorting method, we are sorting the array last names
        insertionSort(array,2);
        //output statement
        System.out.println("\nSorted by Last Names ........");
        printArray(array);

        //this is a footer
        myFooter(2, 2);
    }

    //printArray method following the sample output
    public static void printArray(StudentGrade[] a){
        for(int i=0;i<a.length;i++){
            System.out.printf("\b\b%16s : \t%3d\n",(a[i].getFirstName() + " " + a[i].getLastName()), a[i].getGrade());
        }
    }

    //insertion sorting method that will accept a StudentGrade array and integer key
    //key determines the sorting output
    //key 1 =  First Name
    //key 2 = Last Name
    public static void insertionSort(StudentGrade[] a, int key) {
        if (key == 2) {
            int j =0;
            for(int i = 1; i<a.length; i++){
                StudentGrade k = a[i];
                //for generic implementation, we need to compare the objects using compareTo() method
                for(j = i-1; j>=0 && a[j].getLastName().compareTo(k.getLastName())>0; j--){
                    a[j+1] = a[j];
                }
                a[j +1] = k;
            }
        } else if (key == 1) {
            int j =0;
            for(int i = 1; i<a.length; i++){
                StudentGrade k = a[i];
                //for generic implementation, we need to compare the objects using compareTo() method
                for(j = i-1; j>=0 && a[j].getFirstName().compareTo(k.getFirstName())>0; j--){
                    a[j+1] = a[j];
                }
                a[j + 1] = k;
            }
        }
    }

    //This is myHeader method containing my name and student number
    public static void myHeader(int assignnmentNum, int questionNum){
        System.out.println("=====================================================");
        System.out.printf("Lab Assignment %d-Q%d \n", assignnmentNum, questionNum);
        System.out.println("Prepared By: Dasol Lim");
        System.out.println("Student Number: 251224110");
        System.out.println("Goal of this Exercise: Use the insertion sorting method and compareTo method");
        System.out.println("");
        System.out.println("=====================================================");
    }
    //This is myFooter containing a good-bye message
    public static void myFooter(int assignnmentNum, int questionNum) {
        System.out.println("=====================================================");
        System.out.printf("Completion of Lab Assignment %d-Q%d is successful! \n", assignnmentNum, questionNum);
        System.out.println("Signing off - Dasol Lim");
        System.out.println("=====================================================");
    }
}
