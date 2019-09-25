/*
 * CourseListQ2
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 2, Question: 1
 * @author     Richard Constantine
 * @version    2016/02/29
 * 
 * Purpose: To create a list object to contain the newly created course object(s).
 */

public class CourseListQ2 {
  
  // Constants 
  final int LIST_START_SIZE = 5; 
  
  // Instance Variables
  Course[] courseList;
  int numCourses;
  
  
  // Constructor
  public CourseListQ2 () 
  {
    courseList = new Course[LIST_START_SIZE];
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
  public void addCourse (Course course) throws Exception
  {
    Course[] newCourseList;    
    int newListSize;

      if (indexOf(course.getCourseRegNum()) != -1)
      {
        throw new Exception("Duplicate CRN " + course.getCourseRegNum());
      }//if
    
    if (this.numCourses >= courseList.length)
    {
      newListSize = numCourses * 2;
      
      newCourseList = new Course[newListSize];
      
      System.arraycopy(this.courseList, 0, newCourseList, 0, this.numCourses);
      
      courseList = newCourseList;
    }//if
    
    courseList[numCourses] = course;
    this.numCourses++; 
    
  }//addCourse
  
  /* 
   * [addCourse adds a course object to the newly created course list object  of courses]
   * [Input: Receives input from the main method then acts to initalize values stored within
   * the courseList object]
   * [Output: Updates course lists size and adds the new course passed to it; throws exception if duplicate]
   * 
   * @param [firstParam: Course object being added to the list]
   * @return [void/throws exception if duplicate]
   */
  
  public int indexOf(String courseRegNum)
  {
    int index = -1;
    
    for (int i=0; i<this.numCourses; i++)
    {
      if (courseRegNum.equals(courseList[i].getCourseRegNum()))
        index = i;
    }//for
    
    return index;
  }//indexOf
  
  /* 
   * [indexOf locates the CRN of a course within the list and returns the index of where it is located or -1
   *  if it cannot find it]
   * [Input: Receives input from the main method then acts to locate the CRN it is sent]
   * [Output: Index of the the search query within the list or -1 if fails.]
   * 
   * @param [firstParam: Receives the query CRN of the search]
   * @return [Returns the search result index or -1 if  search fails]
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
    }//if
    
    return search;
  }//removeCourse
  
  /* 
   * [removeCourse locates the CRN of a course within the list and returns the index of where it is located
   *  then replaces the request entry with the last course in the list]
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
  }//toString
  
  /* 
   * [toString returns a formatted string of the contents of the list]
   * [Input: Receives input from the main method to act on CourseListQ2]
   * [Output: Outputs the formatted string containing the contents of the course list]
   * 
   * @param [N/A]
   * @return [Formatted string containing the course list]
   */
  
  public int getNumCourses()
  {
    return this.numCourses;
  }//getNumCourses
  
  /* 
   * [getNumCourses returns the number of courses from the courseListQ2 object]
   * [Input: Receives input from the main method then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course deparment as a integer]
   * 
   * @param [N/A]
   * @return [course department as a string]
   */
  
  public Course getCourse(int i) throws ArrayIndexOutOfBoundsException 
  {
    if (i < 0 || i >= this.numCourses)
    {
      throw new ArrayIndexOutOfBoundsException ("getCourse received out of bounds index of " + i);
    }//if
    else
    {
      return courseList[i];
    }//else
  }
  
  /* 
   * [getCourse returns the deparment from the course object or throws exception if out of bounds]
   * [Input: Receives input from the main method and the object then acts to a return value stored within
   * the course object]
   * [Output: Outputs the course deparment as a string]
   * 
   * @param [N/A]
   * @return [course department as a string or exception if out of bounds]
   */
}//CourseListQ2