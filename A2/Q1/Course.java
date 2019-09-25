/*
 * Course
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 2, Question: 1
 * @author     Richard Constantine
 * @version    2016/02/29
 * 
 * Purpose: Course stores different course information in a an object.
 */

public class Course {
  
  //Constants
  final int YEAR = 2016;
  
  // Instance Variables
  private String courseName;
  private String dept;
  private int programYear;
  private int term;
  private String courseRegNum;
  
  // Class Variable
  private static int nextCRN = 1;
  
  // Constructor
  public Course (String courseName, String dept, int term, int programYear)
  {
    this.courseName = courseName;
    this.dept = dept;
    this.term = term;
    this.programYear = programYear; 
    this.courseRegNum = Integer.toString(nextCRN);
    this.courseRegNum = YEAR + Integer.toString(term) + String.format("%03d", nextCRN);
    
    nextCRN++;
    
  }
  
  /* 
   * [Course counstructor initializes 5 instance variables (i.e. crn, courseName, dept, term and programYear] 
   * [Input: Receives input from the main method and acts to initialize values]
   * [Output: Constructor, does not have specific output]
   * 
   * @param [firstParam: the name of the course being created as string]
   * @param [secondParam; deptartment of the course as a string]
   * @param [thirdParam; term the course is being offered as a integer]
   * @param [fourthParam; what year within program/faculty is the course offered as an integer]
   * @return [N/A]
   */
  
  // Constructor 2
  public Course (int crn, String courseName, String dept, int term, int programYear)
  {
    this.courseName = courseName;
    this.dept = dept;
    this.term = term;
    this.programYear = programYear; 
    this.courseRegNum = Integer.toString(crn);
    
    nextCRN++;
    
  }
  
  /* 
   * [Course counstructor initializes 5 instance variables (i.e. crn, courseName, dept, term and programYear)]
   * [Input: Receives input from the main method and acts to initialize values]
   * [Output: Constructor, does not have specific output]
   * 
   *  @param [firstParam; what course registration number as an integer]
   * @param [secondParam: the name of the course being created as string]
   * @param [thirdParam; deptartment of the course as a string]
   * @param [fourthParam; term the course is being offered as a integer]
   * @param [fifthParam; what year within program/faculty is the course offered as an integer]
   * @return [N/A]
   */
  
  
  // Instance Methods
  public String getCourseName()
  { 
    return courseName;
  }
  
  /* 
   * [getCourseName returns the name of the course from course object]
   * [Input: Receives input from the main method and the object then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course name as a string]
   * 
   * @param [N/A]
   * @return [course name as a string]
   */
  
  public String getCourseRegNum()
  {
    return courseRegNum;
  }
  
  /* 
   * [getCourseRegNum returns the registration number of the course from course object]
   * [Input: Receives input from the main method and the object then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course registration number as a string]
   * 
   * @param [N/A]
   * @return [course registration number as a string]
   */
  
  public int getTerm()
  {
    return term; 
  }
  
  /* 
   * [getTerm returns term of course from course object]
   * [Input: Receives input from the main method and the object then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course term as a integer]
   * 
   * @param [N/A]
   * @return [course department as a integer]
   */
  
  public String getDept()
  {
    return dept;
  }
  
  /* 
   * [getDept returns the deparment from the course object]
   * [Input: Receives input from the main method and the object then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course deparment as a string]
   * 
   * @param [N/A]
   * @return [course department as a string]
   */
  
  public int getProgramYear()
  {
    return programYear;   
  }
  
  /* 
   * [getProgramYear returns program year of course from course object]
   * [Input: Receives input from the main method and the object then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course program year as a integer]
   * 
   * @param [N/A]
   * @return [course program year as a integer]
   */
  
  public String toString()
  {
    String courseInfo;
    String[] TERM = new String[]{"Winter", "Spring", "Fall"};
    
    courseInfo = ("CRN: " + courseRegNum + ": Term: " + TERM[term-1] + ", " + courseName +
                  ", Dept: " + dept + " (year " + programYear + ")");
    
    return courseInfo;
  }
  
  /* 
   * [toString turns the course object into a readable string to display]
   * [Input: Receives input from the main method and the object then acts to concatenate the variables
   * into a string]
   * [Output: Void]
   * 
   * @param [N/A]
   * @return [string with object variables concatenated]
   */
  
  public String toCsv()
  {
    String courseInfo;
    
    courseInfo = (courseRegNum + "," + courseName + "," + dept + "," + term + "," + programYear);
    
    return courseInfo;
  }
  
  /* 
   * [toString turns the course object into a readable string to display]
   * [Input: Receives input from the main method and the object then acts to concatenate the variables
   * into a string this time for the save method used in Database]
   * [Output: Void]
   * 
   * @param [N/A]
   * @return [string with object variables concatenated]
   */
}