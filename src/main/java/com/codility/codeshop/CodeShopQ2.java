package com.codility.codeshop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * created on 25/04/2024
 *
 * @author Mugi
 */
public class CodeShopQ2 {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {2, 1, 4, 3},
                {3, 4, 1, 2},
                {4, 3, 2, 1}
        };
        int[][] matrix2 = {
                {2, 2, 2, 2},
                {2, 3, 2, 3},
                {2, 2, 2, 3},
                {2, 2, 2, 2}
        };

        int[] result1 = processMatrix(matrix1);
        int[] result2 = processMatrix(matrix2);

        System.out.println("Matrix 1 Result: " + Arrays.toString(result1));
        System.out.println("Matrix 2 Result: " + Arrays.toString(result2));
    }

    public static int[] processMatrix(int[][] matrix) {
        int diagonalSum = matrixDiagonalSum(matrix);
        int rowsWithRepeat = checkRowsRepeat(matrix);
        int columnsWithRepeat = checkColumnsRepeat(matrix);






        return new int[]{diagonalSum, rowsWithRepeat, columnsWithRepeat};
    }
    public static int matrixDiagonalSum(int[][] matrix) {
        int diagonalSum = 0;
        // Calculate diagonal sum
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }

    public static int checkRowsRepeat(int[][] matrix) {
        int rowsWithRepeat = 0;
        // Check rows for repeats
        int numRows = matrix.length;

        for (int row = 0; row < numRows; row++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasRepeat = false;
            for (int col = 0; col < matrix[row].length; col++) {
                if (!seen.add(matrix[row][col])) {
                    hasRepeat = true;
                    break;
                }
            }
            if (hasRepeat) {
                rowsWithRepeat++;
            }
        }
        return rowsWithRepeat;
    }
    public static int checkColumnsRepeat(int[][] matrix) {
        int columnsWithRepeat = 0;

        // Check columns for repeats
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int col = 0; col < numCols; col++) {
            Set<Integer> seen = new HashSet<>();
            boolean hasRepeat = false;
            for (int row = 0; row < numRows; row++) {
                if (!seen.add(matrix[row][col])) {
                    hasRepeat = true;
                    break;
                }
            }
            if (hasRepeat) {
                columnsWithRepeat++;
            }
        }
        return columnsWithRepeat;
    }
}
/**
 * QUESTION 2.Given a square matrix,
 * find
 * 1.the sum of the values on the main diagonal (which runs from the upper left to the lower right).
 * 2.the number of rows of the matrix that contain repeated elements
 * 3.the number of columns of the matrix that contain repeated elements.
 * The input of this function will be the matrix/2d array of integers and the output will
 * be the three computations put in an array and returned in json format
 * Example 1
 * <p>
 * Input
 * 1 2 3 4
 * 2 1 4 3
 * 3 4 1 2
 * 4 3 2 1
 * in php arrays would be
 * $arr = array(
 * 0 => array(1, 2, 3, 4),
 * 1 => array(2, 1, 4, 3),
 * 2 => array(3, 4, 1, 2),
 * 3 => array(4, 3, 2, 1)
 * );
 * Output(in json format)
 * [4, 0, 0]
 * where 4 at position 0 is diagonal sum as explained (1+1+1+1)=4
 * 0 at position 1 is rows with repeats which is 0 since each row does not have repeating values
 * 0 at position 2 is columns with repeats which is 0 since all columns do not have repeating values
 * Example 2
 * input
 * 2 2 2 2
 * 2 3 2 3
 * 2 2 2 3
 * 2 2 2 2
 * output
 * diagonal sum 2+3+2+2=9
 * rows with repeat 4  -2 is appearing more than once in each row
 * columns with repeat 4 2 is repeated in each of the first three rows,3 is repeated in the last column making it a total of 4 columns with repeats
 * so output will be :[9,4,4] for this case
 * CODE TEMPLATE
 * <p>
 * function processMatrix($arr)
 * {
 * --------------
 * YOUR CODE HERE
 * --------------
 * }
 */