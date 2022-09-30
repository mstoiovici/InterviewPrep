package main.java.com.stoiovici.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinaryTreeInOrder {



  public List<Integer> inorderTraversal(TreeNode root) {
    return traverseWithStack(root);
  }

  // private List<Integer> traverse(TreeNode root) {
  //   if (root == null) {
  //     return new ArrayList<>();
  //   }
  //
  //   List<Integer> outputLeft = traverse(root.left);
  //
  //   outputLeft.add(root.val);
  //   List<Integer> outputRight = traverse(root.right);
  //   if(outputRight.size() > 0 ){
  //     for(Integer integer : outputRight){
  //       outputLeft.add(integer);
  //     }
  //   }
  //   return output;
  // }

  private List<Integer> traverse(TreeNode root) {
    List<Integer> output = new ArrayList<>();
    if (root != null) {
      traverse(root.left);
      output.add(root.val);
      traverse(root.right);
      return output;
    }
    return new ArrayList<>();
  }

  private List<Integer> traverseWithStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> output = new ArrayList<>();

    while(root != null  || !stack.isEmpty()){
      while(root != null){
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      output.add(root.val);
      root = root.right;

    }

    return output;
  }




  public static void main(String[] args) {
    BinaryTreeInOrder binaryTreeInOrder = new BinaryTreeInOrder();
    TreeNode root = new TreeNode(1, new TreeNode(), new TreeNode(2, new TreeNode(3), new TreeNode()));
    // List<Integer> output = binaryTreeInOrder.inorderTraversal(root).stream().filter( p-> p!=0).collect(Collectors.toList());;
    List<Integer> output = binaryTreeInOrder.inorderTraversal(root).stream().filter( p-> p!=0).collect(Collectors.toList());
    System.out.println(output);
  }
}
 class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

