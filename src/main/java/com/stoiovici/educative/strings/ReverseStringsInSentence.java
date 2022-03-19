package main.java.com.stoiovici.educative.strings;

public class ReverseStringsInSentence {
//TODO:read time and space complexity as educative sugests is only O(n)?? time and O(1) space (this makes sense as no extra space is used)
  public static void reverseStr(char[] arr, int start, int end){
    while(start < end){
      char temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    System.out.println(arr);
  }

  public static void reverseArr(char[] arr){
    //reverse the whole array
    reverseStr(arr, 0, arr.length-2);
    System.out.println(arr.length);
   //reverse each word in the array
    int startWord = 0;
    int endWord;
    while (true){
      while(arr[startWord] == ' '){
        //educative's solution has a bug. if we don't check here that startWord still has room to grow, it will grow to 13, and check the while
        // one more time, which arr[13] will return an indexOutOfBoundException
       if(startWord <=arr.length-2) {
         ++startWord;
       }
      }
      if (startWord >= arr.length - 1) {
        break;
      }
      endWord = startWord +1;
      while (endWord < arr.length - 1 && arr[endWord] != ' ') {
        ++endWord;
      }

      reverseStr(arr,startWord, endWord -1);
      startWord = endWord;
    }
  }

  public static void main (String[] args){
    //if you get a string, when you transform to char[] make sure to add a whitespace at the end
    char[] charArray = {'H','e','l','l','o',' ','W','o','r','l','d','!',' '};
    reverseArr(charArray);
    System.out.println(charArray);

  }


  //Educative solution:

  // public static void strRev(char[] str, int start, int end) {
  //   if (str == null || str.length < 2) {
  //     return;
  //   }
  //
  //   while (start < end) {
  //     char temp = str[start];
  //     str[start] = str[end];
  //     str[end] = temp;
  //     start++;
  //     end--;
  //   }
  // }
  //
  // public static void reverseWords(char[] sentence) {
  //   // Here sentence is a null-terminated string ending with char '\0'.
  //   if (sentence == null || sentence.length == 0) {
  //     return;
  //   }
  //
  //   // To reverse all words in the string, we will first reverse
  //   // the string. Now all the words are in the desired location, but
  //   // in reverse order: "Hello World" -> "dlroW olleH".
  //   int len = sentence.length;
  //   strRev(sentence, 0, len - 2);
  //
  //   // Now, let's iterate the sentence and reverse each word in place.
  //   // "dlroW olleH" -> "World Hello"
  //   int start = 0;
  //   int end;
  //
  //   while (true) {
  //     // find the  start index of a word while skipping spaces.
  //     while (sentence[start] == ' ') {
  //       ++start;
  //     }
  //
  //     if (start >= sentence.length - 1) {
  //       break;
  //     }
  //
  //     // find the end index of the word.
  //     end = start + 1;
  //     while (end < sentence.length - 1 && sentence[end] != ' ') {
  //       ++end;
  //     }
  //
  //     // let's reverse the word in-place.
  //     strRev(sentence, start, end - 1);
  //     start = end;
  //   }
  // }
  //
  // static char[] getArray(String t) {
  //   char[] s = new char[t.length() + 1];
  //   int i = 0;
  //   for (; i < t.length(); ++i) {
  //     s[i] = t.charAt(i);
  //   }
  //   return s;
  // }

  // public static void main (String[] args){
  //   char[] s = getArray("Hello World!");
  //   System.out.println(s);
  //   reverseWords(s);
  //   System.out.println(s);
  // }
}
