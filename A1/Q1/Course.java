/*
 * CourseQ1
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 1, Question: 1
 * @author     Richard Constantine
 * @version    2016/01/27
 * 
 * Purpose: To define a new object by creating a new class(course) which accepts data from a 
 * template main method then stores and displays the data appropriately (using instructions
 * given).
 */

public class Course {
  
  // Instance Variables
  private String courseName;
  private String dept;
  private int programYear;
  private int term;
  private String courseRegNum;
  
  // Class Variable
  private static int numCourses = 0;
  
  // Constructor
  public Course (String courseName, String dept, int term, int programYear)
  {
    this.courseName = courseName;
    this.dept = dept;
    this.term = term;
    this.programYear = programYear; 
    
    numCourses++;
    
    // padded 0's for displaying CRN
    if (numCourses < 10) 
    courseRegNum = "2016" + term + "00" + numCourses;    
    else if (numCourses < 100)
    courseRegNum = "2016" + term + "0" + numCourses; 
    else
    courseRegNum = "2016" + term + numCourses; 
  }
    /* 
     * [Course counstructor initializes instance variables (i.e. courseName, dept, term and programYear) 
     * and pads the CRN with leading 0s for display]
     * [Input: Receives input from the main method and acts to initialize values]
     * [Output: Constructor, does not have specific output]
     * 
     * @param [firstParam: the name of the course being created as string]
     * @param [secondParam; deptartment of the course as a string]
     * @param [thirdParam; term the course is being offered as a integer]
     * @param [fourthParam; what year within program/faculty is the course offered as an integer]
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
     * @param [firstParam: the name of the course being accessed as a string]
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
     * @param [firstParam: the registration number of the course being accessed as a string]
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
     * @param [firstParam: the term of the course being accessed as an integer]
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
     * @param [firstParam: the department of the course being accessed as a string]
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
     * @param [firstParam: the program year of the course being accessed as an integer]
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
     * @return [N/A]
     */
}