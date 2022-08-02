package algorithm2.dynamicProgramming;

/**
 * Date: December 27, 2021 - Redo: August 01, 2022 (Leetcode Daily Challenge)
 */

public class P62 {
    /*  recursion approach (Time Limit Exceed)
        public int uniquePaths(int m, int n) {
            return dfs(0, 0, m, n);
        }

        private int dfs(int row, int col, int m, int n) {
            int count = 0;
            if (row == m - 1 && col == n - 1)
                return 1;
            if (row < m - 1) count += dfs(row + 1, col, m, n);
            if (col < n - 1) count += dfs(row, col + 1, m, n);
            return count;
        }
     */

    // dynamic programming -> solve overlapped sub-problems exist in recursion approach
    // time: O(m*n)
    // space: O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        P62 p = new P62();
        System.out.println("-----------------------------------");
        System.out.println("Input: m = 3, n = 7 -> Expect: 28");
        System.out.println("Output: " + p.uniquePaths(3, 7));
        System.out.println("-----------------------------------");
        System.out.println("Input: m = 3, n = 2 -> Expect: 3");
        System.out.println("Output: " + p.uniquePaths(3, 2));
        System.out.println("-----------------------------------");
        System.out.println("Input: m = 51, n = 9 -> Expect: 1916797311");
        System.out.println("Output: " + p.uniquePaths(51, 9));
    }
}