package main.java.com.stoiovici.util.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysPractice {

  public static void practiceDynamic(){
    List<Integer> dyno = new ArrayList<>();
    dyno.add(26);
    dyno.add(765);

    for(int i : dyno) {
      System.out.println(i);
    }

    dyno.add( 99);
    for(int i : dyno) {
      System.out.println(i);
    }

    dyno.add(2, 100);
    for(int i : dyno) {
      System.out.println(i);
    }
    // dyno.remove(122);
  }
  public static void main(String[] args) {
    int[] ints = new int[5];
    for(int i=0; i<ints.length; i++) {
      System.out.println(ints[i]);
    }
    ints[0]=0;
    ints[1]=1;
    ints[2]=2;
    ints[3]=3;
    ints[4]=4;
    for(int i=0; i<ints.length; i++) {
      System.out.println(ints[i]);
    }

    // int[] intss = Arrays.copyOfRange(ints, 0, 2);
    // for(int i=0; i<intss.length; i++) {
    //   System.out.println(intss[i]);
    // }
    System.out.println("here");
    // this will allocate a new array on lines 26 and 27 separately
    //and costing O(n) time and space on each line on top of the loop itself
    for(int i=0; i<Arrays.copyOfRange(ints, 0, 2).length; i++) {
      System.out.println(Arrays.copyOfRange(ints, 0, 2)[i]);
    }
    System.out.println("myArray");
    int[] myArray = new int[5];// already used O(n) space and time to allocate the space and fill it with default values
    for(int i=0; i<myArray.length; i++) {
      System.out.println(myArray[i]);
    }
    myArray[0]=0;
    myArray[1]=1;
    myArray[2]=2;
    for(int i=0; i<myArray.length; i++) {
      System.out.println(myArray[i]);
    }
    myArray[1]=3;
    for(int i=0; i<myArray.length; i++) {
      System.out.println(myArray[i]);
    }
    System.out.println("practiceDynamic()");
    practiceDynamic();
  }
}
