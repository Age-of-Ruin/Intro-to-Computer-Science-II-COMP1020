/* COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 * Assignment 2 Question 2
 * A2Q2.java
 */

import java.io.*;
import java.util.Scanner;

public class A2Q2{
  
  // class constant
  private static final int SIZE = 20;
  private static final int NOT_FOUND = -1;
  
  // instance variables
  private String [] words;
  private String infile;
  private String outfile;
  private int numWords;
  
  public A2Q2(String infile, String outfile){
    this.infile = infile;
    this.outfile = outfile;
    words = new String[SIZE];
    numWords = 0;
  }// constructor
  
  private void insert(String newWord){
    // see if we need to expand the array first
    if(numWords == words.length){
      String [] newWords = new String[2 * words.length];
      for(int i = 0; i < words.length; i++)
        newWords[i] = words[i];
      words = newWords;
    }
    // use an loop to move strings to make room for the new item
    int pos = numWords;
    while(pos > 0 && words[pos-1].compareTo(newWord) > 0){
      words[pos] = words[pos-1];
      pos--;
    }// while
    words[pos] = newWord;
    numWords++;
  }// insert
  
  private int indexOf(String newWord){
    int result = NOT_FOUND;
    int lo = 0;
    int hi = numWords - 1;
    int mid = 0;
    while(result == NOT_FOUND && hi >= lo){
      mid = lo + (hi - lo)/2;
      if(words[mid].equals(newWord))  // we found it
        result = mid;
      else if(words[mid].compareTo(newWord) > 0)  // search the first half
        hi = mid - 1;
      else  // search the second half
        lo = mid + 1;
    }// while
    return result;
  }// indexOf
  
  public void removeDuplicateLines(){
    try{
      // open a Scanner for reading and read the input file
      Scanner scan = new Scanner(new File(infile));
      while(scan.hasNextLine()){
        String word = scan.nextLine();
        if(indexOf(word) == NOT_FOUND)
          insert(word);
        else
          System.out.println(word + " has been seen before!");
      }// while
      
      // now write the unique words to the output file
      PrintWriter printer = new PrintWriter(new FileWriter(outfile));
      for(int i = 0; i < numWords; i++)
        printer.println(words[i]);
      printer.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }// removeDuplicateLines
}// class A2Q2