package main.java.com.stoiovici.algoexpert.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinnerSolution {
  public static String getTournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results){
    HashMap<String, Integer> map = new HashMap<>();
    for(ArrayList list : competitions){
      if(!map.containsKey(list.get(0))){
        String competitor = (String)list.get(0);
        map.put(competitor, 0);
      }
      if(!map.containsKey(list.get(1))){
        String competitor = (String)list.get(1);
        map.put(competitor, 0);
      }
    }
    for (int i=0; i<competitions.size(); i++){
      if(results.get(i) ==0){
        int temp = map.get(competitions.get(i).get(1));
        map.put(competitions.get(i).get(1), temp+3);
      }
      else{
        int temp = map.get(competitions.get(i).get(0));
        map.put(competitions.get(i).get(0), temp+3);
      }
    }

    Integer mostPoints = 0;
    String thisIt = "";
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      if(entry.getValue() > mostPoints){
        mostPoints = entry.getValue();
        thisIt = entry.getKey();
      }
    }
    return thisIt;
  }

  public String tournamentWinner1(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

    HashMap<String, Integer> scores = new HashMap<>();
    String  bestTeam="";
    scores.put(bestTeam, 0);

    for (int i=0; i<competitions.size(); i++){
      ArrayList<String> competition = competitions.get(i);
      int result = results.get(i);

      String homeTeam = competition.get(0);
      String awayTeam = competition.get(1);

      String winner = (result == 1)? homeTeam : awayTeam;

      //update the points for this winner in the map
      if(!scores.containsKey(winner)){
        scores.put(winner, 0);
      }
      scores.put(winner, scores.get(winner) + 3);
//check if the winner you've updated has more points than the bestTeam
      //and update bestTeam
      if(scores.get(winner) > scores.get(bestTeam)){
        bestTeam = winner;
      }


    }
    return bestTeam;
  }

  public static void main(String[] args){
    // ArrayList<ArrayList<String>> competitions = new ArrayList<>();;
    // ArrayList<String> comp1= new ArrayList<>();
    // comp1.add("HTML");
    // comp1.add("C++");
    // ArrayList<String> comp2= new ArrayList<>();
    // comp2.add("C++");
    // comp2.add("Python");
    // ArrayList<String> comp3= new ArrayList<>();
    // comp3.add("Python");
    // comp3.add("HTML");
    // competitions.add(comp1);
    // competitions.add(comp2);
    // competitions.add(comp3);
    // System.out.println(competitions.size());
    // for(ArrayList<String> competition : competitions){
    //   System.out.println();
    //   System.out.print(competition.get(0));
    //   System.out.print(",");
    //   System.out.print(competition.get(1));
    // }
    // ArrayList<Integer> results = new ArrayList<>();
    // results.add(0);
    // results.add(0);
    // results.add(1);
    //
    //
    //
    // String winner = getTournamentWinner(competitions, results);
    // System.out.println(winner);

    ArrayList<ArrayList<String>> competitions1 = new ArrayList<>();;
    ArrayList<String> comp11= new ArrayList<>();
    comp11.add("HTML");
    comp11.add("C++");
    competitions1.add(comp11);
    for(ArrayList<String> competition : competitions1){
        System.out.println();
        System.out.print(competition.get(0));
        System.out.print(",");
        System.out.print(competition.get(1));
      }
    ArrayList<Integer> results1 = new ArrayList<>();
    results1.add(0);
    String winner1 = getTournamentWinner(competitions1, results1);
    System.out.println(winner1);

  }
}
