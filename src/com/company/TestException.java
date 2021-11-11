package com.company;

public class TestException {

  public static boolean testException() {
    try {
      throw new Exception("eroare");
    } catch (Exception e) {
      e.printStackTrace();
      // return true;
    }
    System.out.println("you got here");
    return false;

  }

  public static void main(String[] args) {
    boolean value = testException();
    if (value) {
      System.out.println("true");
    } else {
      System.out.println("value is false");
    }
  }
}
