/**
 * Template
 * COMP 1020 Winter 2016
 * Lab 4 Silver Exercise
 */
import java.io.*; //Required for most I/O operations
import java.util.Scanner;

public class TemplateLab4Silver {

  static final String INPUT_FILE = "Lab4SilverTest.txt";
  static final String OUTPUT_FILE = "Lab4SilverOutput.txt";
  static final int INDENT_AMOUNT = 5;
  
  public static void main(String[] args) {
    
    final int INDENT_AMOUNT = 5;
    
    //***COMPLETE THE MAIN METHOD***
    
    System.out.println("\nEnd of processing.\nProgrammed by Stew Dent.");
  }//main
  
  public static String blanks(int n){
    String result = "";
    for(int i=0; i<n; i++)
      result+= " ";
    return result;
  }//blanks
  
}//TemplateLab4Silver