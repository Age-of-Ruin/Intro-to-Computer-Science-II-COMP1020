/*
 * LinkedList
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 4, Question: 1 & 2
 * @author     Richard Constantine
 * @version    2016/03/31
 * 
 * Purpose: Creates a linked list (using the classes LinkedList and Node) to store/edit text from a file.
 */
import java.io.*;
import java.util.Scanner;

public class LinkedList {
  //Instance Variables
  private Node top;
  private Node last;
  private int size;
  private Node alphaNode;
  private int alphaSize; 
  
  //Constructor 1
  public LinkedList(){
    top = null;
    last = null;
    size = 0;
    alphaNode = null;
    alphaSize = 0;
  }
  
  /* 
   * [null constructor to initialize all instance variables]
   * [Input: Receives input from the a method and acts to initialize the instance variables]
   * [Output: Sets initial values for these variables]
   *
   * @param [N/A]
   * 
   * @return [N/A]
   */
  
  //Constructor 2
    public LinkedList(String fileName){
      Scanner lineReader = null; 
      Scanner wordReader = null; 
      
    try 
    {
      lineReader = new Scanner(new File (fileName));
      String line = "";
      String word = ""; 
      
      while (lineReader.hasNextLine()){
        
        line = lineReader.nextLine(); // read lines
        wordReader = new Scanner(line); // read words
        
        while(wordReader.hasNext()){
          
        word = wordReader.next(); 
        append(word); // add word to end of list
        insertAlpha(last);
        
        size++; // increase size

        }//while
        wordReader.close();
      }//while
      lineReader.close();
    }//try
   
    catch(IOException e)
     {
       System.out.println(e.getMessage());
     }//catch 
    }
  
  /* 
   * [a constructor that reads the file 'darwin.txt' and calls the appropriate methods to create a justifyed
   *  version of the text or to alphabetize it]
   * [Input: Receives input from the a method and acts to read the file]
   * [Output: Passes each word from the list to the appropriate method (append or insertAlpha)]
   *
   * @param [N/A]
   * 
   * @return [N/A]
   */
    
  public int size(){
    return size;
  }//size
  
  /* 
   * [the size method returns the number of words/size of linked list]
   * [Input: Gets called from a method to return a value]
   * [Output: Returns the size of the linked list]
   *
   * @param [N/A]
   * 
   * @return [an integer size of the linked list]
   */
  
  public void append(String s){
    if(top == null && last == null){
      Node newNode = new Node(s); 
      top = newNode; // set first node
      last = newNode;        
    }//if
    else{
      Node newNode = new Node(s); // update last node
      last.setNext(newNode); 
      last = newNode;
    }//else
  }//append
  
  /* 
   * [the append method adds word/node to the last position in the list]
   * [Input: Gets passed a word to add the list]
   * [Output: Updates the end of linked list with the word passed to it]
   *
   * @param [firstParam: the string word being added to the list]
   * 
   * @return [N/A]
   */
  
  public String format(int width){
    String result = "";
    Node pointer = top; 
    String line = "";
    String word = "";
    int lineCount = 0;
    
    while(pointer != null) {
      
      word = pointer.getData();
      
      if(line.length() == 0)
        line = word; // start first line
      
      else if(line.length() + word.length() + 1 <= width)
           line += " " + word; // add subsequent words with spaces
      else {
           lineCount++; 
           
          if(lineCount % 2 == 1) // justify every second line right then left
             result += justifyLeft(line, width) + "\n";
           
           else
            result += justifyRight(line, width) + "\n";
           
           line = ""; // reset line
         }//else
     
      pointer = pointer.getNext(); 
    }//while
    
    result += line + "\n"; // add last unfinished line
    return result;
  }//format 
  
  /* 
   * [the format method iterates through the linked list, formatting the words stored in the list such that
   *  each line is within the width parameter which specifies the number of characters for each line as well as 
   *  justifys each line right and left alternating]
   * [Input: Gets passed a word to add the list]
   * [Output: Formats the text so that it is within the width and justified]
   *
   * @param [firstParam: the integer value of the width of characters for each line]
   * 
   * @return [a formatted string alternating right/left justified and within the width parameter ]
   */
  
  private String justifyRight(String line, int width){
    String [] arrayOfBlanks = null;
    String [] wordArray = null;
    String newString = "";
    int endSpaces = 0;
    
    wordArray = line.split(" "); // split line into an array of words
    arrayOfBlanks = new String[wordArray.length - 1]; // make array of the spaces (don't count space(s) at end of line)
    
    endSpaces = width - line.length(); // calculate number of spaces at end of line
    
    // sets blanks from middle of line
    for(int i = 0; i < arrayOfBlanks.length; i++){
      arrayOfBlanks[i] = " ";
    }//for
   
    // adds blanks from end of line (starting from the right going left - accounts for more blanks than words)
    for(int i = 0; i < endSpaces; i++)
      arrayOfBlanks[arrayOfBlanks.length - 1 - i % arrayOfBlanks.length] += " ";
   
    newString = wordArray[0]; // start building justified string
    
    for(int i = 0; i < arrayOfBlanks.length; i++)
      newString += arrayOfBlanks[i] + wordArray[i+1]; // add blanks starting after first word
    
    return newString;
  }//justifyRight
  
  /* 
   * [the justifyRight method adds any extra spaces within a line and evenly distributes them starting from
   *  the rightside of the line (also accounting for the case when there are more blanks than words]
   * [Input: Gets passed a line to be justified]
   * [Output: Returns the formatted text so the spaces are evenly distributed throughout, starting from the right]]
   *
   * @param [firstParam: String value of the line being formatted/justified]
   * @param [secondParam: integer value of the width parameter (used to calculate the padded spaces)]
   * 
   * @return [a formatted string alternating that is justified to the right]
   */
  
