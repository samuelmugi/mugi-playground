package com.codility.codilitykcb;

import java.util.*;

public class KcbCodilityQ2 {
    public static int minDistance(int[] A) {if (A == null || A.length < 2) return -1;
        if(A.length == 1 ){
            return -2;
        }
        var values = new HashSet<Integer>();
        for (int value : A) {
            values.add(value);
        }
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                var value1 = A[i];
                var value2 = A[j];

                var diff = Math.abs(value1 - value2);
                if(diff == 1){
                    max.add(diff);
                    continue;
                }
                int start = Math.min(value1, value2);
                boolean isPresent = false;
                for (int k = 1; k < diff; k++) {
                    if(values.contains(++start)){
                        isPresent = true;
                        break;
                    }
                }
                if(!isPresent){
                    max.add(diff);
                }
            }
        }

        if(max.isEmpty()) {
            return -2;
        }

        var maxValue = max.poll();
        if(maxValue >=100000000){
            return -1;
        }

        return maxValue;
    }
    public static int solutionMutuma(int[] A) {
        if(A.length == 1 ){
            return -2;
        }
        Set<Integer> values = new HashSet<>();
        for (int value : A) {
            values.add(value);
        }
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int value1 = A[i];
                int value2 = A[j];

                int diff = Math.abs(value1 - value2);
                if(diff == 1){
                    max.add(diff);
                    continue;
                }
                int start = Math.min(value1, value2);
                boolean isPresent = false;
                for (int k = 1; k < diff; k++) {
                    if(values.contains(++start)){
                        isPresent = true;
                        break;
                    }
                }
                if(!isPresent){
                    max.add(diff);
                }
            }
        }

        if(max.isEmpty()) {
            return -2;
        }

        var maxValue = max.poll();
        if(maxValue >=100000000){
            return -1;
        }

        return maxValue;
    }
    public static int solution(int[] A) {
        if (A.length == 1) {
            return -2;
        }

        // Use a HashSet to track seen values for quick lookup.
        Set<Integer> values = new HashSet<>();
        for (int value : A) {
            values.add(value);
        }

        // Instead of using a priority queue to store all differences, directly calculate the maximum.
        int maxDifference = -1;

        // Iterate over the array to find the largest non-contiguous difference.
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int value1 = A[i];
                int value2 = A[j];

                int diff = Math.abs(value1 - value2);
                // Check if the difference is already optimal or if there are no intervening values.
                if (diff > maxDifference && !hasInterveningValues(value1, value2, values)) {
                    maxDifference = diff;
                }
            }
        }

        // Check edge cases for large maximum differences or no valid differences found.
        if (maxDifference == -1) {
            return -2;
        } else if (maxDifference >= 100000000) {
            return -1;
        } else {
            return maxDifference;
        }
    }

    // Helper method to determine if there are intervening values between two numbers.
    private static boolean hasInterveningValues(int value1, int value2, Set<Integer> values) {
        int start = Math.min(value1, value2) + 1;
        int end = Math.max(value1, value2) - 1;
        for (int k = start; k <= end; k++) {
            if (values.contains(k)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] A = new int[]{0,3,3,7,5,3,11,1};
//        int[] A = new int[]{};
//        int[] A = new int[]{100000000};
        int minDistance = solution(A);
        System.out.println(minDistance);
        System.out.println(solutionMutuma(A));
    }
}
/**
 * Integer V lies strictly between integers U and W if U < V <W or U >V >W.
 * A non-empty array A consisting of N integers is given. A pair of indices (P, Q), where 0 ≤ P < Q<N, is said to have adjacent values if no value in the array lies strictly between values A[P] and AIQJ. For example, in array A such that:
 * A[0] = 0
 * A[1] =3
 * A[2] = 3
 * A[3]= 7
 * A[4] = 5
 * A[5]= 3
 * A[6] = 11
 * A[7] = 1
 * the following pairs of indices have adjacent values:
 * (0, 7), (1, 2), (1, 4),
 * (1, 5), (1, 7), (2, 4),
 * (2,5), (2, 7), (3, 4),
 * (3, 6), (4, 5),  (5, 7).
 * For example, indices 4 and 5 have adjacent values because there is no value in array A that lies strictly between A[4] = 5 and A[5] = 3; the only such value could be the number 4, and it is not present in the array. Given two indices P and Q, their distance is defined as abs(A[P] - A[Q]), where abs(X) = X for X ≥ 0, and abs(X) = -X for X < 0. For example, the distance between indices 4 and 5 is 2 because (A[4] - A[5]) = (5 − 3) = 2.
 *  Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty array A consisting of N integers, returns the maximum distance between indices of this array that have adjacent values. The function should return -1 if the maximum distance is greater than 100,000,000. The function should return -2 if no adjacent indices exist.
 * For example, given array A such that:
 * A[0] = 0
 * A[1]= 3
 * A[2]= 3
 * A[3] = 7
 * A[4] =  5
 * A[5] = 3
 * A[6] = 11
 * A[7] = 1
 * the function should return 4 because:
 *
 * ⚫ indices 3 and 6 are adjacent, because the array does not contain any value that lies strictly between A[3] = 7 and A[6] = 11;
 * ⚫ the distance between these indices is (A[6] – A[3]) = (11 −7) = 4, because (A[3] – A[6]) < 0;
 * ⚫ no other pair of adjacent indices that has greater distance exists.
 * Write an efficient algorithm for the following assumptions:
 * * N is an integer within the range [1.40,000];
 * * each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
 */