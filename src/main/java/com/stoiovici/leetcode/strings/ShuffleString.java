package main.java.com.stoiovici.leetcode.strings;

public class ShuffleString {
  public static String getShuffledString(String s, int[] indices) {
    StringBuilder result = new StringBuilder();
    for (int i=0; i<s.length(); i++) {
      for (int j = 0; j < indices.length; j++) {
        if (indices[j] == i) {
          result.append(s.charAt(j));
        }
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String s = "codeleet";
    int[] indices ={4,5,6,7,0,2,1,3};
    String result = getShuffledString(s, indices);
    System.out.println(result);
    String s1 = "abc";

    int[] indices1 ={0,1,2};
    String result1 = getShuffledString(s1, indices1);
    System.out.println(result1);
  }
}
