package main.java.com.stoiovici.algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsSolution {
  public static List<List<Integer>> getPerms(List<Integer> array){
    List<List<Integer>> perms = new ArrayList<>();
    getPermsHelper(array, new ArrayList<Integer>(), perms);
    return perms;
  }

  public static void getPermsHelper(List<Integer> array, List<Integer> currentPerm, List<List<Integer>> perms){
    if(array.size() ==0 ){
      perms.add(currentPerm);
    } else {
      for(Integer number : array){
        List<Integer> newArray = new ArrayList<>(array);
        newArray.remove(number);
        List<Integer> newCurrentPerm = new ArrayList<>(currentPerm);
        newCurrentPerm.add(number);
        getPermsHelper(newArray, newCurrentPerm, perms);
      }
    }

  }


  public static void main (String[] args){
    System.out.println("hello");
    List<Integer> arr = new ArrayList<>();
    arr.add(Integer.valueOf(1));
    arr.add(Integer.valueOf(2));
    arr.add(Integer.valueOf(3));
    arr.add(Integer.valueOf(4));
    // for (Integer no : arr){
    //   System.out.print("no is: " + no.toString());
    //   List<Integer> tempArray = new ArrayList<Integer>(arr);
    //   for (Integer number : tempArray){
    //     System.out.println(number);
    //   }
    // }

    List<List<Integer>> perms = getPerms(arr);
    int counter = 1;
    for(List<Integer> perm : perms){
      System.out.println("counter is " + counter + ":  ");
      for (Integer no : perm){
        System.out.print(no);
      }
      System.out.println();
      counter++;
    }
  }
}
