/**
 * LinkedList.java
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */

import java.io.*;

class Node{
  // instance variables for A4Q1
  private String data;
  private Node link;
  // added for A4Q2
  private Node linkAlpha;
  
  // constructor
  public Node(String d){
    data = d;
    link = null;
    linkAlpha = null;   // added for A4Q2
  }// constructor
  
  // accessors and mutators
  public String getData(){ return data; }
  public void setData(String d){ data = d; }
  public Node getLink(){ return link; }
  public void setLink(Node l){ link = l; }
  // added for A4Q2
  public Node getLinkAlpha(){ return linkAlpha; }
  public void setLinkAlpha(Node l){ linkAlpha = l; }
}// class Node

public class LinkedList{
  // instance variables for A4Q1
  private Node first;
  private Node last;
  private int size;
  // added for A4Q2
  private Node firstAlpha;
  private int sizeAlpha;
  
  // default constructor
  public LinkedList(){
    first = last = null;
    size = 0;
    // added for A4Q2
    firstAlpha = null;
    sizeAlpha = 0;
  }// constructor
  
  // initialization constructor
  public LinkedList(String fileName){
    BufferedReader reader = null;    // to read the input file
    String line = null;              // a line from the file
    String [] words = null;          // words on a line
    try{
      reader = new BufferedReader(new FileReader(fileName));
      while((line = reader.readLine()) != null){
        words = line.split("\\p{Space}+");
        for(int i = 0; i < words.length; i++){
          append(words[i]);
          size++;
          insertAlpha(last);    // added for A4Q2
        }
      }// while
    } catch(IOException e){
      System.out.println(e);
    }// try/catch
  }// initialization constructor
  
  public int size(){ return size; }
  
  // add a new word to the end of the list
  public void append(String key){
    Node newNode = new Node(key);
    if(first == null)
      first = last = newNode;
    else{
      last.setLink(newNode);
      last = newNode;
    }
  }// append
  
  public String format(int width){
    String result = "";      // the return result
    String line = "";        // one line in the result
    Node curr = first;       // for traversal
    String word = null;      // a word from the list
    int lineCount = 0;       // for even/odd
    while(curr != null){
      word = curr.getData();
      if(line.length() == 0)
        line += word;
      else if(line.length() + word.length() + 1 <= width)
        line += " " + word;
      else {
        lineCount++;
        if(lineCount % 2 == 0)
          result += justifyRight(line, width) + "\n";
        else
          result += justifyLeft(line, width) + "\n";
        line = word;
      }
      curr = curr.getLink();  // advance the traversal
    }// while
    result += line + '\n';   // add the last line
    return result;
  }// format
  
  
  private String justifyLeft(String line, int width){
    String result = "";      // the return result
    String [] words = null;  // the words in this line
    String [] blanks = null; // the blanks between the words
    int padding = 0;         // how many extra blanks needed
    
    padding = width - line.length();
    
    words = line.split(" ");
    // initialize the array of blanks
    blanks = new String[words.length - 1];
    for(int i = 0; i < blanks.length; i++)
      blanks[i] = " ";
    // now add the additional blanks needed
    for(int i = 0; i < padding; i++)
      blanks[i % blanks.length] += " ";
    
    // now make the result
    result = words[0];
    for(int i = 0; i < blanks.length; i++)
      result += blanks[i] + words[i+1];
    return result;
  }// justifyLeft

  private String justifyRight(String line, int width){
    String result = "";      // the return result
    String [] words = null;  // the words in this line
    String [] blanks = null; // the blanks between the words
    int padding = 0;         // how many extra blanks needed
    
    padding = width - line.length();
    
    words = line.split(" ");
    // initialize the array of blanks
    blanks = new String[words.length - 1];
    for(int i = 0; i < blanks.length; i++)
      blanks[i] = " ";
    // now add the additional blanks needed
    for(int i = 0; i < padding; i++)
      blanks[blanks.length - 1 - i % blanks.length] += " ";
    
    // now make the result
    result = words[0];
    for(int i = 0; i < blanks.length; i++)
      result += blanks[i] + words[i+1];
    return result;
  }// justifyRight
  
  /**************************************************************
    * added for A4Q2
    */
  
  public int sizeAlpha(){ return sizeAlpha; }
  
  public String toAlphaString(){
    String result = "";
    Node curr = firstAlpha;
    while(curr != null){
      result += toAlpha(curr.getData()) + " ";
      curr = curr.getLinkAlpha();
    }
    return result;
  }// toAlphaString
  
  private String toAlpha(String word){
    String result = word.toLowerCase();
    return result.replaceAll("[^\\p{Alpha}-']", "");
  }// toAlpha
  
  public void insertAlpha(Node keyNode){
    String key = toAlpha(keyNode.getData());
    Node prev = null;
    Node curr = firstAlpha;
    while(curr != null && key.compareTo(toAlpha(curr.getData())) > 0){
      prev = curr;
      curr = curr.getLinkAlpha();
    }// end of traversal
    // find out why the traversal stopped
    if(curr == null || key.compareTo(toAlpha(curr.getData())) < 0){
      // do the insertion
      sizeAlpha++;
      if(prev == null){
        firstAlpha = keyNode;
      } else {
        prev.setLinkAlpha(keyNode);
      }
      keyNode.setLinkAlpha(curr);
    }
  }// insertAlpha
  
}// class LinkedList

