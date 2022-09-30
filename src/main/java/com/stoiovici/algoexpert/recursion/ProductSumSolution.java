package main.java.com.stoiovici.algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class ProductSumSolution {
  public static int productSum(List<Object> array){
    return productSumHelper(array, 1);
  }

  public static int productSumHelper(List<Object> array, int multiplier){
    int sum = 0;
    for(Object object : array){
      if(object instanceof ArrayList){
        @SuppressWarnings("unchecked")
        ArrayList<Object> obj = (ArrayList<Object>) object;
        sum+= productSumHelper(obj, multiplier +1);
      } else {
        sum+=(int) object;
      }
    }
    return sum*multiplier;
  }

  public static void print(List<Object> array){
    System.out.print('[');
    for(Object object : array){
      if(object instanceof ArrayList){
        // @SuppressWarnings("unchecked")
        ArrayList<Object> obj = (ArrayList<Object>) object;
        print(obj);
      } else {
        System.out.print((int) object);
      }
      System.out.print(',');
    }
    System.out.print(']');
  }
  public static void main (String[] args ){
    System.out.println("hello");
    List<Object> array = new ArrayList<>();
    array.add(5);
    array.add(2);
    List<Object> arr1 = new ArrayList<>();
    arr1.add(7);
    arr1.add(-1);
    array.add(arr1);
    array.add(3);
    List<Object> arr2 = new ArrayList<>();

    arr2.add(6);
    List<Object> arr3 = new ArrayList<>();
    arr3.add(-13);
    arr3.add(8);
    arr2.add(arr3);
    arr2.add(4);
    array.add(arr2);


print(array);
    int val = productSum(array);
    System.out.println(val);

    Integer big = Integer.parseInt("1");
    int small = (int) big;
    int another = big;
    if(big instanceof Integer){
      System.out.println("big is Integer");
    }else {
      System.out.println("big is NOT Integer");
    }

    if(small == another){
      System.out.println("small and another are ints");
    }else {
      System.out.println("small and another are NOT ints");
    }
  }
}
