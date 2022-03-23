package main.java.com.stoiovici.util.practice;

public class StringPractice {
  public static void main(String[] args)  {
    System.out.println("hello");
    String a = "hello";
    String b = "helloo";


    String c = "hey";
    String d = "hey";
    if (a == b){
      System.out.println("they are ==");
    } else {
      System.out.println("they are not ==");
    }

    if(a.equals(b)){
      System.out.println("they are equals");
    } else {
      System.out.println("they are not equals ");
    }
    if (a == b.substring(0, b.length())){
      System.out.println("they are ==");
    } else {
      System.out.println("they are not ==");
    }

    if(a.equals(b.substring(0, b.length() - 1 ))){
      System.out.println("they are equals");
    } else {
      System.out.println("they are not equals ");
    }


    String word = "Mariana";
    int characterValue = word.charAt(0);
    Character character = word.charAt(0);
    System.out.println("First character in word is: " + character + " and its value is: " + characterValue);

    if (c.equals(d)) {
      System.out.println("c and d are the same");
    } else{
      System.out.println("c and d are not the same");
    }

    if (c.equals(d.substring(0, d.length()))) {
      System.out.println("c and substring of d are the same");
    } else{
      System.out.println("c and substring of d are not the same");
    }
    System.out.println(d.substring(0,d.length()));

  }

}
