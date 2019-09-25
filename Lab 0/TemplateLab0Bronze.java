/**
 * Template
 * Lab 0 Silver exercise
 * COMP 1020 - Winter 2015
 */
import java.util.Scanner; //Allows the use of Scanner input

public class TemplateLab0Bronze {
    
  public static void main(String[] args) {
    //declarations
    int[] entries = new int[100];
   
    //Call the readData() method to test it,
    int numberRead = readData(entries);
       
    //and print out the result that was returned.
    System.out.println(numberRead+" valid entries were read in:");
     
    printArray(entries, numberRead);
  
    System.out.println("Their average is " + average(entries, numberRead) + ".");
    
  }//main
  
  static int readData(int[] entries) 
  {
    /* Prompt the user to enter integer values, one at a time.
     * Values between 1 and 100 are valid. They will be accepted,
     * and echoed in a suitable message. A value of 0 will
     * cause the method to terminate. All other values will
     * cause an error message to be printed. The number of valid
     * values entered (1-100, but not 0) will be returned.
     */
    Scanner keyboard = new Scanner(System.in);
    
    //declarations
    int numOfEntries = 0;
    int input = 0;
    int entry = 0; 
    int tempValue = 100;
    int tempValue2 = 100;
    
    do{
      
      System.out.println("Enter an integer from 1 to 100 (0 to quit):");
      input = keyboard.nextInt(); // search for next integer input
      
      if (input > 0 && input < 101)
      {
        System.out.println("Entry " + input + " accepted"); // print accepted msg
                      
        for (int i = 0; i <= numOfEntries; i += 1)
        {
          entries[numOfEntries] = input;
          entry = entries[i];
          
          if (input < entry)
          {
            tempValue = entry;
            entries[i] = input;
          }
          
          else if (tempValue < entry)
          {
            tempValue2 = entry;
            entries[i] = tempValue;
            tempValue = tempValue2;
          }

        }
        
        numOfEntries += 1; // iterate count by 1
      }
      
      else
      {
        System.out.println("Invalid entry rejected."); // reject invalid entries
      }
      
    }
    while (input != 0); // iterate count while not 0
    
    keyboard.close();
    
  return numOfEntries ;
    
  }//readData
  
  static void printArray(int[]entries, int n)
  {
    //delcarations
    for (int i = 0; i < n-1; i += 1)
    {
    System.out.print(entries[i] + ","); // print entries 
    }
    
    System.out.print(entries[n-1] + "\n"); // print last entry and new line
    
  }
       
  static double average(int[] entries, int n)
  {
    //declarations
    double average = 0; 
    double sum = 0;
    
    for (int i = 0; i < n; i += 1)
    {
      sum += entries[i]; //sum entries
    }
    
    average = sum / n; //find average
    
    return average;
  }
  
  //static double median(int entries, int n)
  
  
  
}//TemplateLab0Silver