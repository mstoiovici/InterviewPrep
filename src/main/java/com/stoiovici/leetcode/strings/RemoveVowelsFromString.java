package main.java.com.stoiovici.leetcode.strings;

import java.util.ArrayList;
import javax.sql.rowset.serial.SQLOutputImpl;

public class RemoveVowelsFromString {
  // Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
  // Input: s = "leetcodeisacommunityforcoders"
  // Output: "ltcdscmmntyfrcdrs"
  public static String removeVowels(String str) {
    StringBuilder result = new StringBuilder();
    ArrayList<Character> list = new ArrayList<>();
    list.add('a');
    list.add('e');
    list.add('i');
    list.add('o');
    list.add('u');
    for (int i=0; i<str.length(); i++) {
      char current = str.charAt(i);
        if(!list.contains(current)){
          result.append(current);
        }

    }
    return result.toString();
  }

  public static void main(String[] args) {
    String str = "leetcodeisacommunityforcoders";
    String result = removeVowels(str);
    if (result.equals("ltcdscmmntyfrcdrs") ) {
      System.out.println("getting expected output");
    } else {
      System.out.println("inexpected output");
    }
  }

}
