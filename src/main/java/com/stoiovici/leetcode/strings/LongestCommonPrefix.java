package main.java.com.stoiovici.leetcode.strings;

import java.util.ArrayList;


public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
    String prefix = "";
    for (int i=0; i< strs[0].length(); i++ ) {
      prefix = strs[0].substring(0, i+1);
      for (int j=1; j< strs.length; j++ ) {
        if(!((strs[j].substring(0, i+1).equals(prefix)) && (prefix.length() <= strs[j].length()))) {
          prefix = "";
          return "There is none";
        }
      }
    }


    return prefix;
  }

  public static void main (String[] str) {
    ArrayList<String> strings = new ArrayList<>();
    strings.add("flower");

    String[] strs = new String[3];
    strs[0]="flower";
    strs[1]="flow";
    strs[2]="flight";
    String[] strs2 = new String[3];
    strs2[0] ="dog";
    strs2[1] = "racecar";
    strs2[2] = "car";
    String[] strs3 = {"dog","racecar","car"};
    // System.out.println(longestCommonPrefix(strs));
    System.out.println(longestCommonPrefix(strs2));
  }
}
