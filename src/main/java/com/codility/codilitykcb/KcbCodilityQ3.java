package com.codility.codilitykcb;

import java.util.*;

public class KcbCodilityQ3 {

  public static void main(String[] args) {
    int res = solution("AcZCbaBz");
    System.out.println(res);
    res = solution("TacoCat");
    System.out.println(res);
    res = solution("azABaabza");
    System.out.println(res);
    res = solution("abcdefghijklmnopqrstuvwxyz");
    System.out.println(res);
  }
    public static int solution(String S) {
//        int n = S.length();
//        int minLen = Integer.MAX_VALUE; // To track the minimum length of a balanced substring
//
//        // Iterate over all possible substrings of S
//        for (int i = 0; i < n; i++) {
//            Set<Character> withLower = new HashSet<>();
//            Set<Character> withUpper = new HashSet<>();
//
//            for (int j = i; j < n; j++) {
//                char c = S.charAt(j);
//                if (Character.isLowerCase(c)) {
//                    withLower.add(c);
//                } else {
//                    withUpper.add(c);
//                }
//
//                // Check if current substring is balanced
//                if (hasBothUpperAndLower(withLower, withUpper)) {
//                    minLen = Math.min(minLen, j - i + 1);
//                    break; // No need to extend this substring further
//                }
//            }
//        }
//
//        // Return -1 if no balanced substring is found, otherwise the length of the shortest one
//        return minLen == Integer.MAX_VALUE ? -1 : minLen;


        int shortestLength = Integer.MAX_VALUE;  //init to max possible integer
        int stringLength = S.length();

        // Iterate possible fragments of S
        for (int start = 0; start < stringLength; start++) {
            Set<Character> withLower = new HashSet<>();
            Set<Character> withUpper = new HashSet<>();

            for (int end = start; end < stringLength; end++) {
                char character = S.charAt(end);
                if (Character.isLowerCase(character)) {
                    withLower.add(character);
                } else {
                    withUpper.add(character);
                }

                // Check if current fragment has  upper and lower characters
                if (hasBothUpperAndLower(withLower, withUpper)) {
                    shortestLength = Math.min(shortestLength, end - start + 1);
                    break; // If has both break from loop
                }
            }
        }

        // Return -1 if no balanced fragment or the smallest fragment
        return shortestLength == Integer.MAX_VALUE ? -1 : shortestLength;





    }

    private static boolean hasBothUpperAndLower(Set<Character> withLower, Set<Character> withUpper) {
//        if (withLower.size() != withUpper.size()) return false;
//        for (char lower : withLower) {
//            //check if all characters in lower exist in upper
//            if (!withUpper.contains(Character.toUpperCase(lower))) {
//                return false;
//            }
//        }
//        return true;
        return withLower.size() == withUpper.size() &&
                withLower.stream().allMatch(lower -> withUpper.contains(Character.toUpperCase(lower)));

    }
//    public static int doSolution(String S) {
//        PriorityQueue<Integer> max = new PriorityQueue<>();
//
//        for (int i = 0; i < S.length(); i++) {
//            for (int j = i + 1; j < S.length(); j++) {
//                String substring = S.substring(i, j);
//                if(substring.length() == 1){
//                    continue;
//                }
//                if(checkIsBalanced(substring) == -1){
//                    continue;
//                }
//                max.add(checkIsBalanced(substring));
//            }
//        }
//        if(max.isEmpty()) {
//            return -1;
//        }
//        return max.poll();
//    }
//
//    private static int checkIsBalanced(String substring) {
//        int count = 0;
//        boolean isBalanced = false;
//        Set<Character> characters = new HashSet<>();
//        for (char c : substring.toCharArray()) {
//            characters.add(c);
//        }
//        for(Character c : substring.toCharArray()){
//            if(Character.isUpperCase(c)){
//                if(characters.contains(Character.toLowerCase(c))){
//                    isBalanced = true;
//                    count++;
//                }
//            }
//        }
//        if(isBalanced){
//            return count;
//        }
//        return -1;
//    }
//
//  public static int doSolution(String S) {
//    String stringShortest = "";
//    List<String> listPatterns = new ArrayList<>();
//
//    for (int i = 0; i < S.length(); i++) {
//      char letter = S.charAt(i);
//      char response = isBalanced(letter, i, S, Character.isUpperCase(letter));
//      if (response != '\0') {
//        stringShortest += response;
//      } else {
//        if (!stringShortest.isEmpty() && stringShortest.length() > 1) {
//          listPatterns.add(stringShortest);
//        }
//        stringShortest = "";
//      }
//    }
//
//    if (!stringShortest.isEmpty() && stringShortest.length() > 1 && listPatterns.isEmpty()) {
//      listPatterns.add(stringShortest);
//    }
//
//    if (!listPatterns.isEmpty()) {
//      stringShortest = Collections.max(listPatterns);
//    }
//
//    return listPatterns.size() >= 1 ? stringShortest.length() : -1;
//  }
//
//  public static char isBalanced(char letter, int index, String S, boolean isUpper) {
//    char response = '\0';
//    for (int i = 0; i < S.length(); i++) {
//      if (index != i) {
//        if (isUpper) {
//          if (Character.toLowerCase(letter) == S.charAt(i)) {
//            response = letter;
//          }
//        } else {
//          if (Character.toUpperCase(letter) == S.charAt(i)) {
//            response = letter;
//          }
//        }
//      }
//    }
//    return response;
//  }
}
/**
 * A string is called balanced when every letter occurring in the string, appears both in upper- and lowercase. For example, the string "CATattac" is balanced ('a', 'c' and 't' occur in both cases), but "Madam" is not ('d' and 'a' appear only in lowercase). Note that the number of occurrences does not matter. Write a function:
 * class Solution { public int solution(String S); }
 * that, given a string S of length N, returns the length of the shortest balanced fragment of S. If S does not contain any balanced fragments, the function should return -1.
 * Examples:
 * 1. Given S = "azABaabza", the function should return 5. The shortest balanced fragment of S is "ABaab".
 * 2. Given S = "TacoCat", the function should return -1. There is no balanced fragment.
 * 3. Given S = "AcZCbaBz", the function should return 8. The shortest balanced fragment is the whole string.
 * 4. Given S = "abcdefghijklmnopqrstuvwxyz", the function should return -1.
 * Assume that:
 * * N is an integer within the range [1..200];
 * * string S consists only of letters ('a'-'z' and/or 'A'-'Z').
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */