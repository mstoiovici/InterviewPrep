package main.java.com.stoiovici.leetcode.strings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses {

  public static boolean validParantheses(String s){

    HashMap<Character, Character> map = new HashMap<>();
    map.put(')','(');
    map.put(']','[');
    map.put('}','{');





    Deque<Character> stack
        = new ArrayDeque<Character>();


    // // Traversing the Expression
    // for (int i = 0; i < s.length(); i++)
    // {
    //   char x = s.charAt(i);
    //
    //   if (x == '(' || x == '[' || x == '{')
    //   {
    //     // Push the element in the stack
    //     stack.push(x);
    //     continue;
    //   }
    //
    //   // If current character is not opening
    //   // bracket, then it must be closing. So stack
    //   // cannot be empty at this point.
    //   if (stack.isEmpty())
    //     return false;
    //   char check;
    //   switch (x) {
    //     case ')':
    //       check = stack.pop();
    //       if (check == '{' || check == '[')
    //         return false;
    //       break;
    //
    //     case '}':
    //       check = stack.pop();
    //       if (check == '(' || check == '[')
    //         return false;
    //       break;
    //
    //     case ']':
    //       check = stack.pop();
    //       if (check == '(' || check == '{')
    //         return false;
    //       break;
    //   }
    // }
    //
    // // Check Empty Stack
    // return (stack.isEmpty());

    char top_element = '#';
    for(int i= 0; i<s.length();i++){
      if (map.containsKey(s.charAt(i))){
        if(!stack.isEmpty()){
          top_element = stack.pop();
        } else {
          top_element = '#';
        }
        if(map.get(s.charAt(i)) != top_element){
            return false;
          }


      } else {
        stack.push(s.charAt(i));
      }
    }
    return stack.isEmpty();
  }


  public static void main (String[] strs) {
    System.out.println("Hello");

    System.out.println(validParantheses("()[]{}"));
    System.out.println(validParantheses("([)]"));
    System.out.println(validParantheses("{[]}"));

  }
}
