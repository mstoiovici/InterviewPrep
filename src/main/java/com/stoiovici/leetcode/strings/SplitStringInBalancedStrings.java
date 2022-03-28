package main.java.com.stoiovici.leetcode.strings;

public class SplitStringInBalancedStrings {
  public static int getNumberOfbalancedStrings(String s){
    int result =0;
    int counter = 1;
    int currentIndex = 0;
    for (int i=0; i<s.length(); i++) {
      if ((i <s.length() -1) && (s.charAt(i + 1) == s.charAt(i))) {

        counter ++;

      } else {
        int temp = counter;
        counter --;
        if(temp-1 == 0) {
          result++;
          int length = s.length();
          s=s.substring(i+2, length);
      }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "rlrrllrlrl";
    int result = getNumberOfbalancedStrings(s);
    System.out.println(result);
  }
}
