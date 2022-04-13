package main.java.com.stoiovici.leetcode.strings;

//Give a binary string s, return the number of non-empty substrings that have the same number of
// 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
// Substrings that occur multiple times are counted the number of times they occur.

//Input: s = "00110011"
// Output: 6
// Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011",
// "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of times they occur.
// Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
public class CountBinarySubstrings {

  public static int countBinarySubstrings(String s) {
    int counter = 0;
    int result = 0;
    while (s.length() >= 2) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') {
          counter++;
        } else {
          counter--;
        }
        if (counter == 0) {
          result++;
        }
      }
      int length = s.length();
      s = s.substring(1, length);
      counter = 0;
    }

    return result;
  }

  public static int taketwo(String s) {
    int ans = 0, prev = 0, cur = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) != s.charAt(i)) {
        ans += Math.min(prev, cur);
        prev = cur;
        cur = 1;
      } else {
        cur++;
      }
    }
    return ans + Math.min(prev, cur);
  }



  public static void main(String[] args) {
    // String s = "00110011";
    // int count = countBinarySubstrings(s);
    // System.out.println(count);
    String s1 = "00110011";
    int count1 = taketwo(s1);
    System.out.println(count1);
  }
}
