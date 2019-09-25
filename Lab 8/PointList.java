/**
 * Lab 8
 */
public class PointList {
  
  private Node top;
  
  public PointList() { 
    top = null;
  }
  
  public void add(double x, double y){
    Node newNode = new Node(x, y, top);
    top = newNode;
  }//add
  
  public void insert(double x, double y){
    Node prev = null;
    Node next = top;
    
    while (next != null && (next.getX() < x)){
      prev = next;
      next = next.getLink();
    }//while
    
    Node newNode = new Node(x, y, next);
    
    if(prev == null)
      top = newNode;
    else
      prev.setLink(newNode);
  }//insert
  
  public void connectTheDots(){
    Node prev = null;
    Node next = top;
    while (next != null){
      prev = next;
      next = next.getLink();
      if (next != null)
        StdDraw.line(prev.getX(), prev.getY(), next.getX(), next.getY());
    }//while
  }//connectTheDots
  
  public String toString(){
    String result = "[";
    Node next = top;
    while(next != null){
      result += (" " + next.toString());
      next = next.getLink();
    }//while
    result += " ]";
    return result;
  }//toString
    
}//PointList
