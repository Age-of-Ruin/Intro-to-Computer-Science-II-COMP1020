/**
 * This program will test the Silver exercise
 * (the GameV2 class) for Lab 2 of COMP 1020.
 */
public class TestLab2Silver {
  
  public static void main(String[] args) {
    
    //Create a league of 4 HockeyTeam objects
    TeamList league = new TeamList();
    league.addTeam(new HockeyTeam("Winnipeg",22,14,8));
    league.addTeam(new HockeyTeam("Chicago",28,13,2));
    league.addTeam(new HockeyTeam("Colorado",18,17,8));
    league.addTeam(new HockeyTeam("St. Louis",27,13,3));
    
    //Sort the teams and print the standings
    league.sortTeams();
    System.out.println("Standings:\n"+league);
    
    //Create 2 Game objects
    System.out.println("Creating Chicago at Winnipeg game.");
    GameV2 game1 = new GameV2(league.findTeam("Winnipeg"),league.findTeam("Chicago"));
    System.out.println("Creating Colorado at St. Louis game.");
    GameV2 game2 = new GameV2(league.findTeam("Colorado"),league.findTeam("St. Louis"));
    System.out.println();
    
    //Score some goals - Don't print output until the end
    game1.goal(league.findTeam("Chicago"));
    game1.goal(league.findTeam("Winnipeg"));
    game2.goal(league.findTeam("St. Louis"));
    game2.goal(league.findTeam("Colorado"));
    game1.goal(league.findTeam("Winnipeg"));
    System.out.println("After goals are scored:\n"+game1+"\n"+game2+"\n");
    
    //End one game, put the other into overtime.
    System.out.println("Winnipeg-Chicago game ends");
    game1.ended();
    System.out.println(game1);
    
    System.out.println("St. Louis-Colorado game goes into overtime");
    game2.overtime();
    System.out.println(game2);
    
    //Then score a goal to end the other game
    System.out.println("St. Louis scores");
    game2.goal(league.findTeam("St. Louis"));
    System.out.println(game2);

    //Sort the teams and print the standings again
    league.sortTeams();
    System.out.println("\nStandings:\n"+league+"\n");

  }//main
  
}//TestLab2Silver