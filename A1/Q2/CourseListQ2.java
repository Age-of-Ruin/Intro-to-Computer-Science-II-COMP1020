/*
 * CourseListQ2
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 1, Question: 2
 * @author     Richard Constantine
 * @version    2016/01/28
 * 
 * Purpose: To create a list object to contain the newly created course object(s).
 */

public class CourseListQ2 {
  
  // Instance Variables
  Course[] courseList;
  int numCourses;
  
  
  // Constructor
  public CourseListQ2 () 
  {
    courseList = new Course[5];
    numCourses = 0; 
  }
    /* 
     * [CourseListQ2 is a default construtor to initialize values]
     * [Input: Receives input from the main method then acts to initalize values stored within
     * the courseList object]
     * [Output: N/A]
     * 
     * @param [N/A]
     * @return [N/A]
     */
  
  //Instance method
  public void addCourse(Course course)
  {
    Course[] newCourseList;    
    int newListSize;
    
    if (this.numCourses >= courseList.length)
    {
      newListSize = numCourses * 2;
            
      newCourseList = new Course[newListSize];
      
      System.arraycopy(this.courseList, 0, newCourseList, 0, this.numCourses);
      
      courseList = newCourseList;
    }
    
    courseList[numCourses] = course;
    this.numCourses++;                               
  }
    /* 
     * [addCourse adds a course object to the newly created course list object  of courses]
     * [Input: Receives input from the main method then acts to initalize values stored within
     * the courseList object]
     * [Output: Updates course lists size and additions]
     * 
     * @param [firstParam: Course object being added to the list]
     * @return [void]
     */

  public int indexOf(String courseRegNum)
  {
    int index = -1;
    
    for (int i=0; i<this.numCourses; i++)
    {
      if (courseRegNum.equals(courseList[i].getCourseRegNum()))
        index = i;
    }
    
    return index;
  }
     /* 
     * [indexOf locates the CRN of a course within the list and returns the index of where it is located]
     * [Input: Receives input from the main method then acts to locate the CRN it is sent]
     * [Output: Index of the the search query within the list or -1 if fails.]
     * 
     * @param [firstParam: Receives the query CRN of the search]
     * @return [Retruns the search result index or -1 if  search fails]
     */
  
  public Course removeCourse(String courseRegNum)
  {
    Course search = null;
    int index = indexOf(courseRegNum);
        
    if (index != -1)
    {
      search = courseList[index];
      
      courseList[index] = courseList[this.numCourses - 1];
      courseList[this.numCourses - 1] = null;
    
      this.numCourses--;
      return search;
    }
    
    return search;
  }
    /* 
     * [removeCourse locates the CRN of a course within the list and returns the index of where it is located
     *  then replaces the request entry with the last value course in the list]
     * [Input: Receives input from the main method then acts to locate the CRN it is sent]
     * [Output: Index of the the search query within the list or -1 if fails.]
     * 
     * @param [firstParam: Receives the query CRN of the search]
     * @return [Index of the search result or -1 if fails]
     */
  
  public String toString()
  {
    String courseString = "\t";
    
    System.out.println("There are " + this.numCourses + " courses available:");
    
    for (int i=0; i<this.numCourses; i++)
      courseString += courseList[i] + "\n" + "\t";
    
    return courseString;
  }
    /* 
     * [toString calls the toString method from the class Course and uses it to display
     *  the newly created course list as one formatted string]
     * [Input: Receives input from the main method]
     * [Output: Outputs the formatted string containing the contents of the course list]
     * 
     * @param [N/A]
     * @return [Formatted string containing the course list]
     */
  
}