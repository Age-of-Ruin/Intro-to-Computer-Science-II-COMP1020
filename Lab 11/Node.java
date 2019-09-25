/**
 * Node.java
 * (C) Computer Science, University of Manitoba
 * Lab 11 
 * COMP 1020 Winter 2016
 * 
 * Nodes to use when constructing a simple linear
 * linked list containing integer data.
 */
public class Node {
  private int data;
  private Node link;
  
  public Node(int d, Node n){
    data = d; link = n;
  }//constructor
  
  // get and set methods for both instance variables
  public int getData() {return data;}
  public Node getLink() {return link;}
  public void setData(int i) {data=i;}
  public void setLink(Node n) {link=n;}
  
}//Node