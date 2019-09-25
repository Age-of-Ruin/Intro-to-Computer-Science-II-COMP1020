/*
 * A2Q2
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 2, Question: 2
 * @author     Richard Constantine
 * @version    2016/02/29
 * 
 * Purpose: This class takes an input text file of words, creates & shows a list of the unique words (ensuring
 * duplicates are not added) as well as saves these unique words in an output files. 
 */

import java.io.*;
import java.util.Scanner;

public class A2Q2 {
  
//Constants
  final int ARRAY_START_SIZE = 20;
  
  // Instance Variables
  private String[] array;
  private String inputFile;
  private String outputFile;
  private int numWords;
  
  //Constructor
  public A2Q2(String input, String output)
  {
    inputFile = input;         
    outputFile = output;
    array = new String[ARRAY_START_SIZE];
    numWords = 0;  
  }//A2Q2
   
  /* 
   * [the first constructor initializes the instance variables]
   * [Input: Receives input from the main method then acts to initalize values stored within
   * the A2Q2 object]
   * [Output: N/A]
   * 
   * @param [firstParam: receives input as a string and assigns this to the appropriate instance variable]
   * @param [secondParam: receives input as a string and assigns this to the appropriate instance variable]
   * @return [N/A]
   */
 
  private void insert (String newWord)
  {
    //expand array
    String[] newArray;    
    int newListSize;
    
    if (numWords >= array.length)
    {
      newListSize = numWords * 2;
      
      newArray = new String[newListSize];
      
      System.arraycopy(this.array, 0, newArray, 0, numWords);
      
      array = newArray;
    }//if
    
    //sort array
    String newValue = newWord;
    
    int j = numWords;
    while (j > 0 && array[j - 1].compareTo(newValue) > 0) 
    {
      array[j] = array[j - 1];
      j--;
    }//while
    
    array[j] = newValue;
    numWords++;
    
  }//insert
  
  /* 
   * [insert takes a word passed to it and stores it in an array, ensuring the the list is sorted alphabetically and
   *  large enough to store the values]
   * [Input: Receives input from the main method as word to be added to the list]
   * [Output: N/A]
   * 
   * @param [firstParam: receives input as string to be added to the list]
   * @return [N/A]
   */
  
  private int indexOf(String newWord)
  {
    //binary search
    int lo = 0;
    int hi = numWords - 1;
    
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      
      if(newWord.compareTo(array[mid]) < 0)
      {
        hi = mid - 1;
      }//if
      
      else if (newWord.compareTo(array[mid]) > 0)
      {
        lo = mid + 1;
      }//else if
      
      else
      {
        return mid;
      }//else
    }
    return -1;
  }//indexOf
   
  /* 
   * [indexOf performs a binary search for a word in the list, returning the index or -1 if not found]
   * [Input: Receives input from the main method as word to be added to the list]
   * [Output: the integer value of the index in the list or -1 if not found]
   * 
   * @param [firstParam: receives input as string to be searched in the list]
   * @return [index or -1]
   */
  
  public void removeDuplicateLines()
  {
    
    Scanner lineReader = null;
    
    try 
    {
      lineReader = new Scanner(new File (inputFile));
      
      FileWriter output = new FileWriter(outputFile);
      PrintWriter writeIt = new PrintWriter(output);
    
      while(lineReader.hasNextLine())
      {
        String line = lineReader.nextLine();
        
        if(indexOf(line) == -1)
        {
        insert(line);
        }//if
        else
        {
        System.out.println(line + " has been seen before!!");  
        }//else
      }//while 
      
      for (int i = 0; i < numWords; i++)
      {
        writeIt.println(array[i]);
      }//for
      
      output.close();
      lineReader.close();
      
    }//try
    
    catch(IOException e)
    {
      System.out.println("Nope. That didn't work: "+e.getMessage());
    }//catch 
    
  }//removeDuplicateLines
  
  /* 
   * [removeDuplicateLines reads words from a text file, checks for a duplicate word then adds it to the array 
   * if it is not already contained in the list]
   * [Input: Receives input from the main method to read the file and only add unique words to the array]
   * [Output: Writes the list to a specified output file]
   * 
   * @param [N/A]
   * @return [N/A - throws exception if I/O interupt]
   *
   */
}//A2Q2