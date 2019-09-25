// Lab 2

public class HockeyTeam {
  
  // instance variables
  private String teamName;
  private int wins;
  private int losses;
  private int otLosses;
  
  //class variables
  private static final int maxCap = 64;
  private static int numTeams = 0;
  private static HockeyTeam[] teamList = new HockeyTeam[maxCap];
      
  // constructors
  public HockeyTeam(String teamName, int wins, int losses, int otLosses)
  { 
    // instance variables assert local variables    
    this.teamName = teamName;
    this.wins = wins;
    this.losses = losses;
    this.otLosses = otLosses;
    
    teamList[numTeams] = this;
    numTeams++;
  }
 
  // instance methods
  public void won()
  {
    wins++;
  }
    
  public void lost()
  {
    losses++;
  }
     
  public void lostOvertime()
  {
    otLosses++;
  }
  public int points()
  { 
    int points = (wins * 2 + otLosses);
    
    return points;
  }  
  
  public String toString()
  {  
    String teamStats = teamName + "(" + wins + "," + losses + "," + otLosses + "=" + this.points() + ")";
    
    return teamStats;
  }

  // class methods
    public static void listTeams()
  {
    for(int i = 0; i < numTeams; i++)
    {
      System.out.println(teamList[i].toString());
    } 
  }

}
  