package main.java.com.stoiovici.leetcode;

// head
//node -> head
public class LinkedList {
  Node head;

  public void push(int val) {
    // System.out.println("pushing " + val);
    Node node = new Node(val);
    // printList();
    node.next = head;
    // printList();
    head = node;
    // System.out.println("we pushed " + val + "and now the list looks like this:");
    // printList();
  }
  public void printList()
  {
    System.out.println("printing the list");
    Node tnode = head;

    while (tnode != null) {
      // System.out.println("we have the head here:" + head.val + " -> ");
      if(tnode.next != null){
        System.out.print(tnode.val + " -> ");
      } else {
        System.out.println(tnode.val + " -> null");
      }
      tnode = tnode.next;
    }
  }
  public int getLength(){
    Node hNode = head;
    int counter =0;
    while (hNode != null) {
      counter++;
      hNode = hNode.next;
    }
    return counter;
  }

  public Node removeNthFromEnd(  int n) {
    int linkedListLength = getLength();
    linkedListLength = linkedListLength - n +1;
    if(linkedListLength == 0){
      return head.next;
    }
    Node current = head;
    System.out.println("start current is: " + current.val );

    Node previous = null;
    System.out.println("start length: " + linkedListLength );
    while(linkedListLength > 0){
      System.out.println(" length is: " + linkedListLength );

      previous = current;
      System.out.println("previous is now: " + previous.val );
      current = current.next;
      System.out.println("current is now : " + current.val );
      linkedListLength -=1;

    }

    previous.next = current.next;
    System.out.println("previous: " + previous.val );
    System.out.println("current: " + current.val );
    current.next = null;
    return head;
  }

  public class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; this.next = null;}
    Node(int val, Node next) { this.val = val; this.next = next;}
 }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.push(5);
    list.push(4);
    list.push(3);
    list.push(2);
    list.push(1);
    // head ->1 ->2 -> 3 -> 4 -> 5 // e ca un stack
    list.printList();
    // System.out.println();
    // System.out.println(list.getLength());
    Node newHead = list.removeNthFromEnd(2);
    list.printList();
  }



}
