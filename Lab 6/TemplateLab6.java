/**
 * COMP 1020 Winter 2016
 * Create and perform some simple processing on a
 * list of Data objects which is a mixture of
 * Single and List objects
 */
public class TemplateLab6 {

  public static void main(String[] args) {

    Data[] myData = {
      new Single(2.4),
      new List(new double[] {3.2,6.8}),
      new List(new double[] {1.2,7.9,4.5}),
      new Single(9.8)
      };

    double sum = 0.0;
    
    for(int i = 0; i < myData.length; i++)
      sum += myData[i].valueOf();
    System.out.println("The sum of all everything is: " + sum);

    int lengthCount = 0;
    
    for(int i = 0; i < myData.length; i++){
      if(myData[i] instanceof List){
        List list = (List)myData[i];
        lengthCount += list.length();
      }
      else{
        lengthCount++;
      }
    }
    System.out.println("There are " + lengthCount + " values in total.")
    ;
    
  }//main
  
}//TemplateLab6