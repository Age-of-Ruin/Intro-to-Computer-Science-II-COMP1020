// CourseListQ2.java
// COMP 1020 Winter 2016
// (C) Computer Science, University of Manitoba
// A2Q1 solution

public class CourseListQ2 {
    private static final int INITIAL_NUM_COURSES = 5;    // initial size of partially-full array
    
    private Course[] courses;                            // our partially-full, expanding array of Courses
    private int numCourses;                              // how many Courses we're actually storing
    
    // default constructor simply initializes our array
    // and sets our course count
    public CourseListQ2() {
        courses = new Course[INITIAL_NUM_COURSES];
        numCourses = 0;
    }// default constructor
    
    // our new accessor methods
    public int getNumCourses() { return numCourses; }
    public Course getCourse(int i) throws ArrayIndexOutOfBoundsException{ 
      if(i < 0 || i >= numCourses)
        throw new ArrayIndexOutOfBoundsException("getCourse received out of bounds index of " + i);
      else
        return courses[i]; 
    }// getCourse
    
    // takes a parameter representing a Course object and adds it
    // to our partially-full array; doubles the array size if necessary
    public void addCourse(Course course) throws Exception{
        Course[] newCourses;
        
        // here is the new code to check if this is a duplicate CRN
        if(indexOf(course.getCRN()) != -1){
          String msg = String.format("Duplicate CRN: %s", course.getCRN());
          throw new Exception(msg);
        }
        // if we've run out of room in our array, we double its size
        if(numCourses == courses.length) {
            // create a blank array of twice the size of our current one
            newCourses = new Course[courses.length * 2];
            
            // copy our old elements into our new array
            System.arraycopy(courses, 0, newCourses, 0, numCourses);
            
            // re-direct our instance variable to point to the new array
            courses = newCourses;
        }// if
        
        // now add the course
        courses[numCourses] = course;
        numCourses++;
    }// addCourse
    
    // takes a String specifying the CRN of the course to remove;
    // returns Course reference if the course is found and deleted; null otherwise
    public Course removeCourse(String crn) {
        Course result = null;
        int index = indexOf(crn);   // simple linear search
        
        // course numbers must be positive
        if(index >= 0) {
            // Get the deleted course as our return result
            result = courses[index];
            // "Delete" the course by replacing it with the last course reference
            courses[index] = courses[numCourses - 1];
            
            // we're done; subtract the number of courses and indicate success
            numCourses --;
        }// if
        
        return result;
    }// removeCourse
    
    // takes a String specifying the CRN of the course to search for;
    // returns the index if found, or -1 if not found
    public int indexOf(String crn) {
        int result = -1;
        int i = 0;
        
        // continue searching while (a) we haven't found our course, as long
        // as we're within the bounds of our array
        while(i < numCourses && result == -1) {
            if(courses[i].getCRN().equals(crn)) 
                result = i;
            i ++;
        }// while
        
        return result;
    }// indexOf
    
    // returns a string showing the entire contents of the list
    public String toString() {
        String result = "There are " + numCourses + " courses available:\n";
        int i;
        
        // loop through all of our courses and concatenate their string representations
        for(i = 0; i < numCourses; i ++)
            result += "\t" + courses[i] + '\n';
        
        return result;
    }// toString
}// class CourseListQ2