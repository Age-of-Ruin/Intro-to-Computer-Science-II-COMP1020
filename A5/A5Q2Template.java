/* A5Q2Template.java
 * Assignment 5 Question 2
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 * 
 * Demonstrate solving a maze.
 *
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

@SuppressWarnings("unchecked")
public class A5Q2Template {

  // A global variable for the BEST solution
  public static ArrayList<Coord> bestSolution = null;
  // A global Random object for choosing a random direction
  static Random rnd = new Random();

  //---------- main method -----------------------
  
  public static void main(String[] args) throws Exception {
    /* Reads in a maze from the file TestMaze.txt. The first line
     * must contain n - the size of the maze (which must be square).
     * Then there must be n lines of n characters each, where X is
     * a valid place to go, and any other character is a "wall".
     * The starting point is always (0,0) and the goal point is
     * always (n-1,n-1).
     */
    boolean[][] theMaze;
    Scanner inputFile = new Scanner(new File("TestMaze.txt"));
    int n = Integer.parseInt(inputFile.nextLine());
    theMaze = new boolean[n][n];
    for(int row=0; row<n; row++){
      String line = inputFile.nextLine();
      for(int col=0; col<n; col++)
        theMaze[row][col] = line.charAt(col)=='X';
    }//for row
    Coord start = new Coord(0, 0);
    Coord goal = new Coord(n-1, n-1);
    
    // solve does not return a result, uses global bestSolution.
    solve(new ArrayList<Coord>(), start, goal, theMaze);

    if(bestSolution==null)
      System.out.println("You can't get there from here.");
    else{
      System.out.println("The path of size "+bestSolution.size()+" is:\n"+bestSolution);
      displayProgress(bestSolution, start, goal, theMaze);
    }
  }//main
  
  
  //---------- a global variable to define the ways you can move ---------
  
  //The four directions that you can try to move in the maze
  private static Coord[] directions = {new Coord(-1,0),
                                       new Coord(1,0),
                                       new Coord(0,-1),
                                       new Coord(0,1)};
  private static int numDir = 4;
  
  
  //------------ the maze solver ---------------------------
  
  public static void solve(ArrayList<Coord> path,
                                       Coord currentSpot,
                                       Coord goal,
                                       boolean[][] maze){
    /* Attempts to solve the given maze by getting to a goal spot,
     * from a currentSpot, which has been reached by the given path.
     * It will set the global variable bestSolution to the shortest solution
     * ever found. It will return nothing.
     */
    
    //Make a copy of the path, because...
    ArrayList<Coord> newPath = (ArrayList<Coord>)(path.clone());
    newPath.add(currentSpot); //...you shouldn't touch the original parameter!
    displayProgress(path,currentSpot,goal,maze); //Draws the graphics
    
    if(currentSpot.equals(goal)){
      // We have found a solution.
      // If this is the first solution found, or it is shorter than 
      // the previous solution, update the global parm bestSolution
      // Else, redraw the graphics to show the backtracking.
    }
    else {
      // add/modify code here to choose a random starting direction
      for(int i=0; i<directions.length; i++){ //Try all directions
        Coord nextSpot = currentSpot.addTo(directions[i]); //Where you get to
        if(nextSpot.validSpot(maze)) //Can we even go there?
          if(!newPath.contains(nextSpot)){ //Have we been there already?
            solve(newPath,nextSpot,goal,maze);
        }//ifs
      }//for
    }//else (recursive case)
  }//solve
    
  //----- displayProgress --------------------------------
  // (Displays the current progress of the search graphically)
  
  public static void displayProgress(ArrayList<Coord> path,
                                     Coord currentSpot,
                                     Coord goal,
                                     boolean[][] maze){
    int nRows = maze.length;
    int nCols = maze[0].length;
    double rowStep = 1.0/nRows;
    double colStep = 1.0/nCols;
    StdDraw.show(0);
    StdDraw.clear();
    StdDraw.rectangle(0.5,0.5,0.5,0.5);
    for(int row=0; row<nRows; row++)
      for(int col=0; col<nCols; col++){
        if(!maze[row][col])
          StdDraw.setPenColor(StdDraw.BLACK);
        else if(currentSpot.equals(row,col))
          StdDraw.setPenColor(StdDraw.RED);
        else if(goal.equals(row,col))
          StdDraw.setPenColor(StdDraw.GREEN);
        else if(path.contains(new Coord(row,col)))
          StdDraw.setPenColor(StdDraw.YELLOW);
        else
          StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle((col+0.5)*rowStep,
                                ((nRows-row-1)+0.5)*colStep,
                                rowStep/2.0, colStep/2.0);
        }
    StdDraw.show(100);
    while(StdDraw.mousePressed())
      StdDraw.show(20);
  }//displayProgress
}//class A5Q2Template




//This smaller non-public class will be very handy to
//store (row,col) pairs of co-ordinates in the maze.

class Coord {
  private int row;
  private int col;
  public Coord(int r, int c){
    row = r;
    col = c;
  }//constructor
  
  /* There is a subtle point here - the parameter of .equals
   * MUST always be Object or else it won't over-ride the superclass's
   * .equals method (the signatures will be different). And the
   * Object .equals method just compares references - not useful!
   */
  public boolean equals(Object other){
    return (row==((Coord)other).row)&&(col==((Coord)other).col);
  }//equals

  //This is a different kind of equals - only used in the display method
  public boolean equals(int r, int c){
    return (row==r)&&(col==c);
  }
  
  //This allows a coordinate to "move"
  public Coord addTo(Coord move){
    return new Coord(row+move.row,col+move.col);
  }//addTo
  
  //Is this coordinate somewhere you can go in this maze?
  public boolean validSpot(boolean[][] maze){
    if(row<0 || row>=maze.length || col<0 || col>=maze[0].length)
      return false; //It's "off the edge" in some direction
    else
      return maze[row][col];
  }//validSpot
  
  public String toString(){
    return "("+row+","+col+")";
  }
  
}//Coord class