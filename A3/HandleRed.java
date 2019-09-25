/*
 * HandleRed
 * 
 * COMP 1020
 * Instructor: Fereshteh Amini
 * Assignment: 3, Question: 2
 * @author     Richard Constantine
 * @version    2016/03/18
 * 
 * Purpose: This class contains a doIt method which calls a the drawRed method from TestA3Q2 and acts to 
 * draw a red circle when this class/method is called.
 */
public class HandleRed extends Handler {
  
  public void doIt(){
    TestA3Q2.drawRed();
  }//doIt
  
  /* 
   * [The doIt method utilizes polymorphism to call the appropriate method (in this case drawRed) and draws 
   *  a red circle when called] 
   * [Input: Receives input from a method and acts to call the drawRed method]
   * [Output: Calls the method from TestA3Q2 and draws the appropriately colored circle]
   * 
   *
   * @param [N/A]
   * @return [void]
   */
  
}//HandleRed
