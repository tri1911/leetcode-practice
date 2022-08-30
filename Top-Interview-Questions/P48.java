package topInterviewQs;

/**
 * Date: Jan 08, 2022 - Redo: August 30, 2022
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 */

public class P48 {
    // time: O(M) where M is the number of cells
    // space: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose (e.g. 0, 2 <-> 2,0 OR 2, 1 <-> 1, 2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // print(matrix);
        // reverse in row(e.g. 0, 0 <-> 0, 3 OR 0, 1 <-> 0, 2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
        // print(matrix);
    }

    // helper functions
    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;
    }

    private void print(int[][] matrix) {
        int n = matrix.length;
        String s = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s += matrix[i][j];
                if (j != n - 1) s += ", ";
            }
            s += "\n";
        }
        System.out.println(s);
    }

    // Redo on August 30, 2022 - use the first approach in the official solution
    // time: O(n) where n is the size of matrix
    // space: O(1)
    public void _rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}

/**
 * References
 * https://leetcode.com/problems/rotate-image/solution/
 * https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
 */