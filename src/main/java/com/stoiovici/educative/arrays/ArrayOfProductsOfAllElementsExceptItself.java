package main.java.com.stoiovici.educative.arrays;

public class ArrayOfProductsOfAllElementsExceptItself {
  public static int[] findProduct(int arr[]) {
    int [] result = new int[arr.length];
    for (int i=0; i<=arr.length-1; i++){
      int newValue = 1;
      for (int j=0; j<=arr.length-1; j++){
        if(j!=i){
          newValue*=arr[j];
        }
      }
      result[i] = newValue;
    }
    return result;
  }

  public static void main(String[] args){
    int[] arr = {1,2,3,4};
   int[] solution = {24,12,8,6};
   int[] result = findProduct(arr);
   for (int i=0; i<=result.length-1; i++){
     System.out.println(result[i]);
   }
  }

}
