package main.java.com.stoiovici.leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.IntStream;
import javax.sql.rowset.serial.SQLOutputImpl;

public class ToSplit {
    //
    public static boolean canComposeMessage(String message, List<String> words){
        // Space C = O(n) where n is the number of strings
        // Time C = // O(n) where n is number of words in mesage
        List<String> messageWords = Arrays.asList(message.split(" "));
        for (int i=0; i< messageWords.size(); i++){ // O(n) * O(m+m) = O(n) * O(m) = O(n*m)
            // can make a hashSet of the words in words - will increase space c; 1) Space C = O(m) + Time c = O(m)
            if (words.contains(messageWords.get(i))){ // O(m)
                words.remove(messageWords.get(i)); // removes only the first occurance of the word, O(m)
                System.out.println(words); // don't leave  debugging code
            } else{
                System.out.println("word not found: " + messageWords.get(i));
                return false;
            }
        }
        return true;
    }
    // Space C = O(number of words in the message list)


    // 0(n+m)Time Space

    public static boolean canComposeMsg(List<String> message, List<String> words ){
        Map<String, Integer> frequencyMap1 = buildFrequencyMap(message); // O(n)
        Map<String, Integer> frequencyMap2 = buildFrequencyMap(words); // O(m)
        for (Entry<String, Integer> item: frequencyMap1.entrySet()) { // O(n)
            String key = item.getKey(); //0(1)
            Integer value = item.getValue();
            if (!(value <= frequencyMap2.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }


    //O(n+m) Time
    //0(m) Space
    public static boolean canComposeMsgLessSpace(List<String> message, List<String> words ){
        Map<String, Integer> frequencyMap2 = buildFrequencyMap(words); // O(m)
        for (String word : message){ // O(n)
            frequencyMap2.put(word, frequencyMap2.getOrDefault(word, 0) - 1);
            if(( frequencyMap2.get(word) == -1)) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> buildFrequencyMap(List<String> words){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            // if (!frequencyMap.containsKey(word)){
            //     frequencyMap.put(word,1);
            // } else {
            //     frequencyMap.put(word, frequencyMap.get(word)+1);
            // }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public static Map<Character, Integer> buildFreqMap(List<Character> characters){
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (Character character: characters){
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }
        return frequencyMap;
    }

    public static String reverseVowels(String input){
        char[] characters = input.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');
        int i=0;
        int j= input.length()-1;
        while(i<j){
            while(i<j && !vowels.contains(characters[i])){
                i++;
            }
            while(i<j && !vowels.contains(characters[j])){
                j--;
            }
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--] = temp;
        }
        return new String(characters);
    }

    public static String reverseOnlyLetters(String input){
        char[] characters = input.toCharArray();

        int i=0;
        int j= input.length()-1;
        while(i<j){
            while(i<j && !Character.isLetter(characters[i])){
                i++;
            }
            while(i<j && !Character.isLetter(characters[j])){
                j--;
            }
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--] = temp;
        }
        return new String(characters);
    }

    public static String addStrings(String num1, String num2){
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += num1.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += num2.charAt(j--) - '0';
            }
            result.append(sum % 10);
            carry = sum /10;
        }
        if(carry !=0){
            result.append(carry);
        }

       return result.reverse().toString();
    }

    public static boolean isSecondPermutation(String first, String second){
        List<Character> characters = new ArrayList<Character>();
        for(int i=0;i<second.length();i++) {
            characters.add(second.charAt(i));
        }
        for(int i=0;i<first.length();i++) {
            if (characters.contains(first.charAt(i))){
                characters.remove(characters.indexOf(first.charAt(i)));
            }
        }
        return characters.isEmpty();
    }

    //first unique character in a string
    //leetcode
    public static int firstUniqueChar(String s){
        List<Character> characters = new ArrayList<>();
        for (int i=0; i< s.length(); i++){ // 0(n)
            characters.add(s.charAt(i));
        }
// O(n) space but we'll only have 26 letters => we would consider this as O(1) Space
        Map<Character, Integer> frequencyMap = buildFreqMap(characters); // o(n)
        for (int i=0; i< s.length(); i++){ // o(n)
            if (frequencyMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    //group anagrams


    public static void main(String[] args) {
        System.out.println("Main.main");




        // // String message = "I I am coming home at six pm";
        // // List<String> words = new ArrayList<String>();
        // // //("I", "am", "coming", "home", "six","pm");
        // // words.add("I");
        // // words.add("I");
        // // words.add("I");
        // // words.add("am");
        // // words.add("coming");
        // // words.add("home");
        // // words.add("six");
        // // // words.add("at");
        // // words.add("pm");
        // // System.out.println(canComposeMessage(message, words));
        // // String myString = "A|B|C";
        // // for(String s : myString.split("\\|")){System.out.println(s);}
        //
        // String myString = "My string!";
        // int anInt = myString.codePointAt(0);
        // System.out.println(anInt);
        // int anInt1 = myString.codePointBefore(1);
        // System.out.println(anInt1);
        // int anInt2 = myString.codePointCount(0, 10);
        // System.out.println(anInt2);
        // // IntStream stream = myString.codePoints();
        // // System.out.println(stream);
        // String one = "This is string one";
        // String two = "This is String one";
        // System.out.println("This is compareTo: " + one.compareTo(two));
        // String one1 = "HELLO";
        // String two1 = "hello";
        // System.out.println("This is compareTo: " + one1.compareTo(two1));
        // String one2 = "MEYaA";
        // String two2 = "hello";
        // System.out.println("This is:: " + one1.compareTo(two1));
        // System.out.println(one2.concat(two2));
        // String one3 = "mariana";
        // String two3 = "mariana";
        // String two4 = one3;
        // System.out.println("This: " + one3.endsWith(two3));
        // if (one3.equals(two3)){
        //     System.out.println("true");
        // } else {
        //     System.out.println("flaw");
        // }
        // if (one3.equals(two4)){
        //     System.out.println("one3 equals two4 ");
        // } else {
        //     System.out.println("one3 does not equals two4 ");
        // }
        //
        //
        // String str = "Welcome! to GeeksforGeeks";
        //
        // char[] destArray = new char[20];
        // try {
        //     str.getChars(12, 25, destArray, 3);
        //     for (int i=0; i< 20; i++){
        //         if(destArray[i] != '\0'){ // if you want to check if it's null you need to use Character becasue char is primitive, null is for reference types
        //             System.out.println(destArray[i]);
        //         }
        //         else{
        //             System.out.println("char is empty");
        //         }
        //     }
        //     System.out.println(destArray);
        // }
        // catch (Exception ex) {
        //     System.out.println(ex);
        // }
        //
        //
        //
        // String aString = "Uite Mariana ma ca pot Mariana";
        // String another = "Mariana";
        // int myInt = 	aString.lastIndexOf(another);
        // System.out.println(myInt);
        //
        //
        // String again = " Mariana ";
        // String againn= 	again.repeat(3);
        // System.out.println(againn);
        //
        // String newString = again.trim(); // return a new string
        // String again1 = " Mari ana ";
        // String newString1 = again1.strip(); // you striop the original so here even though I assign the returned value to a new string i acturally modify the original too
        // System.out.println(newString.length());
        // System.out.println(newString1.length());
        // System.out.println(again1.length());
        //
        //
        // //reverse vowels
        // String string1 = "vowel";
        // String string2 = reverseVowels(string1);
        // System.out.println(string2);
        //
        // //reverse only letters
        // String string3 = "vow_el!b";
        // String string4 = reverseOnlyLetters(string3);
        // System.out.println(string4);
        //
        //
        // //addString
        // String num1 = "123";
        // String num2 = "549";
        // int num3 = num2.charAt(2) - '0';
        // System.out.println("number3 is: " + num3);
        // System.out.println("my sum is: " + addStrings(num1, num2));
        //
        // //algoexpert
        // Set<Integer> sortedList = new HashSet<>();
        // int[] array = new int[4];
        // array[0]=1;
        // array[1]=2;
        // array[2]=3;
        // array[3]=4;
        //
        // for (int i = 0; i<array.length; i++){ //O(n) time
        //     int value = array[i]; //O(1) time
        //     // squaresArr[i] = value * value; //O(1)
        //     sortedList.add(value*value);
        // }
        // System.out.println("sortedList is: \n");
        // for (Integer integer : sortedList){
        //     System.out.println(integer);
        // }
        //
        //
        //
        // //isPermutation
        // //boolean isTrue = isSecondPermutation("abc", "cab");
        // boolean isTrue = isSecondPermutation("abcAh !hB", "cabh! hBA ");
        // System.out.println(isTrue);
        //
        //
        // //cancomputeMsg
        // Map<String,Integer> frequencyMap = buildFrequencyMap(List.of("I","am", "am", "coming", "home", "six", "pm"));
        // System.out.println(frequencyMap);
        //
        //
        // boolean canComposeMsg = canComposeMsg(List.of("I","am", "coming", "home", "six", "pm"), List.of("am", "am", "coming", "coming", "home", "six", "six", "pm", "pm"));
        // System.out.println(canComposeMsg);
        //
        //
        // //
        // System.out.println(firstUniqueChar("leetcode"));
        // System.out.println(firstUniqueChar("loveleetcode"));
        // System.out.println(firstUniqueChar("aabb"));



    }
    }
