/* COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 * Assignment 2 Question 1
 * Database.java
 */

import java.io.*;
import java.util.Scanner;

public class Database{
  // instance variables
  private String infileName;    // the input file name
  private String outfileName;   // the output file name
  
  // constructor
  public Database(String infile, String outfile){
    this.infileName = infile;
    this.outfileName = outfile;
  }// constructor
  
  public CourseListQ2 load(){
    CourseListQ2 result = new CourseListQ2();
    Scanner fileScanner = null;
    try{
      fileScanner = new Scanner(new File(infileName));
      while(fileScanner.hasNextLine()){
        String line = fileScanner.nextLine();
        Scanner lineScanner = new Scanner(line).useDelimiter(",");        
        String crn = lineScanner.next();
        String name = lineScanner.next();
        String dept = lineScanner.next();
        int term = lineScanner.nextInt();
        int year = lineScanner.nextInt();
        try {
          System.out.println("Adding new course");
          result.addCourse(new Course(crn, name, dept, term, year));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }// while
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    fileScanner.close();
    return result;
  }// load
  
  public void save(CourseListQ2 courseList){
    PrintWriter printer = null;
    try{
      printer = new PrintWriter(new FileWriter(outfileName));
      for(int i = 0; i < courseList.getNumCourses(); i++)
        printer.println(courseList.getCourse(i).toCsv());
      printer.close();
    } catch (Exception e) {
      System.out.println("Database save: " + e.getMessage());
    }
  }// save
  
}// class Database