/**
 * TestLab8Bronze.java
 * Lab 8 Bronze Exercise
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */

public class TestLab8Bronze {
  
  public static void main(String[] args) { 
    final int NUM_POINTS = 5;
    //Create a PointList linked list.
    PointList points = new PointList();
    //Add random (x,y) points to it.
    for(int i=0; i<NUM_POINTS; i++)
      points.add(Math.random(),Math.random());
    //Print it out
    System.out.println("Points are: "+points);
  }
  
}