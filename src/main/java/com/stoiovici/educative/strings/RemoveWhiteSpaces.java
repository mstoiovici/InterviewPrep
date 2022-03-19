package main.java.com.stoiovici.educative.strings;

public class RemoveWhiteSpaces {

  public static boolean isWhiteSpace(char character){
    if (character == ' ' || character == '\t'){
      return true;
    }
    return false;
  }

  public static void removeWhiteSpaces(char[] s){
    int writeIndex = 0;
    int readIndex = 0;

    while (readIndex < s.length){  // readIndex
      if(!isWhiteSpace(s[readIndex])){
        s[writeIndex]=s[readIndex];
        writeIndex++;
      }
      readIndex++;
    }
    s[writeIndex]=' '; // here is tricky cause I can use '\0' . it seems string differ from char[] by the fact that a String terminates with a '\0'


    System.out.print(s);

  }

  public static void main(String[] args){
      String str = "Hello M";
      removeWhiteSpaces(str.toCharArray());

    }


  //Educative
  // static boolean isWhiteChar(char c) {
  //   // there can be more white space characters
  //   // but for simplicity lets assume that we have
  //   // only two white space character
  //   // i.e. space and tab
  //   if (c == ' ' || c == '\t') {
  //     return true;
  //   }
  //   return false;
  // }
  //
  // static void removeWhiteSpaces(char[] s) {
  //   if (s == null || s.length == 0 || s[0] == '\0') {
  //     return;
  //   }
  //
  //   // We will use read, write pointers here.
  //   // Write pointer will follow the read pointer
  //   // and only write characters read that are neither
  //   // a space (' ') nor a tab ('\t').
  //
  //   int readPtr = 0;
  //   int writePtr = 0;
  //   while (readPtr < s.length) {
  //     // Lets assume there are only two white
  //     // space characters: space and tab.
  //     if (!isWhiteChar(s[readPtr])) {
  //       s[writePtr] = s[readPtr];
  //       ++writePtr;
  //     }
  //     ++readPtr;
  //   }
  //
  //   // Let's mark the end of string.
  //   s[writePtr] = '\0';
  // }
  //
  // static void print(char[] s) {
  //   int i = 0;
  //   while (i < s.length && s[i] != '\0') {
  //     System.out.print(s[i]);
  //     ++i;
  //   }
  //   System.out.println();
  // }
  //
  // static char[] getArray(String t) {
  //   char[] s = new char[t.length()];
  //   int i = 0;
  //   for (; i < t.length(); ++i) {
  //     s[i] = t.charAt(i);
  //   }
  //   return s;
  // }
  //
  // public static void main(String[] args) {
  //   char[] s = getArray("All gek");
  //   System.out.print("Before: ");
  //   print(s);
  //   removeWhiteSpaces(s);
  //   System.out.print("After: ");
  //   print(s);
  // }
}
