import java.util.*;
public class RPS{


private int num;
private String name;
private ArrayList<String> turnsOfPlayer;
private ArrayList<String> turnsOfComputer;
private TreeMap<Integer,String> turnToWin;

  public RPS(int a, String b ){
    num = a;
    name = b;
    turnsOfPlayer = new ArrayList<String>();
     turnsOfComputer = new ArrayList<String>();
     turnToWin = new TreeMap<Integer,String>();
  }

  public String play(){

     int a = (int)(Math.random()*3+1);
    switch(a){
        case(1): return "Rock";
        case(2): return "Scissors";
      default: return "Paper";
    }
  }

  public String winner(String a , String b){
    if(a.equals(b))return "Tie";
    int c = a.compareTo(b);
    switch(c){
        case(1): return "Computer";
        case(-1): return name;
         case(2): return "Computer";
        case(-2): return name;
        case(3): return name;
      default: return "Computer";
        
    }
  }

  public void add(String a , String b){
    turnsOfPlayer.add(a);
    turnsOfComputer.add(b);
    turnToWin.put(turnsOfPlayer.size(),winner(a,b));
    
  }
  public String score(){
     
    int c = 0;
    int p = 0;
    for(Integer i : turnToWin.keySet()){
      if(turnToWin.get(i).equals(name))p++;
      else if(!turnToWin.get(i).equals("Tie"))c++;
    
    }
      return "The Score is "+p+"-"+c+" ("+name+" - Computer"+")";
  }
  public String finalWin(){
    int c = 0;
    int p = 0;
    for(Integer i : turnToWin.keySet()){
      if(turnToWin.get(i).equals(name))p++;
      else if(!turnToWin.get(i).equals("Tie"))c++;
    
    }
    if(c>p)return "Computer";
    else if(c==p) return "Draw";
    else return name;

    
    
  }
  public void print(int a){

    System.out.println("Results for Round "+a+" :: "+name+" chose -> " + turnsOfPlayer.get(a-1));
     System.out.println("Results for Round "+a+" :: Computer chose -> " + turnsOfComputer.get(a-1));
    System.out.println("Results for Round "+a+" :: The winner was " + turnToWin.get(a));
    
    
  }
  
  
  


  
  
}