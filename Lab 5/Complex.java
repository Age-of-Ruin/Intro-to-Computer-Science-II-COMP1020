/**
 * Lab 5
 */
public class Complex extends Real {
  
  //Instance Variables
  double imaginary;  
  
  public Complex(double r,double c) { 
    
    super(r);
    imaginary = c;  
  }
  
  public String toString()
  {
    String newString = "";
    
    if (imaginary < 0)
      newString = super.toString() + String.format("%4.2f",imaginary) + "i";
    else
      newString = super.toString() + "+" + String.format("%4.2f",imaginary)+ "i";

    return newString;
  }
  
  
  public double magnitude()
  {
    return Math.sqrt(Math.pow(super.magnitude(), 2) + Math.pow(imaginary, 2));
  }
  
  
}
