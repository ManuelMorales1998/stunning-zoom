// Manuel Morales
package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        Student myStudent = new Student();
        int menuSelection = 0;
        do {
            // Error handling for menu selection
            try {
                displayMenu();
                menuSelection = myScanner.nextInt();

                switch (menuSelection){
                    case 1:
                        System.out.print("Enter Student's name: ");
                        myStudent.setName(myScanner.next());
                        break;
                    case 2:
                        System.out.print("Enter Student's Academic Year: ");
                        myStudent.setYear(myScanner.next());
                        myStudent.setYear(checkAcademicYear(myStudent.getYear()));
                        break;
                    case 3:
                        do {
                            try {
                                System.out.print("Enter Student's GPA: ");
                                myStudent.setGPA(myScanner.nextDouble());
                            } catch (Exception ex) {
                                System.out.print("Not a double. Try again: ");
                                myScanner.next();
                            }
                        }while (myStudent.getGPA() > 4.0 || myStudent.getGPA() < 0.0 );
                        break;
                    case 4:
                        int count = missingData(myStudent.getName(), myStudent.getYear(), myStudent.getGPA());
                        if (count == 0) {
                            System.out.println("The student's name is: " + myStudent.getName());
                            System.out.println("The student's academic year is: " + myStudent.getYear());
                            System.out.println("The student's GPA is: " + myStudent.getGPA());
                        }
                        else{
                            System.out.println("Input the  Missing Data");
                        }
                        myScanner.nextLine();
                        System.out.println("Press Enter to Clear Terminal");
                        myScanner.nextLine();
                        clearTer();
                        break;

                }
            }catch (Exception e){
                System.out.println("Not an integer. Try again: ");
                myScanner.next();
            }
        }while(menuSelection != 5);
    }
    
    public static int missingData(String name, String acYear, double gpa) {
        String[] questions = {"Students Name", "Students Academic Year", "Students GPA"};
        int countOfMissing = 0;
        if (name.isEmpty()) {
            System.out.println("It looks like you left " + questions[0] + " blank");
            countOfMissing++;
        }
        if (acYear.isEmpty()) {
            System.out.println("It looks like you left " + questions[1] + " blank");
            countOfMissing++;
        }
        if (gpa < 0){
            System.out.println("It looks like you left " + questions[2] + " blank");
            countOfMissing++;
        }

        return countOfMissing;
    }
    private static String checkAcademicYear(String year){
        Scanner myScanner = new Scanner(System.in);
        boolean yearBool = false;
        // Array for valid academic year input
        String[] academicYears = new String[]  {"Freshman","Sophomore","Junior","Senior"};
        // Loop that compares initial input to valid academic years
        for (String x:academicYears){
            if(year.equals(x)){
                yearBool = true;
                break;
            }
        }
        // Error handling
        while (!yearBool){
            System.out.print("Please enter 'Freshman', 'Sophomore', 'Junior',or 'Senior': ");
            year = myScanner.next();
            for (String x:academicYears){
                if (year.equals(x)){
                    yearBool = true;
                    break;
                }
            }
        }
        return year;
    }
    public static void clearTer(){
        System.out.println("\033[H\033[2J");
        //System.out.flush();
    }
    public static void displayMenu(){
        System.out.println("1. Enter The Student's name");
        System.out.println("2. Enter The Student's Academic Year");
        System.out.println("3. Enter The Student's GPA");
        System.out.println("4. Display The Student's Info");
        System.out.println("5. Exit");

        System.out.print("Please enter which number you want to answer: ");
    }
}
