/**
 * TemplateLab9Silver.java
 * COMP 1020 2016 Winter
 * (C) Computer Science University of Manitoba
 * A recursive method that draws a fractal image, and
 * a main program to test it for levels 1 to 8.
 */
public class TemplateLab9Silver {
  
  
  public static void main(String[] args) { 
    System.out.println("Click the mouse to draw the next level.");
    StdDraw.show(0);
    for(int i=1; i<=8; i++){
      StdDraw.clear();
      drawFractal(0.0,1.0,0.0,1.0,i);
      StdDraw.show(0);
      //Wait for the mouse button to go down
      while(!StdDraw.mousePressed())
        StdDraw.show(25); //Wait a bit
      //And then back up again.
      while(StdDraw.mousePressed())
        StdDraw.show(25); //Wait a bit
    }
  }
  
  public static void drawFractal(double xMin, double xMax,
                            double yMin, double yMax,
                            int nLevels){
    //******Complete the method******
    if(nLevels==0) //The easy case. Nothing to draw at all.
      return;
    else {
      //Find the middle of the area, and of each quadrant
      //X
      double xMiddle = (xMin + xMax)/2.0;
      double xLeft = (xMin + xMiddle)/2.0;
      double xRight = (xMiddle + xMax)/2.0;
      
      //Y
      double yMiddle = (yMin + yMax)/2.0;
      double yTop = (yMiddle + yMax)/2.0;
      double yBottom = (yMin + yMiddle)/2.0; 
      
      //Draw the four lines at this level.
      //Green
      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.line(xLeft, yTop, xMiddle, yMiddle);
      //Blue
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.line(xLeft, yBottom, xMiddle, yMiddle);

      //Red
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.line(xRight, yTop, xMiddle, yMiddle);

      //Black
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.line(xRight, yBottom, xMiddle, yMiddle);
      
      //Draw more fractals (one level smaller) in each quadrant.
      drawFractal(xMin, xMiddle, yMiddle, yMax, nLevels-1);//Top Left
      drawFractal(xMiddle, xMax, yMiddle, yMax, nLevels-1);//Top Right
      drawFractal(xMin, xMiddle, yMin, yMiddle, nLevels-1);//Bottom Left
      drawFractal(xMiddle, xMax, yMin, yMiddle, nLevels-1);//Bottom Right
    }//recursive case
  }//drawFractal
  
}// TemplateLab9Silver