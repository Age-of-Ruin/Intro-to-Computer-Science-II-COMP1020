                         /**
 * A class for rectangular arrays full of random
           * positive integers.
 */
import java.util.Random; //For the random number generator

                   public class RandomArray {
  
//An object that will provide the random numbers
        static Random randomGenerator = new Random();
  
                 //An instance variable to hold an array of integers
private int[][] data;
  
   public RandomArray(int rows, int cols, int range) { 
/* Construct a random array with the given number of
 * rows and columns, filled with random integers in 
 * the range 0..range-1 */
       data = new int[rows][cols];
    for(int r=0; r<rows; r++){
                for(int c=0; c<cols; c++){
data[r][c] = randomGenerator.nextInt(range);
}
  }
    }//constructor

                  public int[] getRow(int r){
          //Return a copy (clone) of row r of the array
       int[] result = new int[data[r].length];
    System.arraycopy(data[r],0,result,0,data[r].length);
             return result;
                     }//getRow method
  
       public int[] getCol(int c){
                   //Return an int[] array containing the numbers from column c.
int[] result = new int[data.length];
          for(int r=0; r<data.length; r++){
   result[r] = data[r][c];
              }
    return result;
       }//getCol method

                }//RandomArray class