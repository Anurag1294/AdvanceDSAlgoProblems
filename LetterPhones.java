/*
Letter Phone
Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints
1 <= |A| <= 10



Input Format
The only argument is a digit string A.



Output Format
Return a string array denoting the possible letter combinations.



Example Input
Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output
Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


 */


import java.util.*;

public class LetterPhones {


    public static void main(String[] args) {
        String A = "23";
        System.out.println(letterCombinations(A));
        System.out.println(combinations.size());
    }
    private static ArrayList<String> combinations = new ArrayList<>();
    private static Map<Character, String> letters = new HashMap<>();
    public static void setLetters(Map<Character, String> letters) {
       // LetterPhones.letters = letters;
        letters.put('0',"0");
        letters.put('1',"1");
        letters.put('2',"abc");
        letters.put('3',"def");
        letters.put('4',"ghi");
        letters.put('5',"jkl");
        letters.put('6',"mno");
        letters.put('7',"pqrs");
        letters.put('8',"tuv");
        letters.put('9',"wxyz");

    }
    private static String phoneDigits;
    public static ArrayList<String> letterCombinations(String A) {
            setLetters(letters);
            // If the input is empty, immediately return an empty answer array
            if (A.length()==0){
                return combinations;
            }
            phoneDigits=A;
            Bactrack(0,new StringBuilder());
            return combinations;

    }

    public static void Bactrack(int Index , StringBuilder path){
        // If the path is the same length as digits, we have a complete combination
        if (path.length()==phoneDigits.length()){
            combinations.add(path.toString());
            return;// Bactrack
        }
        // Get the letters that the current digit maps to, and loop through them
        String PossibleLetters = letters.get(phoneDigits.charAt(Index));
        for(char letter: ((String) PossibleLetters).toCharArray()){
            path.append(letter);
            Bactrack(Index+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }

}
