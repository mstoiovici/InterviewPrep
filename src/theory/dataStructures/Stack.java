package theory.dataStructures;

import java.util.EmptyStackException;

public class Stack {
  int head =0;
  int[] arr;

  Stack(int n){
    this.arr = new int [n + 1];
  }

  void push(int element){
    if (isFull()){
      System.out.println("error overFlow");
    }
    head+=1;
    arr[head]= element;
  }

  int pop(){
    if (isEmpty()){
      System.out.println("error underflow");
    }
    int popped = arr[head];
    head-=1;
    return popped;
  }
  boolean isEmpty(){
    if(head == 0){
      return true;
    }
    return false;
  }

  boolean isFull(){
    if(head == arr.length-1){
      return true;
    }
    return false;
  }
  void printStack(){
    if(isEmpty()){
      System.out.println("Stack is empty but printing arr:");
      printArr();

        throw new EmptyStackException();

    } else {
      System.out.print("[");
      for(int i=1; i<=head; i++){
        System.out.print(arr[i] + ",");
      }
      System.out.print("]");
    }
  }
  void printArr(){
    System.out.print("[");
    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i] + ",");
    }
    System.out.print("]");
  }

  public static void main(String[] args) {
    Stack stack = new Stack(5);
    stack.push(1);
    stack.printStack();
    stack.push(2);

    stack.push(3);

    stack.push(4);
    stack.printStack();
    stack.push(5);
    stack.printStack();
    System.out.println( stack.pop());

    stack.printStack();
    System.out.println( stack.pop());

    System.out.println( stack.pop());
    System.out.println( stack.pop());



    stack.printStack();
    System.out.println();

    System.out.println( stack.pop());


    stack.printStack();

    stack.push(100);
    stack.printStack();
  }
}
