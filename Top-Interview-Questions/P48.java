package topInterviewQs;

// Date: Jan 8, 2022
// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/

// TODO: checkout for another implementation

public class P48 {
    // time complexity: O(M) where M is the number of cells
    // space complexity: O(1)
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
}

// reference
// https://leetcode.com/problems/rotate-image/solution/
// https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image