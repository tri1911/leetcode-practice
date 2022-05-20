package leetcodingchallenge.may2022;

/**
 * Date: May 20, 2022
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */

// TODO: checkout the official solution with O(1) space

public class P63 {
    // time: O(m*n)
    // space: O(m*n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    if (i > 0 && obstacleGrid[i - 1][j] != 1) dp[i][j] += dp[i - 1][j];
                    if (j > 0 && obstacleGrid[i][j - 1] != 1) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
 * references
 * https://leetcode.com/problems/unique-paths-ii/solution/
 */
