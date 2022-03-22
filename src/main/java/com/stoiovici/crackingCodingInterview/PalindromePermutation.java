package main.java.com.stoiovici.crackingCodingInterview;

public class PalindromePermutation {

  // Given a string, write a function to check whether it is a permutation of a palindrome
  // The palindrome does not need to be limited to just dictionary words
  // input: tact coa output:true ("taco cat")


  //map each character to a number: a->0; b->1 etc. Case insensitive
  //non letter characters will map to -1
  public static int getCharNumber(Character character) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int val = Character.getNumericValue(character);
    if (a <= val && val <= z) {
      return val - a;
    }
    return -1;
  }

  //count how many times each character appears
  public static int [] buildCharFrequencyTable(String phrase){
    //if you don't know how many letters are in the alphabet :)
    //otherwise just give it a size of 26
    int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1 ];
    for(char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      if (x != -1) {
        table[x]++;
      }
    }
    return table;
  }

  //check that no more than one character has an off count
  public static boolean checkMaxOneOdd (int [] table) {
    boolean foundOdd = false;
    for (int count : table) {
      if (count % 2 == 1) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  // O(n) time complexity
  public static boolean isPalindromePermutation1(String phrase) {
    //palindrome will have even number of characters so that half can be on one side and half on the other
    // at most one character can have an odd count (the middle character)
    // aba; aabaa; aaabbcaaabb
    int [] table = buildCharFrequencyTable(phrase);
    return checkMaxOneOdd(table);
  }

  //Solution 2
  public static boolean isPalindromePermutation2(String phrase) {
    int countOdd = 0;
    int[] table = new int[26];
    for (char c : phrase.toCharArray()) {
      int x = getCharNumber(c);
      if(x != -1) {
        table[x]++;
        if(table[x] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }
    return countOdd <= 1;
  }

  public static void main (String [] args) {
    String phrase = "tact Coa";
    boolean isPalindromePermutation = isPalindromePermutation1(phrase);
    if (isPalindromePermutation) {
      System.out.println("yes it is");
    } else {
      System.out.println("no, it is not");
    }



  }

}