  private String justifyLeft(String line, int width){
    String [] arrayOfBlanks = null;
    String [] wordArray = null;
    String newString = "";
    int endSpaces = 0;
    
    wordArray = line.split(" "); // split line into an array of words
    arrayOfBlanks = new String[wordArray.length - 1]; // make array of the spaces (don't count space(s) at end of line)
    
    endSpaces = width - line.length(); // calculate number of spaces at end of line
    
    // sets blanks from middle of line
    for(int i = 0; i < arrayOfBlanks.length; i++){
      arrayOfBlanks[i] = " ";
    }//for
   
    // adds blanks from end of line (starting from the left going right - accounts for more blanks than words)
    for(int i = 0; i < endSpaces; i++)
      arrayOfBlanks[i % arrayOfBlanks.length] += " ";
   
    newString = wordArray[0]; // start building justified string
    
    for(int i = 0; i < arrayOfBlanks.length; i++)
      newString += arrayOfBlanks[i] + wordArray[i+1]; // add blanks starting after first word
    
    return newString;
  }//justifyLeft
  
  /* 
   * [the justifyLeft method adds any extra spaces within a line and evenly distributes them starting from
   *  the leftside of the line (also accounting for the case when there are more blanks than words]
   * [Input: Gets passed a line to be justified]
   * [Output: Returns the formatted text so the spaces are evenly distributed throughout, starting from the left]
   *
   * @param [firstParam: String value of the line being formatted/justified]
   * @param [secondParam: integer value of the width parameter (used to calculate the padded spaces)]
   * 
   * @return [a formatted string alternating that is justified to the left]
   */
 
///////////////////////////////////////////////////////////////// Q2 

  public int sizeAlpha(){
    return alphaSize;
  }//sizeAlpha
  
   /* 
   * [the sizeAlpha method returns the number of words/size of alphabetical linked list]
   * [Input: Gets called from a method to return a value]
   * [Output: Returns the size of the linked list]
   *
   * @param [N/A]
   * 
   * @return [an integer size of the alphabetical linked list]
   */
  
  public String toAlphaString(){    
    String result = "";
    Node pointer = alphaNode; //Start at the first one
    
    while(pointer != null) {
      result += toAlpha(pointer.getData()) + " ";
      pointer = pointer.getAlpha(); //Advance to next 
    }//while
    return result;
  }//toAlphaString
     
  /* 
   * [the toAlphaString method runs through the alphabetical linked list and prints the results]
   * [Input: Gets called from a method to convert the alphabetical linked list to a readable string]
   * [Output: Returns a concatenated string containing the list]
   *
   * @param [N/A]
   * 
   * @return [a concatenated string containing the alphabetical linked list]
   */
  
  public String toAlpha(String word){
    String result = "";
    result = word.toLowerCase(); // turn word to lower case
    result = result.replaceAll("[^\\p{Alpha}-']", ""); // remove non-alpha characters like "-" and "'".
    return result;
  }//toAlpha
  
  /* 
   * [the toAlpha method converts any word to lower case and filters out problem puncuation (for comparing
   *  the data)]
   * [Input: Gets called from a method to convert a word to one more easily comparable, i.e. rix the aforementioned]
   * [Output: Returns the corrected word for use in comparing/alphabetizing]
   *
   * @param [string word to be corrected]
   * 
   * @return [the corrected string word]
   */

  public void insertAlpha(Node keyNode){
    Node prev = null;
    Node next = alphaNode;
    String keyData = toAlpha(keyNode.getData());
    
    //check if end of list or key is smaller than next data
    while(next != null && toAlpha(next.getData()).compareTo(keyData) < 0){ 
      prev = next;
      next = next.getAlpha();
    }//while
    // This item may belong  in the list (if not already there)
    if(next == null || toAlpha(next.getData()).compareTo(keyData) > 0){
      if(prev == null)
        alphaNode = keyNode;
      else
        prev.setAlpha(keyNode);
      
      keyNode.setAlpha(next);
      alphaSize++;
    }//if
  }//insertAlpha
  
  /* 
   * [the insertAlpha method creates the alphabetized linked list]
   * [Input: Gets called to add nodes in alphatbetical order to a linked list ]
   * [Output: Creates the alphabetized linked list]
   *
   * @param [node to be added to the list]
   * 
   * @return [void]
   */
  
}//LinkedList

/////////////////////////////////////////////////////////////// Node

class Node {
  private String data;
  private Node next;
  private Node alpha;
  
  public Node(String d) { 
    data = d;
    next = null; 
    alpha = null;
  }
  
  /* 
   * [null constructor to initialize all instance variables]
   * [Input: Receives input from the a method and acts to initialize the instance variables]
   * [Output: Sets initial values for these variables]
   *
   * @param [N/A]
   * 
   * @return [N/A]
   */
 
  // Mutators & Accessors
  public Node getNext(){
    return next;
  }//getNext
  
  public String getData(){
    return data;
  }//getData
 
  public void setNext(Node n){
    next = n;
  }//setNext 
  
  public void setData(String d){
    data = d;
  }//setData

//////////////////////////////////////////////////////////////// Q2

  public Node getAlpha(){
    return alpha;
  }//getAlpha
  
  public void setAlpha(Node a){
    alpha = a;
  }//setAlpha
  
}//Node
