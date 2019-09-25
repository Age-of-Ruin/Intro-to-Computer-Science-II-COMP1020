/**
 * TemplateLab11Bronze.java
 * (C) Computer Science, University of Manitoba
 * Lab 11 Bronze Exercise
 * COMP 1020 Winter 2016
 */
public class TemplateLab11Bronze {
  
  //The constants controlling the random test data
  public static final int TEST_LIST_SIZE = 15;
  public static final int DATA_RANGE = 100;
  
  public static void main(String[] args) { 
    LinkedList randomList = new LinkedList();
    LinkedList subList1 = new LinkedList();
    LinkedList subList2 = new LinkedList();
    
    //Create a list of random values
    for(int i=0; i<TEST_LIST_SIZE; i++)
      randomList.addFront(new Node((int)(DATA_RANGE*Math.random()),null));
    
    //Print the list, call the split method, and print the results
    System.out.println("Original list:\n"+randomList);
    split(randomList, subList1, subList2);
    System.out.println("First sublist:\n"+subList1);
    System.out.println("Second sublist:\n"+subList2);
    System.out.println("Original list:\n"+randomList);
    
  }//main
  
  public static void split(LinkedList mainList,
                           LinkedList list1,
                           LinkedList list2){
    //Add all of the nodes in mainList to the two
    //lists list1 and list2, equally. The mainList
    //will become empty in the process.

    //****COMPLETE THE METHOD****
    
  }//split
  
}//TemplateLab11Br