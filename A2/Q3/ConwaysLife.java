/**
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 * Implement a simulation of John Conway's Game of Life
 */
import java.io.*;
import java.util.Scanner;

public class ConwaysLife {
  
  //---------  Instance variables  -------------------------
  
  private int boardSize;  
  private boolean[][] board;
  private boolean[][] nextBoard; //Used to calculate the next generation
  
  //---------  Constructors  --------------------------------
  
  public ConwaysLife(int size, double density) {
    
    boardSize = size;
    
    board = new boolean[boardSize][boardSize];
    nextBoard = new boolean[boardSize][boardSize];
    
    for (int row = 0; row < boardSize; row++)
    {
      for(int col = 0; col < boardSize; col++) 
      {
        if (Math.random() >= density) //alive
        {        
          board[row][col] = true;
        }//if
        else
        {
          board[row][col] = false;  //dead
        }//else
      }//for
    }//for
    
  }//conwaysLife
  
  public ConwaysLife(File chosenFile) {
    
    Scanner lineReader = null; 
    boardSize = 0;
    
    try 
    {
      lineReader = new Scanner(chosenFile);
      String line = lineReader.nextLine();
      boardSize = Integer.parseInt(line);
      
      board = new boolean[boardSize][boardSize];
      nextBoard = new boolean[boardSize][boardSize];
      
      while(lineReader.hasNextLine())
      { 
        for(int row = 0; row < boardSize; row++)
        { 
          line = lineReader.nextLine();
          
          for(int col = 0; col < boardSize; col++)
          {
            board[row][col] = line.charAt(col) == 'X';
          }//for
        }//for 
      }//while
    }//try
    
    catch(IOException e)
    {
      System.out.println("Nope. That didn't work: "+e.getMessage());
    } 
    lineReader.close();
  }//ConwaysLife
  
  //----------------  Calculate the next generation -----------------
  
  public void nextGeneration( )
  {
    //Generate nextBoard from board (get the next generation
    
    for(int row = 0; row < boardSize; row++)
    {
      for(int col = 0; col < boardSize; col++)
      {
        int neighbours = countNeighbours(row,col);
        
        if (board[row][col] && (neighbours == 3 || neighbours == 2)) //survival rule
          nextBoard[row][col] = true;
        else if (!board[row][col] && neighbours == 3) // birth rule
          nextBoard[row][col] = true;
        else
          nextBoard[row][col] = false; 
        
      }//for
      
    }//for
    
    //Swap the two boards so that the next generation becomes the board
    boolean[][] temp = board;
    board = nextBoard;
    nextBoard = temp;
  }//nextGeneration
  
  private int countNeighbours(int row, int col)
  {
    int count = 0;
    
    if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1]) //top left
    {
      count ++; 
    }
    if (row - 1 >= 0 && board[row - 1][col]) //top
    {
      count ++; 
    }
    if (row - 1 >= 0 && col + 1 < boardSize && board[row - 1][col + 1]) //top right
    {
      count ++; 
    }
    if (col + 1 < boardSize && board[row][col + 1]) //right
    {
      count ++; 
    }
    if (row + 1 < boardSize && col + 1 < boardSize && board[row + 1][col + 1]) //bottom right
    {
      count ++; 
    }
    if (row + 1 < boardSize && board[row + 1][col]) //bottom
    {
      count ++; 
    }
    if (row + 1 < boardSize && col - 1 >= 0 && board[row + 1][col - 1]) //bottom left
    {
      count ++; 
    }
    if (col - 1 >= 0 && board[row][col - 1]) //left
    {
      count ++; 
    }
    
    return count;
    
  }//countNeighbours
  
  
  //---------------- draw method --------------------------------- 
  
  public void draw(){
    //Draw the board using StdDraw graphics
    for(int i=0; i<=boardSize; i++){
      StdDraw.line(0,(double)i/boardSize,1,(double)i/boardSize);
      StdDraw.line((double)i/boardSize,0,(double)i/boardSize,1);
    }
    for(int r=0; r<boardSize; r++)
      for(int c=0; c<boardSize; c++)
      if(board[r][c])
      StdDraw.filledCircle((2*c+1)/(2.0*boardSize),
                           1.0-(2*r+1)/(2.0*boardSize),
                           1/(2.0*boardSize));
  }//draw
  
  //-------------  toString method  --------------------
  
  public String toString(){
    String result = "";
    for(int r=0; r<boardSize; r++){
      for(int c=0; c<boardSize; c++)
        if(board[r][c])
        result += 'X';
      else 
        result += '.';
      result += '\n';
    }
    return result;
  }//toString
  
}//ConwaysLife class