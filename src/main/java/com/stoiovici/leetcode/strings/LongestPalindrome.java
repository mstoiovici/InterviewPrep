package main.java.com.stoiovici.leetcode.strings;

public class LongestPalindrome {
  public static int getLongestPalindrome(String s) {
    int max = 0;
    for (int i = 0; i <= s.length() - 2; i++) {
      for (int j = i + 1; j < s.length(); j++) {
        String sub = s.substring(i, j + 1);
        if (isPalindrome(sub)){
          max = Math.max(max, sub.length());
        }
      }
    }
    return max;
  }

  public static String getLongestPalindrome1(String s) {

    String sub = new String();
    for (int i = 0; i <= s.length() - 2; i++) {
      for (int j = i + 1; j < s.length(); j++) {

        String temp = s.substring(i, j + 1);
        //System.out.println(temp + " is palindrome is " +isPalindrome(temp));
        if (isPalindrome(temp) && temp.length() > sub.length()){
          System.out.println(isPalindrome(temp));
          sub = temp;
        }
      }
    }
    return sub;
  }

  public static boolean isPalindrome(String sub){
    char [] arr = sub.toCharArray();
    for (int i=0; i<=arr.length-2; i++){
      for (int j = arr.length-1; j >= 0; j--) {
        if( arr[i] != arr[j]) {
          return false;
        }
        i++;
      }
    }
    return true;
  }

  public static void main (String [] args){
    System.out.println("Hello");
    System.out.println(getLongestPalindrome1("babad"));
  }

}
