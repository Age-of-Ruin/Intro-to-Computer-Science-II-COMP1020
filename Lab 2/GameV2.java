// Lab 2

public class GameV2 {
  
  // Instance Variables
  private HockeyTeam homeTeam;
  private HockeyTeam awayTeam;
  private int homeScore;
  private int awayScore;
  private boolean ended;
  private boolean overtime; 
  
  // Constructor
  public GameV2(HockeyTeam homeTeam, HockeyTeam awayTeam)
  {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    homeScore = 0;
    awayScore = 0;
    ended = false;
    overtime = false;
  }  
  
  // Instance Methods
  public String toString()
  {
    String gameInfo;
    
    gameInfo = awayTeam.getName() + "(" + awayScore + ") at " + homeTeam.getName() + "(" + homeScore + ")";
    
    if (ended)
      return gameInfo + " Final";
    else if (overtime)
      return gameInfo + " OT";
    else if (overtime && ended)
      return gameInfo + " OT" + " Final";
    else
      return gameInfo;    
  }
  
  public void goal(HockeyTeam team)
  {
    if (team.equals(homeTeam))
      homeScore++;
    else if (team.equals(awayTeam))
      awayScore++;
    else if (team.equals(homeTeam) && overtime)
    {
      homeScore++;
      this.ended();
    }
    else if (team.equals(awayTeam) && overtime)
    {
      awayScore++;
      this.ended();
    }
    else
      System.out.println("That team isnt playing in this game!"); 
  }
  
  public void overtime()
  {
    overtime = true;
  }
  
  public void ended()
  {
    ended = true;
    
    if (homeScore > awayScore)
    {
      homeTeam.won();
      awayTeam.lost();
    }
    else if (awayScore > homeScore)
    {      
      awayTeam.won();
      homeTeam.lost();
    }
    else if (overtime && homeScore > awayScore)
    {
      homeTeam.won();
      awayTeam.lostOvertime();    
    }
    else if(overtime && awayScore > homeScore)
    {
      awayTeam.won();
      homeTeam.lostOvertime();
    }
  }
  
  
}