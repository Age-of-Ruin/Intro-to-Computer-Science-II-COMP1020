/**
 * LinkedList.java
 * (C) Computer Science, University of Manitoba
 * Lab 11 
 * COMP 1020 Winter 2016
 * 
 * An implementation of a simple linear linked list,
 * with a reference to the last Node as well as the
 * first Node to allow new data to be added to the
 * end of the list as easily as the front.
 */
public class LinkedList{
  private Node first; //The first Node in the list
  private Node last;  //The last Node in the list
  
  public LinkedList(){
    first = last = null;
  }//Constructor
  
  public Node getFirst(){
    //Return the first Node of the list.
    return first;
  }
  
  public boolean empty(){
    //Returns true if the list is empty
    return first == null;
  }//empty
  
  public boolean oneOrLess(){
    //Returns true if the list has 1 or 0 Nodes in it.
    return first==null || first.getLink()==null;
  }//empty

  public void addFront(Node newNode){
    //Add an existing Node to the front of
    //this linked list.
    newNode.setLink(first);
    first = newNode;
    if(last==null) last = newNode;
  }//add

  public void addEnd(Node newNode){
    //Add an existing Node to the end of
    //this linked list.
    newNode.setLink(null);
    if(last==null)
      first=last=newNode;
    else {
      last.setLink(newNode);
      last = newNode;
    }
  }//add

  public Node removeFirst(){
    //Remove the first Node from this list. A reference to
    //the removed Node is returned.
    if(first==null) return null; //Shouldn't happen, but...
    Node savedFirst = first;
    first = first.getLink();
    if(first==null) last=null;
    savedFirst.setLink(null); //Just in case.
    return savedFirst;
  }//removeFirst
  
  public String toString(){
    //The usual toString method which allows printing the list.
    String answer = "<<";
    for(Node next = first; next!=null; next = next.getLink())
      answer += " "+next.getData()+" ";
    return answer+">>";
  }//toString
  
}//LinkedList