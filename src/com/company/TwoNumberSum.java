package com.company;

public class TwoNumberSum {
  //solution1, O(N^2) T and O(1) S
  public static int[] twoNumberSum1(int[] array, int targetSum) {
    int[] solution = new int[2];
    for (int i=0; i<array.length; i++){
      for (int j=i+1; j<array.length; j++)
        if (array[i] + array[j] == targetSum){
          solution[0] = array[i];
          solution[1] = array[j];
          return solution;
        }

    }
    return new int[0];
  }

  //solution2


  public static void main(String[] args) {
    int[] myArray = new int[8];
    myArray[0] = 3;
    myArray[1] = 5;
    myArray[2] = -4;
    myArray[3] = 8;
    myArray[4] = 11;
    myArray[5] = 1;
    myArray[6] = -1;
    myArray[7] = 6;


    if (twoNumberSum1(myArray, 10).length != 0) {
      int[] solution = new int[2];
      solution[0] = twoNumberSum1(myArray, 10)[0];
      solution[1] = twoNumberSum1(myArray, 10)[1];
      System.out.println("Solution is: [" + solution[0] + ", " + solution[1] + "]");
    } else {
      System.out.println("There are no 2 integers to sum up to the target.");
    }


  }
}
