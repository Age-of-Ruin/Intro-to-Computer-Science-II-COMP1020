/*
 * TextBox
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 3, Question: 1
 * @author     Richard Constantine
 * @version    2016/03/18
 * 
 * Purpose: Stores a list of objects that will be used/drawn for a graphical user interface.
 */
public class TextBox extends GUIelement {
  
  //Constants
  private static final double MARGIN = 0.005;

  //Instance Variables
  private boolean input; 
  
  //Constructor
  public TextBox(double xc, double yc, double hw, double hh, String txt, boolean inp){ 
    super(xc,yc,hw,hh,txt,false);
    input = inp;
  }
  
  /* 
   * [The TextBox constructor initializes 6 instance variables (i.e. xCentre, yCentre, halfHeight, halfWidth, text and
   *  highlighted) by utilizing the super class (GUIelement) constructor as well as the boolean variable determining
   *  whether the box is ready for input] 
   * [Input: Receives input from the a method and acts to initialize values]
   * [Output: Handles the text boxs within the GUI]
   *
   * @param [firstParam: x center]
   * @param [secondParam: y center]
   * @param [thirdParam: half width]
   * @param [thirdParam: half height]
   * @param [fifthParam: title/text to be displayed]
   * @param [sixthParam: boolean determining the input state of the textbox]
   *
   * @return [N/A]
   */

  public void draw(){    
    StdDraw.setPenRadius(); //Make sure it's a standard narrow pen
    super.draw(); //Let the superclass draw the outer square
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.textLeft(xCentre-halfWidth+MARGIN,yCentre,text); //Add the text
  }//draw
  
  /* 
   * [The draw method draws the box with text insided for use as a text box and, when selected, fills it with the 
   *  characters typed by the user] 
   * [Input: Gets called by a method and acts to draw the box; the user can also influence the text within the
   *  box by clicking/selecting it and typing]
   * [Output: Draws a rectangular button with text inside that can be typed in]
   * 
   *
   * @param [N/A]
   * @return [void]
   */
  
  public boolean handleClick(double x, double y) {
    boolean result = false;
    if(super.handleClick(x,y)){ //The superclass method is always used first.
      text = ""; //Empty text box contents
      highlighted = true; //Toggle the box's status(ready for input)
      draw(); //And redraw it.
      result = true; //I handled it. Nobody else should.
    }//if
    else {
      result = false; //Nothing to do with me. Not in my box.
    }//else
    return result;
  }//handleClick
  
  /* 
   * [The draw method draws the box with text insided for use as a text box and, when selected, fills it with the 
   *  characters typed by the user] 
   * [Input: Receives input from a method and acts to draw the box; the user can also influence the text within the
   *  box by clicking/selecting it and typing]
   * [Output: Draws a rectangular button with text inside that can be typed in]
   * 
   *
   * @param [N/A]
   * @return [void]
   */
  
  public boolean handleCharTyped(char c) {
    boolean result = false;
    if(input && highlighted){ //Check if input and selected
      if(c != '\n'){ //If not RETURN key
        text += c; //Append keystroke to end of text in box
        draw(); //Redraw
        result = true;
      }//if
      else if (input){
        highlighted = false; //Unselect text box
        result = true;
      }//else if
      else
        result = false;
    }//if
    return result; 
  }//handleCharTyped
  
  /* 
   * [The handleCharTyped method works by concatenating any character that is not the '\n' character to a string
   *  that will be displayed in the selected text box]
   * [Input: Gets called by the a method to deal with the characters typed (only for the textbox)]
   * [Output: Concatenates the characters typed into a string an returns a boolean stating whether a 
   *  character has been typed/actioned or not]
   *
   * @param [firstParam: character being passed by another method (i.e. keyboard)]
   * 
   * @return [boolean to determine whether the specific method worked on the character]
   */
  
  public void displayText(String s){
    text = s;
    draw();    
  }//displayText

  /* 
   * [The displayText method changes the text displayed in the box to string passed to it (created by HandleCharTyped)]
   * [Input: Gets called by the a method to display the characters typed by updating the instance variable 'text']
   * [Output: Changes the text in the box to the string created in HandleCharTyped]
   *
   * @param [firstParam: the string that was created by HandleCharTyped and stored as and the instance variable 'text']
   * 
   * @return [void]
   */
  
}//TextBox
