package main.java.com.stoiovici.crackingCodingInterview;

public class OneAway {
  static boolean oneEditAway(String first, String second) {
    if (first.length() == second.length()) {
      System.out.println("we run oneEditReplace");
      return oneEditReplace(first, second);
    } else if (first.length() + 1 == second.length()) {
      System.out.println("first is shorter so we run oneEditInsert");
      return oneEditInsert(first, second);
    } else if(first.length() -1 == second.length()) {
      System.out.println("first is longer so we run oneEditInsert");
      return oneEditInsert(second, first);
    }
    return false;
  }

  static boolean oneEditReplace(String first, String second) {
    boolean foundDifference = false;
    for (int i =0; i< first.length(); i++) {
      if(first.charAt(i) != second.charAt(i)) {
        if(foundDifference){
          return false;
        }
        foundDifference = true;
      }
    }
    return foundDifference;
  }

  static boolean oneEditInsert(String s1, String s2) {
    int index1 =0;
    int index2 =0;
    while(index2 < s2.length() && index1<s1.length()){
      if(s1.charAt(index1) != s2.charAt(index2)){
        if(index1 != index2){
          return false;
        }
        index2++;
      }else {
        index1++;
        index2++;
      }
    }
    return true;
  }

  public static void main (String [] args) {
    System.out.println("hello");
    String first = "pale";
    String second = "balc";

    boolean result = oneEditAway(first, second);
    if(result){
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    // String first = "applc";
    // String second = "aple";
    //
    // boolean result = oneEditAway(first, second);
    // if(result){
    //   System.out.println("true");
    // } else {
    //   System.out.println("false");
    // }


  }
}
