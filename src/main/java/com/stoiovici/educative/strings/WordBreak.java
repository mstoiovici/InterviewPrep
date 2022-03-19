package main.java.com.stoiovici.educative.strings;

import java.util.ArrayList;

public class WordBreak {
  public static ArrayList<String> wordBreak(ArrayList<String> list, String str) {
    ArrayList<String> result = new ArrayList<>();
    // will use two pointers, start and end, and read the str from start to end and check whether that substring is in list
    int start = 0;
    int end = 1;
    while(start<=str.length()-1 && end<=str.length()) {
      String current = str.substring(start, end);
      if(list.contains(current)) {
        result.add(current);
        // list.remove(str.substring(start, end));
        start = end;
        end++;
      } else {
        end++;
      }
    }
    return result;
  }

  public static boolean canSegmentString(ArrayList<String> list, String str) {
    int start = 0;
    int end = 1;
    // int length = str.length();
    while(str.length() != 0) {
      String current = str.substring(start, end);
      if(list.contains(current)) {
        int length = str.length();
        str = str.substring(end, length);
        start = 0;
        end = 1;
      } else {
        end++;
      }
      if(str.length() == 0) {
        return true;
      }
    }
    return false;
  }
  public static void main (String[] args) {
    // ArrayList<String> list = new ArrayList<>();
    // list.add("apple");
    // list.add("pear");
    // list.add("pier");
    // list.add("pie");
    // // list.add("app");
    // for (int i=0; i<= list.size()-1; i++) {
    //   System.out.println(list.get(i));
    // }
    // ArrayList<String> result = wordBreak(list, "applepie");
    // for (int i=0; i<= result.size()-1; i++) {
    //   System.out.println(result.get(i));
    // }


    ArrayList<String> list = new ArrayList<>();
    list.add("apple");
    list.add("pear");
    list.add("pier");
    list.add("pie");
    for (int i=0; i<= list.size()-1; i++) {
      System.out.println(list.get(i));
    }
    boolean result = canSegmentString(list, "applepie");
    if (result) {
      System.out.println("String Can be Segmented");
    } else {
      System.out.println("String Can NOT be Segmented");
    }
  }
}
