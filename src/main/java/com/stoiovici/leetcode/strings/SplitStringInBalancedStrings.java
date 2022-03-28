package main.java.com.stoiovici.leetcode.strings;

public class SplitStringInBalancedStrings {
  public static int getNumberOfBalancedStrings(String s){
    int result =0;
    int counter = 0;

    for (int i=0; i<s.length(); i++) {

      if (s.charAt(i) == 'R') {
        counter++;
      } else {
        counter--;

      }
      if(counter == 0){
        result++;
      }
    }
    return result;
  }

  public static int getNumberOfBalancedStrings1(String s){
    int result =0;
    int leftCounter = 0;
    int rightCounter = 0;
    for (int i=0; i<s.length(); i++) {

      if (s.charAt(i) == 'R') {
        rightCounter++;
      } else {
        leftCounter++;

      }
      if(rightCounter == leftCounter){
        result++;
      }
    }


    return result;
  }

  public static void main(String[] args) {
    String s = "RLRRLLRLRL";
    int result = getNumberOfBalancedStrings1(s);
    System.out.println(result);
  }
}
