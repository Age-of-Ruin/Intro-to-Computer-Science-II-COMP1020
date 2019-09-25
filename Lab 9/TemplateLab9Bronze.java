import java.util.Arrays;

/**
 * TemplateLab9Bronze.java
 * COMP 1020 2016 Winter
 * (C) Computer Science University of Manitoba
 * A simple recursive method to find the sum of a list,
 * and a main program to test it.
 */
public class TemplateLab9Bronze {
  
  
  public static void main(String[] args) { 
    double[] test = {2.3,5.6,9.8,-6.5,7.2,4.4};
    System.out.println("The sum of the array "+Arrays.toString(test)+
                       "\n is "+sumOfList(test.length,test));
    test = new double[]{1.1};
    System.out.println("The sum of the array "+Arrays.toString(test)+
                       "\n is "+sumOfList(test.length,test));
  }//main
  
  public static double sumOfList(int length, double [] list){
    double sum = 0.0;
    if(length <= 1)
      sum = list[0];
    else
      sum = list[length - 1] + sumOfList(length - 1, list);
    
    return sum;  
  }//sumOfList
  
}