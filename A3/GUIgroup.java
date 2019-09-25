/*
 * GUIgroup
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 3, Question: 1
 * @author     Richard Constantine
 * @version    2016/03/18
 * 
 * Purpose: Stores a list of objects that will be used/drawn for a graphical user interface.
 */

import java.util.ArrayList;

  public class GUIgroup extends GUIelement {
  
  //Instance Variables
  private ArrayList <GUIelement> elements;
  
  //Constructor
  public GUIgroup() { 
    elements = new ArrayList <GUIelement> ();
  }
  
  /* 
   * [GUIgroup constructor initializes the arrayList used by the instance to track the elements being drawn in a
   *  particular group]
   * [Input: Receives input from the a method and acts to initialize the list]
   * [Output: Creates the list to hold the graphics of the GUI]
   *
   * @param [firstParam: N/A]
   * 
   * @return [N/A]
   */
  
  public void addElement(GUIelement e){
      elements.add(elements.size(), e);
  }//addElement
  
   /* 
   * [The addElement is a simple method that adds a drawing to the end of the arrayList of objects]
   * [Input: Receives the drawing that is to be stored to the end of the list]
   * [Output: Updates running arrayList]
   *
   * @param [firstParam: element to be added to the list]
   * 
   * @return [void]
   */
  
  public void draw(){
    for(int i = 0; i < elements.size(); i++){
      GUIelement part = elements.get(i);
      part.draw();
    }//for
  }//draw
  
   /* 
   * [The draw method works by looping through all the items in the list and calls the appropriate method using
   *  polymorphism]
   * [Input: Gets called to draw all the elements in the group]
   * [Output: Draws all elements from the list]
   *
   * @param [N/A]
   * 
   * @return [void]
   */
  
  public boolean handleClick(double x, double y){
    boolean result = false;
    for (int i = 0; i < elements.size() && !result; i++){
      result = elements.get(i).handleClick(x, y);
    }//for 
    return result;
  }//handleClick
  
   /* 
   * [The handleClick method works by looping through the items in the list, calling the appropriate method using
   *  polymorphism until the first true value is returned (therefore the click was handled)]
   * [Input: Gets called to handle all the clicks within the GUIgroup]
   * [Output: Returns a boolean stating whether a click has been actioned or not]
   *
   * @param [firstParam: x center of the element being passed]
   * @param [secondParam: y center of the element being passed]
   * 
   * @return [boolean to determine whether the specific method worked on the click]
   */
  
  public boolean handleCharTyped(char c){
    boolean result = false;
    for (int i = 0; i < elements.size() && !result; i++){
      result = elements.get(i).handleCharTyped(c);
    }//for
    return result;
  }//handleChar
  
  /* 
   * [The handleCharTyped method works by looping through the items in the list, calling the appropriate method using
   *  polymorphism until the first true value is returned (therefore the click was handled)]
   * [Input: Gets called to deal with the characters typed (only for the textbox)]
   * [Output: Returns a boolean stating whether a character has been typed/actioned or not]
   *
   * @param [firstParam: character being passed by another method (i.e. keyboard)]
   * 
   * @return [boolean to determine whether the specific method worked on the character]
   */
  
  public void resetRadioButtons(){
    for (int i = 0; i < elements.size(); i++){
      if(elements.get(i) instanceof RadioButton) { //Check for RadioButtons
        RadioButton temp = (RadioButton)elements.get(i); //Cast
        temp.reset(); //Reset button
      }//if
    }//for
  }//resetRadioButtons
  
  /* 
   * [The resetRadioButtons method works by looping through the items in the list, calling the reset method from
   *  the RadioButton method (only works on Radio Button objects) and resets all the buttons in the group]
   * [Input: Gets called by the RadioButton method when a selection of a radio button is made as only
   *  one button can be selected at a time within a specific group]
   * [Output: Resets the radio buttons within the group that is passed to it]
   *
   * @param [N/A]
   * 
   * @return [void]
   */
    
}//GUIgroup
