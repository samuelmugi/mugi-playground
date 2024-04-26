package com.codility.codeshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created on 25/04/2024
 *
 * @author Mugi
 */
public class CodeShopQ3 {
    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        Integer[][] result = combinationSum(candidates1, target1);
        printResults(result);
        int[] candidates2 = {2,3,5};
        int target2 = 8;
          result = combinationSum(candidates2, target2);
        printResults(result);
        int[] candidates3 = {2};
        int target3 = 1;
         result = combinationSum(candidates3, target3);
        printResults(result);
    }

    private static void printResults( Integer[][] result){
        System.out.print("[");
        for (Integer[] arr : result) {
            System.out.print(Arrays.toString(arr));
        } System.out.print("]");
        System.out.println();
    }
    public static void assertReversal(String actual, String expected) {
        boolean asserted = actual.equals(expected);
        if(asserted) {
            System.out.println("(Passed)actual:-[" + actual + "] expected:-[" + expected + "]" );
        }
        System.err.println("(Failed)actual:-[" + actual + "] expected:-[" + expected + "]");
    }

    public static Integer[][] combinationSum(int[] candidates, int target) {
//
        // Check constraints
        if (candidates.length < 1 || candidates.length > 30 || target < 1 || target > 500) {
            return new Integer[0][0]; // Return empty array for invalid input
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(candidates, target, 0, current, result);

        Integer[][] resArray = new Integer[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i).toArray(new Integer[0]);
        }

        return resArray;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] < 1 || candidates[i] > 200) {
                continue; // Skip invalid        candidates
            }
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }


}
/**
 * QUESTION 3 - COMBINATION SUM
 * <p>
 * Given an array of distinct integer candidates and a target integer target, return a list of all unique combinations of
 * candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
 * of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * <p>
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 * <p>
 * <p>
 * class Solution {
 * <p>
 * <p>
 * * @param Integer[] $candidates
 * * @param Integer $target
 * * @return Integer[][]
 * <p>
 * <p>
 * <p>
 * function combinationSum($candidates, $target) {
 * //YOUR CODE HERE
 * }
 * }
 */
