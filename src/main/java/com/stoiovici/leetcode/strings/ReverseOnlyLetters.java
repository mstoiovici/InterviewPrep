package main.java.com.stoiovici.leetcode.strings;

public class ReverseOnlyLetters {
  public static String reverseOnlyLetters(String s) {
    char[] characters = s.toCharArray();
    int i=0;
    int j = s.length()-1;
    while (i<j){
      while(i< j && !Character.isLetter(s.charAt(i))){
        i++;
      }
      while(j> i && !Character.isLetter(s.charAt(j))){
        j--;
      }
      char temp = characters[i];
      characters[i++] = characters[j];
      characters[j--] = temp;
    }
    return new String(characters);
  }
  public static void main (String [] args){
    String s = "ab-cd";
    System.out.println(reverseOnlyLetters(s));
    String s1 = "a-bC-dEf-ghIj";
    System.out.println(reverseOnlyLetters(s1));
    String s2 = "Test1ng-Leet=code-Q!";
    System.out.println(reverseOnlyLetters(s2));
  }
}
