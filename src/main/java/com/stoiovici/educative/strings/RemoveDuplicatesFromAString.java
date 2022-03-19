package main.java.com.stoiovici.educative.strings;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicatesFromAString {
  public static String removeDuplicateCharsInString(String str){

    HashMap<Character, Boolean> map = new HashMap<>();
    for (int i=0; i<str.length(); i++){
      if(!map.containsKey(str.charAt(i))){
        map.put(str.charAt(i), true);
      }
    }
    StringBuilder solution=new StringBuilder();
    if (!map.isEmpty()){
      for (Character key : map.keySet()){
        solution.append(key);
      }
    }
    // String s;
    // s = solution.toString();
    // char[] end = new char[s.length()];
    // for (int i=0; i<end.length; i++){
    //   end[i] = s.charAt(i);
    //   System.out.println(end[i]);
    // }
    char[] end = solution.toString().toCharArray();
    for (int i=0; i<end.length; i++){
        System.out.println(end[i]);
      }
  return solution.toString();

  }
  public static void main (String[] args){
    String str ="abbddacdabbdcacbd";
    String solution = removeDuplicateCharsInString(str);
    System.out.println(solution);
  }
}
