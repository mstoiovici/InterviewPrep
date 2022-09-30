package main.java.com.stoiovici.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatingChars {

  //brute force
  //diff btw getLongestUniqueSubstring and same1 is the range of J, either < length or <= length
  public static int getLongestUniqueSubstring(String str){
    int counter = 0;
    for (int i=0; i < str.length(); i++){
      for(int j =i+1; j<= str.length(); j++ ){ //if you have aaa and j stops before length= 3, so at 2, the index of last char, you won't be able to do j-i
        if(areUnique(str, i, j)){
          counter = Math.max(counter, j-i);
        }
      }
    }
    return counter;
  }
  public static boolean areUnique(String s, int i, int j){
    // using utf8 - english letters, digits, symbols and spaces
    // true or false ^8 = 2^8 =256
    boolean[] visited = new boolean[256];
    //iterate through each char of the string from i(start) to j(end), j not included (like you'd look at str.substring(i,j) where j is not included
    for(int k = i; k<j; k++){
      //if we already visited this char then it means it's not unique so we return false
      if(visited[s.charAt(k)]){
        return false;
      }
      //next we make it true as in we've seen this char
      visited[s.charAt(k)] = true;
    }
    return true;
  }
  public static int getLongestUniqueSubstring1(String str){
    int counter = 0;
    for (int i=0; i < str.length(); i++){
      for(int j =i+1; j< str.length(); j++ ){ //if you have aaa and j stops before length= 3, so at 2, the index of last char, you won't be able to do j-i
        if(areUnique1(str, i, j)){
          counter = Math.max(counter, j-i +1);
        }
      }
    }
    return counter;
  }

  public static boolean areUnique1(String s, int i, int j){
    // using utf8 - english letters, digits, symbols and spaces
    // true or false ^8 = 2^8 =256
    boolean[] visited = new boolean[256];
    //iterate through each char of the string from i(start) to j(end), j not included (like you'd look at str.substring(i,j) where j is not included
    for(int k = i; k<=j; k++){
      //if we already visited this char then it means it's not unique so we return false
      if(visited[s.charAt(k)]){
        return false;
      }
      //next we make it true as in we've seen this char
      visited[s.charAt(k)] = true;
    }
    return true;
  }


  // // better complexity with sliding window
  public static int getUniqueSubstrings(String s){
    int[] chars = new int[128];

    int left = 0;
    int right = 0;

    int res = 0;
    while (right < s.length()) {
      char r = s.charAt(right);
      chars[r]++;

      while (chars[r] > 1) {
        char l = s.charAt(left);
        chars[l]--;
        left++;
      }
      res = Math.max(res, right - left + 1);
      right++;
    }
    return res;

  }


  //most efficient
  // we take the next sliding window if we've seen the current char already
  //hint: use hashTable (can't have null key or values) (with hashMap you need to check whether the key or value is null before checking whatever you need) or set
  public static  int getLengthOfLongestUniqueSubstring(String s) {
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < s.length(); j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }

  public static void main(String[] args){
    String s = "abcabcbb";
    // System.out.println(getLongestUniqueSubstring1(s));
    // System.out.println(getLongestUniqueSubstring(s));
    String a = "aaaaaab";
    // System.out.println(getLongestUniqueSubstring(a));
    String b = "abaa";
    System.out.println(getLongestUniqueSubstring1(b));
  }
}
