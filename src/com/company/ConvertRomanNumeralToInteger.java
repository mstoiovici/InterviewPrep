package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

public class ConvertRomanNumeralToInteger {
  public static int convertRomanNumeralToInteger(String roman){
    //numeralDict {I:1; V:5; X:10; L:50; C:100; D:500; M:1000}
    Hashtable<Character, Integer> dict = new Hashtable<>();
    dict.put('I', 1);
    dict.put('V', 5);
    dict.put('X', 10);
    dict.put('L', 50);
    dict.put('C', 100);
    dict.put('D', 500);
    dict.put('M', 1000);
    int numeral = 0;

    if (roman.length()==1){
      return dict.get(roman.charAt(0));
    }
    ArrayList<Character> myArray = new ArrayList<>();
    for (char c : roman.toCharArray()) {
      myArray.add(c);
    }
    // System.out.println(myArray);
    while (myArray.size()>=2) {
      // System.out.println("myArray: " + myArray + " and size: " + myArray.size() );
      if ((myArray.get(0) == 'I' && (myArray.get(1) == 'V' || myArray.get(1) == 'X')) ||
          (myArray.get(0) == 'X' && (myArray.get(1) == 'L' || myArray.get(1) == 'C')) ||
          (myArray.get(0) == 'C' && (myArray.get(1) == 'D' || myArray.get(1) == 'M'))) {
        numeral += (dict.get(myArray.get(1))- dict.get(myArray.get(0)));
        // System.out.println(numeral);
        myArray.remove(0);
        myArray.remove(0);
      }
      else{
        numeral+= dict.get(myArray.get(0));
        myArray.remove(0);

      }
    }
    if (myArray.size()==1){
      numeral+= dict.get(myArray.get(0));
    }
    return numeral;


  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Hello");
    // buildStrings();
    System.out.println(convertRomanNumeralToInteger("LVIII"));
    System.out.println(convertRomanNumeralToInteger("III"));
    System.out.println(convertRomanNumeralToInteger("IV"));
    System.out.println(convertRomanNumeralToInteger("MCMXCIV"));
    System.out.println(convertRomanNumeralToInteger("IX"));
    System.out.println(convertRomanNumeralToInteger("XIX"));

  }
}
