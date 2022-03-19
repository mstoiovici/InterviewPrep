package main.java.com.stoiovici.educative.arrays;

public class FindMinimumValueInArray {
  public static int findMinimum(int[] arr) {
    // Write your code here
    int minimum= arr[0];
    for (int i = 1; i < arr.length; i++) {

      if (arr[i] < minimum) {
        minimum = arr[i];
      }
    }
    return minimum;
  }
  public static void main (String[] args){
    int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
    int[] arrr = {9, 2, 3, 6};
    int sol = findMinimum(arr);
    System.out.println(sol);
    int soll = findMinimum(arrr);
    System.out.println(soll);
  }
}
