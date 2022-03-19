package main.java.com.stoiovici.educative.hashtable;

import java.util.HashSet;

public class DisjointedArrays {
  public static boolean isDisjointed(int[] arr1, int[] arr2){
    HashSet<Integer> mySet = new HashSet<>();
    for (int i=0; i<= arr1.length-1; i++) {
        if (!mySet.contains(arr1[i])){ //check whether you already have that elements in the set
          mySet.add(arr1[i]);
        }
    }
    for (int i=0; i<= arr2.length-1; i++) {
      if(mySet.contains(arr2[i])){
        return false;
      }
    }
    return true;
  }
  public static void main (String[] args) {
    int[] arr1 = new int[7];
    arr1[0] = 9;
    arr1[1] = 4;
    arr1[2] = 3;
    arr1[3] = 1;
    arr1[4] = -2;
    arr1[5] = 6;
    arr1[6] = 5;
    int[] arr2 = new int[3];
    arr2[0] = 7;
    arr2[1] = 10;
    arr2[2] = 8;

    if (isDisjointed(arr1, arr2)) {
      System.out.println("yes, they don't have elements in common");
    }
    else {
      System.out.println("no, common elements found");
    }
  }

}
