package main.java.com.stoiovici.educative.arrays;

import java.util.HashMap;

class CheckSum
{
  public static int[] findSum(int[] arr, int n)
  {
    int[] result = new int[2];
    HashMap<Integer, Boolean> myMap = new HashMap<>();
    for (int i=0; i<=arr.length-1; i++){
      if(!myMap.containsKey(n-arr[i])){
        myMap.put(arr[i], true);
      } else {
        result[0] = arr[i];
        result[1] = n-arr[i];
        return result;
      }

    }

    // write your code here
    return result;   // return the elements in the array whose sum is equal to the value passed as parameter
  }

  public static void main (String[] args){
    int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
    int n = 27;
    int[] result = findSum(arr,n);

    System.out.println(result[0]);
    System.out.println(result[1]);
  }
}
