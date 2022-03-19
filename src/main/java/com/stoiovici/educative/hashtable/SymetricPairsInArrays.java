package main.java.com.stoiovici.educative.hashtable;

import java.util.HashMap;

public class SymetricPairsInArrays {
  public static String isSymetric(int[][] arr){
    HashMap< Integer,Integer > hashMap = new HashMap < Integer,Integer >();

    String result = "";

    //Traverse through the given array
    for (int i = 0; i < arr.length; i++) {
      int first = arr[i][0];
      int second = arr[i][1];

      Integer value = hashMap.get(second);

      if (value != null && value == first) {
        //Symmetric Pair found
        result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
      }
      else
        hashMap.put(first, second);
    }
    return result;
  }
  public static void main (String[] args) {
    int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
    String symmetric = isSymetric(arr);
    System.out.println(symmetric);
  }
}
