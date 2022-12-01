package main.java.com.stoiovici.algoexpert.arrays;

public class ValidateSubsequenceSolution {
    public static boolean validateSubsequence(int [] array, int [] sequence){
        int arrPointer = 0;
        int sequencePointer = 0;
        while (arrPointer <= array.length -1 && sequencePointer <= sequence.length - 1) {
            if (sequence[sequencePointer] != array[arrPointer]) {
                if (arrPointer == array.length -1){
                    return false;
                }
                arrPointer++;
            } else if (sequence[sequencePointer] == array[arrPointer]) {
                arrPointer++;
                sequencePointer++;
            }

        }
        if(sequencePointer == sequence.length){
            return true;
        }
        return false;
    }
    public static boolean validateSubsequence1(int [] array, int [] sequence){
        int arrPointer = 0;
        int sequencePointer = 0;
        while (arrPointer <= array.length -1 && sequencePointer <= sequence.length - 1) {
           if (sequence[sequencePointer] == array[arrPointer]) {
                sequencePointer++;
            }
            arrPointer++;
        }
        if(sequencePointer == sequence.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,22,25,6,-1,8,10};
        int[] sequence = {5,1,22,25,6,-1,8,10,5};
//        int[] arr = {5,1,22,25,6,-1,8,10};
//        int[] sequence = {16,6,-1,10};
        if(validateSubsequence(arr, sequence)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

