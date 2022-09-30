package main.java.com.stoiovici.lewis;

public class HopsToInteger1 {
  public static int getMinimumHops(int counter, int n){
   counter = 0;
    if(n==1){
      return counter+=0;
    }

    while(n> 2){
      if(n%3!=0 && n%2 !=0){
        n-=1;
        counter+=1;
      }
      if (n%3==0){
        n/=3;
        counter +=1;
      } else {
        n/=2;
        counter+=1;
      }
    }
    if (n==2){
      return counter +=1;
    }
    return counter;
  }

  public static int getMinimumHops1 ( int n){

    if(n==1){
      return 0;
    }
    else if(n==2 || n ==3 ){
      return 1;
    }
    //  if b is not divisible by 2 nor 3, subtract 1 and run function again
    if(n%2 !=0 && n%3!=0){
      return 1+ getMinimumHops1( n-1);
      // if n is divisible by 3, always call recursive for n/3
      // here we cover cases when n is divisible by 3 and 2m when is the same to do n/3 or n/2
      // we can't leave this to be the last case, because if we call here for n divisible only by 2 we'll catch numbers divisible by 2 and 3
      // for which we don't want to compute recursive of n-1 ( for example n=12. If we switch this else if case here with the following else (where
      //we cover n%2==0 we will compute both recursive n/2 and recursive of n-1 and take the minimum. But for 12 that can be divided by 3 as well, it's always
      //either n/3 or n/2 which are the same
    } else if(n%3==0 ){
      return 1+ getMinimumHops1(n/3);
    }
   else{
      // when n is divisible by 2, sometimes it's faster to subtract 1 then divide by 2 then divide by 2 from the start
      // example 10- 9 - 3-1 = 3 hops or 10 -5 -4 -2-1 = 4 hops
      return 1+ Math.min(getMinimumHops1(n/2), getMinimumHops1(n-1));
    }
  }

  public static void main (String[] args) {

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
        24, 25, 26, 27, 28, 29, 31, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
    for (int i = 0; i < arr.length; i++) {
      System.out.println("for n= " + arr[i] + " we need " + getMinimumHops1(arr[i]) + " hops.");
    }

    System.out.println("for n= " + 100 + " we need " + getMinimumHops1(100) + " hops.");

  }

}
