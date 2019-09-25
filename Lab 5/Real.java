/**
 * Lab 5
 */
public class Real {
  
  // Instance Variables
  double realNumber;  
  
  public Real(double number) { 
    realNumber = number;
  }
  
  public String toString()
  {
   String newString = String.format("%4.2f",realNumber); 
   return newString;
  }
  
  public double magnitude()
  {
    return Math.abs(realNumber);
  }
  
}
