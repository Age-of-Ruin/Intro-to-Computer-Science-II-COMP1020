/**
 * A class for rectangular arrays full of random
 * positive integers.
 */
import java.util.Random; //For the random number generator

public class RandomArray {
  
  //An object that will provide the random numbers
  static Random randomGenerator = new Random();
  
  //An instance variable to hold an array of integers
  private int [][] intArray;
  
  public RandomArray(int rows, int cols, int range) { 
    /* Construct a random array with the given number of
     * rows and columns   filled with random integers in 
     * the range  0..range-1 */
    intArray = new int[rows][cols];
    int randomNum;
    
    for (int numRows=0; numRows<rows; numRows++)
    {
      for (int numCols=0; numCols<cols; numCols++)
      {
         randomNum = randomGenerator.nextInt(range);
         intArray[numRows][numCols] = randomNum;
      } 
    }
  
  }//constructor

  public int[] getRow(int r){
    //Return an int[] array containing the numbers from row r.
    int[] row = new int[intArray[r].length];
    
    for (int i=0; i<row.length; i++)
      row[i] = intArray[r][i];
          
    return row; 
  }//getRow method
  
  public int[] getCol(int c){
    //Return an int[] array containing the numbers from column c.
    int[] col = new int[intArray.length];
    
    for (int i=0; i<col.length; i++)
      col[i] = intArray[i][c];
 
    return col; 
  }//getCol method

}//RandomArray class