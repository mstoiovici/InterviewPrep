package theory.dataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// we are using HashMaps and Sets
//prefer HashMaps for concurrency as it will be faster than HashTables
public class InMemoryStore {
  // Store integer:colors to a map
  // Parse string to integers
  // Loop ints and store them
  private HashMap<Integer, Set<String>> map = new HashMap<>();
  private HashMap<String, Integer> priorities = new HashMap<>();
  private String [] arrayPriorities = new String[] {"YELLOW","RED","GREEN","BLUE","GREY"};
  InMemoryStore(){
    this.priorities.put("YELLOW", 1);
    this.priorities.put("RED", 2);
    this.priorities.put("GREEN", 3);
    this.priorities.put("BLUE", 4);
    this.priorities.put("GREY", 5);
  }
  //tip: don't use static identifier as unit tests will get more complicated
  public void store(String range, String colour){
    Integer start = Integer.valueOf(range.substring(0,2));
    Integer end = Integer.valueOf(range.substring(3));
    for (int i= start; i<=end; i++){
      Set<String> colours = map.getOrDefault(i, new HashSet<String>());
      colours.add(colour);
    }
  } // tip: ask whether the input strings for the ranges are always validated or do we need to this ourselves?

  public String get(String num) {
    Integer number = Integer.valueOf(num);
    if(map.get(number) != null){
      Set<String> colourValues = map.get(number); // {yellow, Red}
      for(int i=0; i <arrayPriorities.length; i++) {
        if(colourValues.contains(arrayPriorities[i])){
          return arrayPriorities[i];
        }
      }
      //instead of the above loop:
      // List<String> coloursAsList = new ArrayList<>(colourValues);
      // coloursAsList.sort(Comparator.comparing(colour -> priorities.get(colour)));
      // return coloursAsList.get(0);
    }
    return "GREY";
  }



  public static void main(String[] args) {

  }
}
  // Create an in-memory store which can store ranges of integers with an associated colour and return a color for a given integer.
  //
  //   store("00-06", BLUE)
  //   store("24-75", YELLOW)
  //   store("40-99", RED)
  //   get("03") => BLUE
  //   get("12") => GREY
  //   get("99") => RED
  //
  //   Possible integers range from 00 to 99 and are always two digits
  //   Ranges are inclusive
  //   There can be more than one range for a colour
  //
  //   Stored ranges can overlap
  //
  //   When a range of two or more colours overlaps the colour returned should be the colour of highest priority
  //
  //   store("34-78", RED)
  //   store("31-41", YELLOW)
  //   store("64-98", GREEN)
  //
  //   get("31") => YELLOW
  //   get("39") => YELLOW
  //   get("50") => RED
  //   get("68") => RED
  //   get("91") => GREEN
  //   get("99") => GREY
  //   store("90-99", BLUE)
  //   get("91") => GREEN
  //   get("99") => BLUE
  //
  //   Colours
  //   Colour Priority
  //   YELLOW 1 (highest) RED 2
  //   GREEN 3
  //   BLUE 4
  //   GREY 5 (lowest)


