package com.company;

public class IfBooleanCondition {
  public static boolean isDeleted(boolean bool){
    return bool;
  }
  public static void main(String[] args) {
    if(!isDeleted(true)){
      System.out.println("not deleted, do something");
    } else {System.out.println("deleted, can't do anything");}

    // if(isDeleted(true) == true){
    //   System.out.println("is deleted 2");
    // } else {System.out.println("is NOT deleted 2");}
  }
}
