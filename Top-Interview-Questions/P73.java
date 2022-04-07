package topInterviewQs;

/**
 * Date: April 06, 2022
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 */

// TODO: redo for understanding

public class P73 {
    // time: O(m*n)
    // space: O(1)
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean setCols = false;
        // examination
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) setCols = true;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // transformation
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) matrix[0][j] = 0;
        }

        if (setCols) {
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        }
    }
}

/**
 * reference
 * https://leetcode.com/problems/set-matrix-zeroes/solution/
 */