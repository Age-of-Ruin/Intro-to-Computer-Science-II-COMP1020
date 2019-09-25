/**
 * Template
 * COMP 1020 Winter 2016
 * Lab 4 Bronze Exercise
 */
import java.io.*; //Required for most I/O operations
import java.util.Scanner;

public class TemplateLab4Bronze {
  
  static final String INPUT_FILE = "testLab4Bronze.txt";
  static final String OUTPUT_FILE = "outputLab4Bronze.txt";
  
  public static void main(String[] args) {
    
    try 
    {
      FileReader inputFile = new FileReader(INPUT_FILE);
      BufferedReader readIt = new BufferedReader(inputFile);
      
      FileWriter outputFile = new FileWriter(OUTPUT_FILE);
      PrintWriter writeIt = new PrintWriter(outputFile);
      
      int count = 1;
      String nextLine = readIt.readLine();
      
      while(nextLine != null)
      {
        writeIt.println(count + ": " + nextLine);
        nextLine = readIt.readLine();
        count++;
      }
      
      inputFile.close();
      outputFile.close();
    }
 
  catch(IOException e){
    System.out.println("Nope. That didn't work: "+e.getMessage());
  }
 
  System.out.println("\nEnd of processing.\nProgrammed by Richard Constantine.");
  }//main
  
}//TemplateLab4Bronze