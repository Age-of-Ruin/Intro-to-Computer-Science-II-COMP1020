/**
 * Lab 8
 */
public class Node {
  
  private double x,y;
  private Node next;
  
  public Node(double xi, double yi, Node n) { 
    x = xi;
    y = yi;
    next = n; 
  }
  public Node getLink(){
    return next;
  }//getLink
  
  public double getX(){
    return x;
  }//getX
  
  public double getY(){
    return y;
  }//getY
  
  public void setLink(Node n){
    next = n;
  }//setLink
  
  public String toString(){
    String result = "(" + String.format("%5.3f,%5.3f", x, y) + ")";
    return result;
  }//toString
}
