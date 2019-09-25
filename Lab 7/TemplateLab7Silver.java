import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Template
 * Lab 7 Silver Exercise
 * COMP 1020 Winter 2016
 * (C) Computer Science, University of Manitoba
 */
@SuppressWarnings("unchecked")
public class TemplateLab7Silver {
  
  public static final int DECK_SIZE = 20; //Keep it small for testing
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    //Create a brand new deck, still in sequence.
    ArrayList deck = makeDeck(DECK_SIZE);
    System.out.println("The new deck is "+deck);

    //Shuffle it and print it again
    shuffle(deck);
    System.out.println("The shuffled deck is "+deck);

    //Ask how many hands to deal, and of what size
    System.out.print("How many hands should be dealt? ");
    int numHands = keyboard.nextInt();
    System.out.print("How many cards in each hand? ");
    int numCards = keyboard.nextInt();
    
    //Deal the hands and print them.
    ArrayList[] theHands = deal(deck,numHands,numCards);
    System.out.println("The hands are:");
    for(int i=0; i<numHands; i++)
      System.out.println("Hand "+i+": "+theHands[i]);
    System.out.println("The remaining deck: "+deck);
    
  }//main
  
  public static ArrayList makeDeck(int numCards){
   
    ArrayList deck = new ArrayList();
    
    for(int i = 0; i < numCards; i++)
      deck.add((Integer) i);
    
    return deck;  
  }
  
  public static void shuffle(ArrayList deck){
  
    for(int i = 0; i<deck.size()-2 ; i++){
      int lo = i;
      int high = deck.size()-1;
      int randomNum = (int)(Math.random() * (high-lo) + lo);
      Integer randomCard = (Integer)deck.get(randomNum);
      
      deck.remove(randomNum);
      deck.add(i, randomCard);
    }
  
  }
  
  public static ArrayList[ ] deal(ArrayList deck, int numHands, int numCards){

    return null;  // dummy statement; replace
  }
  
}//TemplateLab7Silver