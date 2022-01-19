package main.java.com.stoiovici.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

  public static List<List<String>> groupAnagrams(String[] strs) { // O n * (k logk) = O (n*k logK) where n  <=10^4
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) { // O(n) - no pf strings in strs
      String key = sortWord(strs[i]); // O(k logk) T and S O(k)  where k is no of character in word
      List<String> values = map.getOrDefault(key, new ArrayList<>()); // O(1)
      values.add(strs[i]); // worst case if needed resizing O(10^4 = n = no of max elements) but O(1)
      map.put(key, values); // O(1) TS but O(n) worst time
    }
    List<List<String>> myList = new ArrayList<>();

    for (List<String> value : map.values()){ // O (n) n = no of elements in strs/map
      myList.add(value); //O(1)
    }
    return myList;
  }

  public static String sortWord(String word ){ //O(k logk) T and S O(k)  where k is no of character in word
    char charArray[] = word.toCharArray(); // O(n) T S n= no of chars in word
    Arrays.sort(charArray); // O(n logn) T S?
    return new String(charArray); // worst case O(n) T S
  }

  public static void main(String[] args) {

    List<List<String>> myList = groupAnagrams(new String []{"eat","tea","tan","ate","nat","bat"});
    List<List<String>> myList1 = groupAnagrams(new String []{"e"});
    List<List<String>> myList2 = groupAnagrams(new String []{""});
    // for (element : myList)
    System.out.println(myList);
    System.out.println(myList1);
    System.out.println(myList2);
  }
}
