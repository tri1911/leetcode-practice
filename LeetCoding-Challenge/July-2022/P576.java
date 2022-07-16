package leetcodingchallenge.july2022;

import java.util.Arrays;

/**
 * Date: July 16, 2022
 * 576. Out of Boundary Paths
 * https://leetcode.com/problems/out-of-boundary-paths/
 */

// TODO: implement the dynamic programming approach

public class P576 {
    // time: O(m*n)
    // space: O(m*n*maxMove)

    private final int MOD = 1000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int[][] a : memo) for (int[] b : a) Arrays.fill(b, -1);
        return dfs(m, n, maxMove, startRow, startColumn, memo);
    }

    private int dfs(int m, int n, int maxMove, int row, int col, int[][][] memo) {
        if (row == m || row < 0 || col == n || col < 0) return 1;
        if (maxMove == 0) return 0;
        if (memo[row][col][maxMove] != -1) return memo[row][col][maxMove];
        return memo[row][col][maxMove] = ((dfs(m, n, maxMove - 1, row + 1, col, memo) +
                dfs(m, n, maxMove - 1, row - 1, col, memo)) % MOD +
                (dfs(m, n, maxMove - 1, row, col + 1, memo) +
                        dfs(m, n, maxMove - 1, row, col - 1, memo)) % MOD) % MOD;
    }
}

/**
 * references
 * https://leetcode.com/problems/out-of-boundary-paths/solution/
 */