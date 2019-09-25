/* Template
 * Lab 10 Bronze Exercise
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */
import java.util.ArrayList;

public class TemplateLab10Bronze {
  
  //Constants controlling the random test data
  static final int LIST_SIZE = 20;
  static final int MAX_NUMBER = 50;
  
  public static void main(String[] args) {
    //Create a random list of integers
    ArrayList<Integer> test = new ArrayList<Integer>();
    for(int i=0; i<LIST_SIZE; i++)
      test.add((int)(Math.random()*MAX_NUMBER));
    //Print the list, before and after testing the
    //printInOrder method.
    System.out.println("Original list: \n"+test);
    System.out.println("Print the list in ascending order:");
    printInOrder(test);
    System.out.println("Original list (should be empty): \n"+test);
  }//main
  
  
  public static void printInOrder(ArrayList<Integer> data){
    //Print out the elements of the ArrayList in ascending order
    //The ArrayList will be destroyed in the process, becoming empty.
    
    Integer smallestData;
    int smallestIndex = 0;
    String result = "";
      
      while(data.size() > 0){
      Integer temp = new Integer(0);
      smallestData = new Integer(10000);  
      for(int i = 0; i < data.size(); i++){
        temp = data.get(i);
        
        if (smallestData > temp){
          smallestData = temp;
          smallestIndex = i;
        }//if
          
      }//for
         result += data.remove(smallestIndex) + " " ;
    }//while
    System.out.println(result);
    
    
    
  }//printInOrder

}//TemplateLab10Bronze

