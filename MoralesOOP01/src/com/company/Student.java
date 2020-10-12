package com.company;

public class Student {
    // Variables for class Student
    String name;
    String year;
    Double GPA;

    // Methods to set Data
    public String getName(){
        return name;
    }
    public String getYear(){
        return year;
    }
    public double getGPA(){
        return GPA;
    }

    // Methods to get Data
    public void setName(String name){
        this.name = name;
    }
    public void setYear(String year){
        this.year = year;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }

    // Student constructor
    public Student(String name, String year, double GPA){
        this.name = name;
        this.year = year;
        this.GPA = GPA;
    }
    // Constructor for empty arguments
    public Student(){
        this.name = "";
        this.year = "";
        this.GPA = -1.0;
    }


}
