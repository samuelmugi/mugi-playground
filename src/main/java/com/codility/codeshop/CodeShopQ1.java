package com.codility.codeshop;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

/**
 * created on 25/04/2024
 *
 * @author Mugi
 */
public class CodeShopQ1 {


    public static String reverseString(String s) {
        if (s == null || s.length() == 0 ||s.length() > 104) {
            System.out.println("Invalid String supplied!!!\n(1 <= s.length <= 104)");
            return "";
        }

        s = s.trim().replaceAll("\\s+", " ");
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
//            System.out.println("index:" + i + " word:" + words[i]);
            result.append(words[i]).append("\s");
        }
        System.out.println("Reversed:-" + result.toString().trim());
        return result.toString().trim();
    }

    public static void assertReversal(String actual, String expected) {
        boolean asserted = actual.equals(expected);
        if(asserted) {
        System.out.println("(Passed)actual:-[" + actual + "] expected:-[" + expected + "]" );
        }
        System.err.println("(Failed)actual:-[" + actual + "] expected:-[" + expected + "]");
    }

    public static void main(String[] args) {

        /**   * Input: s = "the sky is blue"  * Output: "blue is sky the"   **/
        String s1 = "the sky is blue";
        String result1 = reverseString(s1);
        String output = "blue is sky the";
        assertReversal(result1, output);


        /*** Input: s = "  hello world  "  * Output: "world hello"   */

        String s2 = "  hello world  ";
        String result2 = reverseString(s2);
        output = "world hello";
        assertReversal(result2, output);
        /**  Input: s = "a good   example"   * Output: "example good a"  */
        String s3 = "a good   example";
        String result3 = reverseString(s3);
        output = "example good a";
        assertReversal(result3, output);
        /** * Input: s = "  Bob    Loves  Alice   "   * Output: "Alice Loves Bob"  */
        String s4 = "  Bob    Loves  Alice   ";
        String result4 = reverseString(s4);
        output = "Alice Loves Bob";
        assertReversal(result4, output);
        /** * Input: s = "Alice does not even like bob"  * Output: "bob like even not does Alice"  */
        String s5 = "Alice does not even like bob";
        String result5 = reverseString(s5);
        output = "bob like even not does Alice";
        assertReversal(result5, output);

        /** * Input: s = length greater than 104  * Output: "null"  */
        String s6 = "The quick brown fox jumps over the lazy dog The quick brown fox jumps over the lazy dogThe quick brown fox jumps over the lazy dog";
        String result6 = reverseString(s6);
        output = "";
        assertReversal(result6, output);
    }
}
/**
 * QUESTION 1.Given an input string, reverse the string word by word.
 * <p>
 * A word is defined as a sequence of non-space characters.
 * <p>
 * Notice that the input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * <p>
 * Also, notice that you need to reduce multiple spaces between two words to a single space in the reversed string.
 * Your function should have input of the string to be reversed and it should return the reversed string.
 * do not use array_reverse or any other built in function to do the reversal,
 * <p>
 * instead you should implement an iterative solution
 * Example 1:
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Example 4:
 * <p>
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 * Example 5:
 * <p>
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 * <p>
 * Constraints for input s:
 * <p>
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 * code template
 * <p>
 * function reverseString($s)
 * {
 * $new_str="";
 * ------
 * YOUR CODE HERE
 * -------
 * return $new_str;
 * }
 */