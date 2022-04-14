package main.java.com.stoiovici.util.practice;

public class TestException {

  public static boolean throwException() {
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
    boolean value = throwException();
    if (value) {
      System.out.println("true");
    } else {
      System.out.println("value is false");
    }
  }
}
