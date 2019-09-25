// Lab 2

public class Game {
  
  // Instance Variables
  private HockeyTeam homeTeam;
  private HockeyTeam awayTeam;
  private int homeScore;
  private int awayScore;
  
  // Constructor
  public Game(HockeyTeam homeTeam, HockeyTeam awayTeam)
  {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    
    homeScore = 0;
    awayScore = 0;
  }  
  
  // Instance Methods
  public String toString()
  {
    String gameInfo;
    
    gameInfo = awayTeam.getName() + "(" + awayScore + ") at " + homeTeam.getName() + "(" + homeScore + ")";
  
    return gameInfo;
  }
  
  public void goal(HockeyTeam team)
  {
    if (team.equals(homeTeam))
      homeScore++;
    else if (team.equals(awayTeam))
      awayScore++;
    else
      System.out.println("That team isnt playing in this game!"); 
  }
  
}