package main.java.com.stoiovici.leetcode.strings;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

//Input: s = "anagram", t = "nagaram"
// Output: true

//Constraints:
//
// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

//Follow up: What if the inputs contain Unicode characters?
//How would you adapt your solution to such a case?
public class ValidAnagram {

  public static boolean isValidAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> firstDict = new HashMap<>();
    HashMap<Character, Integer> secondDict = new HashMap<>();
    for(int i=0; i<=s.length()-1; i++) {
      if(firstDict.containsKey(s.charAt(i))){
        firstDict.put(s.charAt(i), firstDict.get(s.charAt(i))+1);
      } else {firstDict.put(s.charAt(i), 1);}

    }
    System.out.println(firstDict);
    for(int j=0; j<=t.length()-1; j++) {
      if(secondDict.containsKey(t.charAt(j))){
        secondDict.put(t.charAt(j), secondDict.get(t.charAt(j))+1);
      } else {secondDict.put(t.charAt(j), 1);}
    }
    System.out.println(secondDict);
    return firstDict.entrySet().stream()
        .allMatch(e -> e.getValue().equals(secondDict.get(e.getKey())));


    // else {
    //   List<Character> chars = new ArrayList<>();
    //   for (char ch : t.toCharArray()) {
    //
    //     chars.add(ch);}
    //
    //   while (s.length() != 0){
    //     // for (int i=0; i<= s.length()-1; i++){
    //     //   for (int j=t.length()-1; j>=0; j--){
    //     //     if(s.charAt(i) != t.charAt(j)) {
    //     //       return false;
    //     //     }
    //     //   }
    //     // }
    //     for (int i=0; i<= s.length()-1; i++){
    //       for (int j=0; j<= s.length()-1; j++){
    //         if(s.charAt(i) == chars.get(j)) {
    //           chars.remove(j);
    //           i++;
    //         }
    //       }
    //
    //
    //     }
    //   }
    //   return true;
    // }

  }


  public static void main(String[] args) throws InterruptedException {
    System.out.println("hello");
    // System.out.println(isValidAnagram("anagram", "margana"));
    System.out.println(isValidAnagram("rat", "car"));
    // System.out.println(isValidAnagram("anagram", "nagaram"));
  }
}
