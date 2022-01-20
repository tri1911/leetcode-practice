package leetcodingchallenge.january2022;

// Date: Jan 8, 2022
// 1463. Cherry Pickup II
// https://leetcode.com/problems/cherry-pickup-ii/

// TODO: implement tabulation approach with state compression (only record the previous row)

public class P1463 {
    /*  Memoization approach (Top Down)
        public int cherryPickup(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int[][][] memo = new int[rows][cols][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    for (int k = 0; k < cols; k++) {
                        memo[i][j][k] = -1; // mark cells as unseen
                    }
                }
            }
            return solve(0, 0, cols - 1, grid, memo);
        }

        private int solve(int row, int col1, int col2, int[][] grid, int[][][] memo) {
            if (col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)
                return 0;
            // don't need to compute again if it was computed before
            if (memo[row][col1][col2] != -1)
                return memo[row][col1][col2];
            int result = grid[row][col1];
            if (col1 != col2)
                result += grid[row][col2];
            if (row != grid.length - 1) {
                int max = 0;
                for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                    for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                        max = Math.max(max, solve(row + 1, newCol1, newCol2, grid, memo));
                    }
                }
                result += max;
            }
            return memo[row][col1][col2] = result;
        }
     */

    // Tabulation approach (bottom up)
    // time complexity: O(m*n^2)
    // space complexity: O(m*n^2)
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        // dp[row][col1][col2] represents the maximum cherries two robots can pick up with start positions at (row, col1) and (row, col2) respectively
        int[][][] dp = new int[rows][cols][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < cols; col1++) {
                for (int col2 = 0; col2 < cols; col2++) {
                    int result = grid[row][col1];
                    if (col1 != col2) result += grid[row][col2];
                    if (row != rows - 1) {
                        int max = 0;
                        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                                if (newCol1 < 0 || newCol2 < 0 || newCol1 >= cols || newCol2 >= cols) continue;
                                max = Math.max(max, dp[row + 1][newCol1][newCol2]);
                            }
                        }
                        result += max;
                    }
                    dp[row][col1][col2] = result;
                }
            }
        }
        return dp[0][0][cols - 1];
    }

    public static void main(String[] args) {
        P1463 obj = new P1463();
        int[][] grid = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};
        System.out.println("Expected: 28. Received: " + obj.cherryPickup(grid));
    }
}

// reference
// https://leetcode.com/problems/cherry-pickup-ii/solution/