package main.java.com.stoiovici.algoexpert;


import java.util.Hashtable;

public class TwoNumberSum {
  //solution1, O(N^2) T and O(1) S
  public static int[] twoNumberSum1(int[] array, int targetSum) {
    int[] solution = new int[2];
    for (int i=0; i<=array.length-1; i++){
      for (int j=i+1; j<=array.length-1; j++)
        if (array[i] + array[j] == targetSum){
          solution[0] = array[i];
          solution[1] = array[j];
          return solution;
        }

    }
    return solution;
  }

  //solution2 O(N) Space and Time
  //more space, less time
  public static int[] twoNumberSum2(int[] array, int targetSum) {
    int[] solution = new int[2];//O(N) Space and Time
    Hashtable<Integer, Boolean> dict = new Hashtable<>(); //O(N) Space and Time
    Integer y = 0;
    for (int i=0; i<= array.length-1; i++) { // O(N) time
      y = targetSum - array[i]; // constant
      if (dict.getOrDefault(y, Boolean.TRUE)) {
        solution[0] = array[i];
        solution[1] = y;
      } else {
        dict.put(array[i], Boolean.TRUE);
      }
    }
    return solution;
  }

  //TODO: use left and right pointers in a sorted array of the numbers
  // by using quick sort you'll get O(NlogN) time
  public static int[] twoNumberSum3(int[] array, int targetSum) {
    int[] solution = new int[2];//O(N) Space and Time

    return solution;
  }


  public static void main(String[] args) {
    int[] myArray = new int[8];
    myArray[0] = 3;
    myArray[1] = 5;
    myArray[2] = -4;
    myArray[3] = 8;
    myArray[4] = 11;
    myArray[5] = 1;
    myArray[6] = 6;
    myArray[7] = -1;

    // I don't think I need to check this as the problem will definitely have a solution, so
    // the solution array will never be empty
    if (twoNumberSum2(myArray, 10).length != 0) {
      int [] solution = twoNumberSum1(myArray, 10);
      System.out.println("Solution is: [" + solution[0] + ", " + solution[1] + "]");
    } else {
      System.out.println("There are no 2 integers to sum up to the target.");
    }


  }
}
