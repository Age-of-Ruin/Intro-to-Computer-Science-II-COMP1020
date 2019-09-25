/**
 * List
 */
public class List extends Data {
  
  double[] array;
  
  public List(double[] a) { 
   array = a;
  }
  
  public double valueOf(){
    double sum = 0.0;
   
    for(int i = 0; i < array.length; i++)
      sum += array[i];
      
    return sum;
  }// value of
  
  public int length(){
    return array.length;
  }//length
  
  
  
}
