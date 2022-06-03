package leetcodingchallenge.june2022;

/**
 * Date: June 03, 2022
 * 304. Range Sum Query 2D - Immutable (Already solved before in C++)
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */

public class P304 {
    // space: O(m * n)
    private int[][] ps;

    // time: O(m * n)
    public P304(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        ps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ps[i][j] = matrix[i][j];
                if (i > 0) ps[i][j] += ps[i - 1][j];
                if (j > 0) ps[i][j] += ps[i][j - 1];
                if (i > 0 && j > 0) ps[i][j] -= ps[i - 1][j - 1];
            }
        }
    }

    // time: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = ps[row2][col2];
        if (row1 > 0) result -= ps[row1 - 1][col2];
        if (col1 > 0) result -= ps[row2][col1 - 1];
        if (row1 > 0 && col1 > 0) result += ps[row1 - 1][col1 - 1];
        return result;
    }
}

/**
 * references
 * https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
 */