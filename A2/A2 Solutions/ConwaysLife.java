/**
 * COMP 1020 Winter 2016
 * Assignment 2 Question 2
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
    // make the boards
    board = new boolean[boardSize][boardSize];
    nextBoard = new boolean[boardSize][boardSize];
    // fill the board with random entries
    for(int row = 0; row < boardSize; row++)
      for(int col = 0; col < boardSize; col++)
        board[row][col] = Math.random() >= density;
  }//constructor 1

  public ConwaysLife(File chosenFile) {
    try{
      Scanner scan = new Scanner(chosenFile);
      boardSize = scan.nextInt();
      scan.nextLine();
      // make the boards
      board = new boolean[boardSize][boardSize];
      nextBoard = new boolean[boardSize][boardSize];
      // fill the board with random entries
      for(int row = 0; row < boardSize; row++){
        String theRow = scan.nextLine();
        for(int col = 0; col < boardSize; col++)
          board[row][col] = theRow.charAt(col) == 'X';
      }// outer for
    } catch (FileNotFoundException e){
      System.out.println(e);
    }
  }//constructor 2
  
  //----------------  Calculate the next generation -----------------
  //Generate nextBoard from board (get the next generation)
  public void nextGeneration( ){
    // calculate the next generation
    for(int row = 0; row < boardSize; row++)
      for(int col = 0; col < boardSize; col++){
        int neighbours = countNeighbours(row, col);
        if(board[row][col]){    // survival rule
          nextBoard[row][col] = neighbours == 2 || neighbours == 3;
        } else {                // birth rule
          nextBoard[row][col] = neighbours == 3;
        }// if
      }// inner for
    
    //Swap the two boards so that the next generation becomes the board
    boolean[][] temp = board;
    board = nextBoard;
    nextBoard = temp;
  }//nextGeneration
  
  private int countNeighbours(int row, int col){
    int result = 0;
    for(int r = row-1; r <= row+1; r++)
      for(int c = col-1; c <= col+1; c++)
        if(!(r == row && c == col) && !(r < 0 || r >= boardSize) && 
           !(c < 0 || c >= boardSize) && board[r][c])
          result++;
      
    return result;
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
