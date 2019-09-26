/*
 * Button
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 3, Question: 1
 * @author     Richard Constantine
 * @version    2016/03/18
 * 
 * Purpose: Draws a standard button that is held until the mouse is released.
 */
public class Button extends GUIelement {
  
  //Constants
  private static final double MARGIN = 0.005;
  
  //Constructor
  public Button(double xc, double yc, double hw, double hh, String title) { 
    super(xc,yc,hw,hh,title,false);
  }
  
  /* 
   * [The Button constructor initializes 6 instance variables (i.e. xCentre, yCentre, halfHeight, halfWidth, text and
   *  highlighted) by utilizing the super class (GUIelement) constructor] 
   * [Input: Receives input from the a method and acts to initialize values]
   * [Output: Creates the GUI object to be used as a rectangular button (to be clicked)]
   *
   * @param [firstParam: x center]
   * @param [secondParam: y center]
   * @param [thirdParam: half width]
   * @param [fourthParam: half height]
   * @param [fifthParam: title to display]
   * 
   * @return [N/A]
   */
 
  public void draw(){    
    StdDraw.setPenRadius(); //Make sure it's a standard narrow pen
    super.draw(); //Let the superclass draw the outer square
    StdDraw.text(xCentre,yCentre,text); //Add the label
    if(highlighted) {
      //Fill with a light gray
      StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      StdDraw.filledRectangle(xCentre, yCentre, halfWidth- MARGIN, halfHeight - MARGIN);
    }//if
  }//draw
  
  /* 
   * [The draw method draws the box with text insided for use as a button and fills it with a light grey 
   *  rectangle when clicked] 
   * [Input: Gets called by a method and acts to draw the box]
   * [Output: Draws a rectangular button with text inside that can be clicked/hilighted]
   * 
   * @param [N/A]
   * @return [void]
   */
 
  public boolean handleClick(double x, double y) {
    boolean result = false;
    if(super.handleClick(x,y)){
      highlighted = true; //Toggle the box's status
      draw(); //And redraw it.
      Utilities.waitMouseUp();// Wait until mouse is released
      result = true; //I handled it. Nobody else should.
    }//if
      highlighted = false; //Toggle the box's status
      draw(); //And redraw it.
      result = false; //Did not handle
    return result;
  }//handleClick
  
  /* 
   * [The handleClick method is for tracking when a click is made in the box, toggling off when the box is unclicked, 
   *  continuing to draw the button appropriately] 
   * [Input: Receives input from a method and acts track clicks within a particular button]
   * [Output: Updates the highlighted instance variable as well as the return boolean variable stating whether
   *  a click was dealt with]
   * 
   * @param [firstParam: x center of the button for tracking the click]
   * @param [secondParam; y center of the button for tracking the click]
   *
   * @return [a boolean telling whether the method actioned the click]
   */
  
}//Button
