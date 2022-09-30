package main.java.com.stoiovici.interviewCake;

public class MergeSortedArrays {
  public static int[] mergeArrays(int[] myArray, int[] herArray){
    int[] mergedArray = new int[myArray.length + herArray.length];
    

    int herCurrentIndex = 0;
    int myCurrentIndex   = 0;
    int mergedCurrentIndex = 0;

    while (mergedCurrentIndex < mergedArray.length) {

      // case: my array is exhausted
      if (myCurrentIndex >= myArray.length) {
        mergedArray[mergedCurrentIndex] = herArray[herCurrentIndex];
        herCurrentIndex++;

        // case: Alice's array is exhausted
      }  else if((herCurrentIndex >= herArray.length) ||(myArray[myCurrentIndex] < herArray[herCurrentIndex])){
        mergedArray[mergedCurrentIndex] = myArray[myCurrentIndex];
        myCurrentIndex++;

      }
      // case: Alice's item is next
      else {
        mergedArray[mergedCurrentIndex] = herArray[herCurrentIndex];
        herCurrentIndex++;
      }

      mergedCurrentIndex++;
    }

    return mergedArray;
  }



  public static void main(String []args){
    System.out.println("hello");
    int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
    int[] herArray = new int[]{1, 5, 8, 12, 14, 19};
    int[] mergedArray = MergeSortedArrays.mergeArrays(myArray, herArray);
    for (int i=0; i< mergedArray.length; i++){
      System.out.print(mergedArray[i]);
      System.out.print(',');
    }


}
}
