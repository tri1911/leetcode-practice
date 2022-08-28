package leetcodingchallenge.august2022;

import java.util.Arrays;

/**
 * Date: August 28, 2022
 * 1329. Sort the Matrix Diagonally
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */

// TODO: optimize by using counting sort

public class P1329 {
    // time: O(m + n)
    // space: O(m + n)
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        // time: O(m + n)
        // a diagonal array to store cell values on each matrix diagonal
        int diagonal_size = Math.min(rows, cols);
        int[] diagonal_array = new int[diagonal_size];
        // start points = (0, 0), (1, 0),...(rows - 1, 0)
        for (int startRow = 0; startRow < rows; startRow++) {
            int row = startRow, col = 0, i = 0;
            while (row < rows && col < cols) {
                diagonal_array[i++] = mat[row++][col++];
            }
            Arrays.sort(diagonal_array, 0, i);
            row = startRow;
            col = 0;
            for (int j = 0; j < i; j++) {
                mat[row++][col++] = diagonal_array[j];
            }
        }
        // time: O(m + n)
        // start points = (0, 1),...(0, cols - 1)
        // already count (0, 0) already so col start from 1 instead of 0
        for (int startCol = 1; startCol < cols; startCol++) {
            int col = startCol, row = 0, i = 0;
            while (row < rows && col < cols) {
                diagonal_array[i++] = mat[row++][col++];
            }
            Arrays.sort(diagonal_array, 0, i);
            col = startCol;
            row = 0;
            for (int j = 0; j < i; j++) {
                mat[row++][col++] = diagonal_array[j];
            }
        }

        return mat;
    }
}
