import java.util.ArrayList;

/**
 * Template
 * Lab 7 Bronze Exercise
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */
@SuppressWarnings("unchecked")
public class TemplateLab7Bronze {
  
  public static void main(String[] args) {
    //Create two sample array lists with some common elements
    ArrayList a1 = new ArrayList();
    ArrayList a2 = new ArrayList();
    int[] data1 = {45,81, 12, 98, 34, 6, 42};
    int[] data2 = {45,6, 81, 36, 12, 77, 42};
    for(int i=0; i<data1.length; i++) a1.add(data1[i]);
    for(int i=0; i<data2.length; i++) a2.add(data2[i]);
    System.out.println("a1 is "+a1);
    System.out.println("a2 is "+a2);
    
    //Use the extractDuplicates method and print the results.
    ArrayList removed = extractDuplicates(a1,a2);
    System.out.println("removed elements: "+removed);
    System.out.println("a1 is now "+a1);
    System.out.println("a2 is now "+a2);
  }//main
  
  public static ArrayList extractDuplicates(ArrayList a1, ArrayList a2) {                                       
    
    ArrayList trimmedList = new ArrayList();
    
    for(int i1 = 0; i1 < a1.size(); i1++){
      for(int i2 = 0; i2 < a2.size(); i2++){  //generally count down due to changes in size
        if(a1.get(i1) == a2.get(i2)){
          trimmedList.add(a1.get(i1));
          a1.remove(i1);
          a2.remove(i2);      
        }//if
      }//for
    }//for
    return trimmedList;
  }//extractDuplicates
  
}//TemplateLab7Bronze