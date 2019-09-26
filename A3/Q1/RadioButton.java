/*
 * RadioButton
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 3, Question: 1
 * @author     Richard Constantine
 * @version    2016/03/18
 * 
 * Purpose: A button to be displayed on the GUI that allows the user to select an option out of a group.
 */
public class RadioButton extends GUIelement {
  
  //Constants
  private static final double MARGIN = 0.005;
  
  //Instance Variables
  private GUIgroup group;
  
  //Constructor
  public RadioButton(double xc, double yc, double radius, String title, boolean hilite, GUIgroup g){ 
    super(xc,yc,radius,radius,title,hilite);
    group = g;
  }//RadioButton
  
  /* 
   * [The Button constructor initializes 6 instance variables (i.e. xCentre, yCentre, halfHeight, halfWidth, text and
   *  highlighted) by utilizing the super class (GUIelement) constructor, as well as the group of buttons (because
   *  radio buttons work in groups and only one can be selected out them)] 
   * [Input: Receives input from the a method and acts to initialize values]
   * [Output: Handles the radio buttons in GUI by draw and resetting them when neccessary]
   *
   * @param [firstParam: x center]
   * @param [secondParam: y center]
   * @param [thirdParam: radius]
   * @param [fourthParam: title to be displayed]
   * @param [fifthParam: hilite determines whether the button shows that it is selected]
   * @param [sixthParam: group defines the group of radio buttons]
   * 
   * @return [N/A]
   */
  
  public void draw(){
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(); //Make sure it's a standard narrow pen
    StdDraw.circle(xCentre,yCentre, halfHeight); //Draw first circle
    StdDraw.textLeft(xCentre+halfWidth+MARGIN,yCentre,text); //Add the label
    if(highlighted) {
      //Inner filled circle.
      StdDraw.filledCircle(xCentre, yCentre, halfWidth - MARGIN);
    }//if  
    else{
      //Draw over with white circle (reset)
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.filledCircle(xCentre, yCentre, halfWidth - MARGIN); 
    }//else
  }//draw
  
  /* 
   * [The draw method draws a single button with the text displayed to the left of the button; once the buttons are 
   *  drawn, it draws the selected/hilighted button and resets the rest] 
   * [Input: draw is called from a method and acts to draw and reset the appropriate radio buttons]
   * [Output: Draws a button with the label positioned to the right]
   * 
   * @param [N/A]
   * @return [void]
   */
  
  public void reset(){
    highlighted = false; //Toggle the box's status
    draw(); //And redraw it.
  }//reset
  
  /* 
   * [The reset method disables the hilight variable of a particular button causing the draw method to draw over
   *  the filled/selected button] 
   * [Input: reset is called from a method and acts to reset the radioButton object passed to it]
   * [Output: Toggles the highlighted variable to false effectivly reseting the button when drawn]
   * 
   * @param [N/A]
   * @return [void]
   */
  
  public boolean handleClick(double x, double y) {
    boolean result = false; 
    if(super.handleClick(x,y)){ //The superclass method is always used first.
      group.resetRadioButtons();  //Reset buttons
      highlighted = true; //Toggle the box's status
      draw(); //And redraw it.
      result = true; //I handled it. Nobody else should.
    }//if
    else{
      result = false; //Nothing to do with me. Not in my selection.
    }//else
    return result;
  }//handleClick

  /* 
   * [The handleClick method is for tracking when a click is made in the button, toggling the selected button, and 
   *  resets any unselected buttons] 
   * [Input: Receives input from a method and acts track clicks within a particular button]
   * [Output: Updates the highlighted instance variable, resets the buttons as well as returns a boolean variable 
   * stating whether a click was dealt with]
   * 
   * @param [firstParam: x center of the button for tracking the click]
   * @param [secondParam; y center of the button for tracking the click]
   *
   * @return [a boolean telling whether the method actioned the click]
   */
  
}//RadioButton
