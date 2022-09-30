package main.java.com.stoiovici.leetcode.strings;

public class StringCompression {
  public static int getCompressionLength(char[] chars) {
    int index = 0;
    int i = 0;
    while (i< chars.length) {
      int j = i;
      while (j < chars.length && chars[j] == chars[i]){
        j++;
      }
      chars[index++] = chars[i];
      if (j-i > 1) {
        String count = j-i + "";
        for(char c : count.toCharArray()){
          chars[index++] = c;
        }
      }
        i=j;
    }
    return index;
  }

  //this solution of mine was not returning what the problem was asking
  public static String getCompression1(char[] chars){
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
    char[] chars = {'a','a','b','b','c','c','c'};
    // String result = getCompression1(chars);
    // System.out.println(result);

    //youtube kevin naughton
    System.out.println(getCompressionLength(chars));

    char[] chars1 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
    System.out.println(getCompressionLength(chars1));
  }

}
