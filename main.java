import java.util.*;
class Main {
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    while(true){
    System.out.println("Welcome To An Intense Game of RPS! \n");
    
    System.out.print("To Begin, Enter Your Name :: ");
    String name = input.nextLine();
    
    System.out.print("Just to confirm, your name is "+ "\""+name+"\"" +" (Enter Yes or No) :: ");
   
   String confirm = input.nextLine().toLowerCase();
     System.out.println();
    while(!confirm.equals("yes")&&!confirm.equals("no")){
      
      System.out.print("Please enter either Yes or No :: ");
      confirm = input.nextLine().toLowerCase();
      System.out.println();
    }
    if(confirm.equals("no")){
       System.out.print("To Begin, Enter Your Name :: ");
     name = input.nextLine();
      System.out.println();
    } 
    if(name.toLowerCase().equals("computer"))name = "User";
    System.out.println("Welcome " + name+"!");
    System.out.print("This Game of RPS will be Best Of (Enter an Integer):: ");
    
    int bo = 0;
  while(bo<1){
   try{
      bo = Integer.parseInt(input.nextLine());
     if(bo<1){
       System.out.print("You can't play negative or 0 rounds of RPS. Enter an Integer Greater Than 0 :: ");
       
     }
   } catch(Exception e ){
     System.out.print("Please Enter an Integer:: ");
    
   }
  }

    System.out.println("Great! This will be a RPS Best of " +bo+" game");
   

    RPS game = new RPS(bo,name);

    
    for(int i = 1;i<=bo;i++){
 System.out.println();
     System.out.println("Round "+i+" "+ name+" vs. Computer");
     System.out.print("Choose your play (Type Rock,Paper,or Scissors)::");
      String move = input.nextLine().toLowerCase();
      while(!move.equals("rock")&&!move.equals("scissors")&&!move.equals("paper")){
        System.out.print("Type Rock,Paper,or Scissors:: ");
        move = input.nextLine().toLowerCase();
      }
      move = move.substring(0,1).toUpperCase()+move.substring(1);
      String comp = game.play();
 
      System.out.println("Results :: "+name+" chose -> " + move);
      System.out.println("Results :: Computer chose -> " + comp);
      String win = game.winner(move,comp);
      if(win.equals("Tie")){
      System.out.println("Results :: It was a Tie");
      } else {
         System.out.println("Results :: The winner is "+ win);
      }
      game.add(move,comp);
      System.out.println(game.score());
  
    }
    String winner = game.finalWin();
    System.out.println();
    System.out.println("The game is over!");
    if(winner.equals("Draw"))System.out.println("This game ended in a draw!");
    else System.out.println("The winner was ... " + winner.toUpperCase());

    System.out.println();

  

     int round = -1;
  while(round!=0){
   try{
       System.out.print("To view Round Scores , Type the Number of the Round (Enter 0 to quit and restart) :: ");
      round = Integer.parseInt(input.nextLine());
     if(round>bo){
       System.out.println("Does not exist");
       
     } else if(round!=0){
       game.print(round);
       System.out.println();
     }
   } catch(Exception e ){
    
   }
  }
    
      } 
  
    
  }
}