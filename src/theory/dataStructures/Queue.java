package theory.dataStructures;

public class Queue {
  int head =0;
  int tail =0;
  int[] arr;

  Queue(int n){
    this.arr = new int [n + 1];
  }

  void enqueue(int element){
    if (isFull()){
      System.out.println("error overflow");
    }
    if (isEmpty()){
      head+=1;
      arr[head]= element;
      tail = head +1;
    } else if(tail == arr.length-1) {
      arr[tail]= element;
      tail = 0;
    } else {
      arr[tail] = element;
      tail +=1;
    }
  }

  void dequeue(){
    if (isEmpty()){
      System.out.println("error underflow");
    } else if (isFull()){head+=1; tail +=1;
    } else {head+=1;}

  }
  boolean isEmpty(){
    if(head == tail){
      return true;
    }
    return false;
  }

  boolean isFull(){
    if(head == tail +1){
      return true;
    }
    return false;
  }
  void printQueue(){
    if(isEmpty()){
      System.out.print("Stack is empty but printing arr:");
      printArr();
    } else if (isFull()){
      System.out.print("[");
      for(int i=head; i<=arr.length -1 ; i++){
        System.out.print(arr[i] + ",");
      }
      System.out.print("]");
    } else {
      System.out.print("[");
      for(int i=head; i<tail; i++){
        System.out.print(arr[i] + ",");
      }
      System.out.print("]");}
  }
  void printArr(){
    System.out.print("[");
    for(int i=0; i<arr.length; i++){
      System.out.print(arr[i] + ",");
    }
    System.out.print("]");
  }

  public static void main(String[] args) {
    Queue queue = new Queue(5);
    // queue.printQueue();
    queue.enqueue(1);
    // queue.printQueue();
    queue.enqueue(2);

    queue.enqueue(3);

    queue.enqueue(4);
    queue.printQueue();
    queue.enqueue(5);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();

  }
}

