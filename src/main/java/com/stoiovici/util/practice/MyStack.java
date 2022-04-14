package main.java.com.stoiovici.util.practice;

public class MyStack {
  private class StackNode{
    public int data;
    public int minimum;
    public StackNode nextNode;

    StackNode(int value) {
      this.data = value;
      this.minimum = value;
    }
  }

  private StackNode topNode;

  public int pop() throws Exception {
    if(topNode==null){
      throw new Exception("topNode is null so stack is empty");
    }
    StackNode temp = topNode;
    topNode = topNode.nextNode;
    return temp.data;
  }
  public void push(int item){
    if(topNode==null){
      topNode = new StackNode(item);
    }
    StackNode newNode = new StackNode(item);
    newNode.nextNode = topNode;
    newNode.minimum = Math.min(topNode.minimum, item);
    topNode = newNode;
  }
  public int getMinimum(){
    return topNode.minimum;
  }

  public static void main (String [] args) {
    MyStack stack = new MyStack();
    stack.push(2);
    System.out.print("after 2 :" + stack.getMinimum() + ";     ");
    stack.push(4);
    System.out.print("after 4 :" + stack.getMinimum() + ";     ");
    try {
      stack.pop();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.print("after 4 is poped :" + stack.getMinimum() + ";     ");
    stack.push(1);
    System.out.print("after 1 :" + stack.getMinimum() + ";     ");
  }

}
