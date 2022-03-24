package main.java.com.stoiovici.leetcode.strings;

public class DefangingIPAddress {
  // Given a valid (IPv4) IP address, return a defanged version of that IP address.
  // A defanged IP address replaces every period "." with "[.]".

  //Input: address = "1.1.1.1"
  // Output: "1[.]1[.]1[.]1"
  public static String defangIPAdress(String s) {
    StringBuilder result = new StringBuilder();
    for (int i=0; i<s.length(); i++) {
      if(s.charAt(i) != '.') {
        result.append(s.charAt(i));
      } else {
        result.append('[').append('.').append(']');
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String s = "1.1.1.1";
    String result = defangIPAdress(s);
    if (result.equals("1[.]1[.]1[.]1") ) {
      System.out.println("getting expected output");
    } else {
      System.out.println("inexpected output");
    }
    System.out.println(result);


    String address = "255.100.50.0";
    String result1 = defangIPAdress(address);
      if (result1.equals("255[.]100[.]50[.]0") ) {
      System.out.println("getting expected output");
    } else {
      System.out.println("inexpected output");
    }
    System.out.println(result1);

  }
}


