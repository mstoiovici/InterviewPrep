package main.java.com.stoiovici.leetcode.strings;

public class StringCompression {

  public static String getCompression(char[] chars){
    StringBuilder result = new StringBuilder();
    int counter =1;
    for(int i=0; i<chars.length ; i++){
      if((i+1 < chars.length && chars[i+1] != chars[i]) || (i==chars.length-1)){
        if(counter == 1){
          result.append(chars[i]);
        }
        else {
          result.append(chars[i]).append(counter);
          counter = 1;
        }
      } else {
        counter++;
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    char[] chars = {'a','a','b','b','c','c','c', 'a'};
    String result = getCompression(chars);
    System.out.println(result);
  }

}
