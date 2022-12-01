package main.java.com.stoiovici.algoexpert.arrays;

import java.util.Arrays;

public class SortedSquaredArraySolution {
  //This solution is too basic and uses built in method to sort the elements at the end
  public static int[] sortedSquaredArray(int[] array) {
    // Write your code here.
    int[] squares = new int[array.length];

    for(int i=0; i<squares.length; i++){
      squares[i] = array[i] * array[i];
    }
    Arrays.sort(squares);
    return squares;
  }
  //remember that you can use 2 pointers and choose which element should go next
  // you take either an element from the negative ones or one from the positives (so, one pointers starts at 0, one at last element
  // if |-5| squared is bigger than|7|squared you cute it and add to the end of your solution array and move its
  //pointer, if the other one is you compute that one and move its pointer and so one
  public static int[] sortedSquaredArray1(int[] array){
    int[] squares = new int[array.length];
    int idx = squares.length - 1;
    int leftIdx = 0;
    int rightIdx = array.length - 1;
    while (idx >= 0){
      int left = Math.abs(array[leftIdx]);
      int right = Math.abs(array[rightIdx]);
      if(left > right){
        squares[idx] = left * left;
        leftIdx++;
      } else {
        squares[idx] = right * right;
        rightIdx--;
      }
      idx --;
    }
    return squares;
  }

    public static void main(String [] args){
      int [] arr= {1,2,3,4};
      int [] array= {-5, -4,1,2,3,7};
      int[] sol = sortedSquaredArray(array);
      for(int elem : sol){
        System.out.print(elem);
      }
    }

}
