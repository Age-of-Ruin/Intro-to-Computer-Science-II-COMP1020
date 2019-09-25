/**
 * TestLab8Silver.java
 * Lab 8 Silver Exercise
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */

public class TestLab8Silver {
  
  public static void main(String[] args) { 
    final int NUM_POINTS = 50;
    //Create a PointList linked list.
    PointList points = new PointList();
    //Make sure it's OK to draw an empty list.
    points.connectTheDots();
    //Add the first point.
    points.insert(Math.random(),Math.random());
    //Make sure that doesn't cause problems, either.
    points.connectTheDots();
    //Add the rest of the random (x,y) points to it.
    for(int i=1; i<NUM_POINTS; i++)
      points.insert(Math.random(),Math.random());
    //Draw it as a set of lines
    points.connectTheDots();
  }
  
}//TestLab8Silver