package main.java.com.stoiovici.leetcode.strings;

public class MaximumNestingDepthOfTheParanthesis {
  public static int getDepth(String s) {
    int result = 0;
    int depth = 0;

    for (int i=0; i<s.length(); i++) {
      if(s.charAt(i) == ('(')) {
        depth ++;
        result = Math.max(result, depth);
      } else if(s.charAt(i) == (')')) {
        depth --;

      }
    }
    return result;
  }
  public static void main (String[] args) {
    String s = s = "(1+(2*3)+((8)/4))+1";
    int result = getDepth(s);
    System.out.println(result);
  }
}
