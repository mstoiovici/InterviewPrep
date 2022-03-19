package main.java.com.stoiovici.educative.hashtable;

import java.util.Hashtable;

public class ArraySubsetOfAnotherArray {
  public static boolean isArraySubsetOfOtherArray(int[] arr1, int[] arr2){
    Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
    for (int i=0; i <= arr2.length-1; i++){
      if(!hashtable.containsKey(arr2[i])){
        hashtable.put(arr2[i], true);
      }
    }
    for (int i=0; i <= arr1.length-1; i++){
      if(!hashtable.containsKey(arr1[i])){
        return false;
      }
    }
    return true;
  }
  public static void main (String[] args){
    int[] arr2 = new int[7];
    arr2[0] = 9;
    arr2[1] = 4;
    arr2[2] = 7;
    arr2[3] = 1;
    arr2[4] = -2;
    arr2[5] = 6;
    arr2[6] = 5;
    int[] arr1 = new int[3];
    arr1[0] = 7;
    arr1[1] = 1;
    arr1[2] = -2;

    if (isArraySubsetOfOtherArray(arr1, arr2)){
      System.out.print("Arr1 is subset of arr2");
    } else {
      System.out.print("Arr1 is not a subset of arr2");
    }

  }
}
