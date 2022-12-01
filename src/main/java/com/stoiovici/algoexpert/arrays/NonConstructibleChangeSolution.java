package main.java.com.stoiovici.algoexpert.arrays;

import java.util.Arrays;

public class NonConstructibleChangeSolution {
    public static int nonConstructibleChange(int[] coins){
        Arrays.sort(coins);
        int change =0;
        for(int coin : coins){
            if(coin > change +1){
                return change +1;
            } else {
                change = change + coin;
            }
        }
        return change +1;
    }

    public static void main(String[] args) {
//        int[] coins ={5,7,1,1,2,3,22}; //20
//        int[] coins ={1, 1, 1, 1, 1}; //6
//        int[] coins ={1, 5, 1, 1, 1, 10, 15, 20, 100}; //55
//        int[] coins ={6, 4, 5, 1, 1, 8, 9};//3
//        int[] coins ={}; //1
//        int[] coins ={87}; //1
        int[] coins ={1,1}; //3
        System.out.println(nonConstructibleChange(coins));
    }
}
