package com.codility.codeshop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * created on 25/04/2024
 *
 * @author Mugi
 */
public class CodeShopQ4 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1 || intervals.length>105) {
            return 0;
        }

        for (int[] interval : intervals) {
            if (interval.length != 2 || interval[0] < -5 * Math.pow(10, 4) || interval[0] >= 5 * Math.pow(10, 4) ||
                    interval[1] <= interval[0] || interval[1] > 5 * Math.pow(10, 4)) {
                throw new IllegalArgumentException("Invalid interval format or values outside constraints.");
            }
        }
        // Sort intervals by ending time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            // Check if the current interval overlaps with the previous one
            if (interval[0] < end) {
                count++;
            } else {
                // Update end time
                end = interval[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        int[][] intervals3 = {{1, 2}, {2, 3}};

        System.out.println("Output 1: " + eraseOverlapIntervals(intervals1)); // Output: 1
        System.out.println("Output 2: " + eraseOverlapIntervals(intervals2)); // Output: 2
        System.out.println("Output 3: " + eraseOverlapIntervals(intervals3)); // Output: 0
    }
}

/**
 * QUESTION 4: Non-overlapping Intervals
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * Example 3:
 *
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 *
 * class Solution {
 *
 *     **
 *      * @param Integer[][] $intervals
 *      * @return Integer
 *      *
 *

function eraseOverlapIntervals($intervals) {
 *
 *}
 *}
 */