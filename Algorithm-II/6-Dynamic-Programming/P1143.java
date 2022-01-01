package algorithm2.dynamicProgramming;

// date: Dec 23, 2021
// 1143. Longest Common Subsequence
// https://leetcode.com/problems/longest-common-subsequence/

public class P1143 {
    // dynamic programming approach
    // time complexity: O(m*n)
    // space complexity: O(m*n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // dp[i][j] denotes the length of the longest common subsequence of text1[i...] & text2[j...]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];

        /* another implementation
        int m = text1.length(), n = text2.length();
        // dp[i][j] denotes the length of the longest common subsequence
        // of text1[...i - 1] and text2[...j - 1]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = text1.charAt(i - 1) != text2.charAt(j - 1) ?
                            Math.max(dp[i - 1][j], dp[i][j - 1]) :
                            1 + dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
         */
    }

    public static void main(String[] args) {
        P1143 p = new P1143();
        System.out.println("----------------------------");
        System.out.println("Input: text1 = `abcde`, text2 = `ace` ");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.longestCommonSubsequence("abcde", "ace"));
        System.out.println("----------------------------");
        System.out.println("Input: text1 = `abc`, text2 = `abc` ");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.longestCommonSubsequence("abc", "abc"));
    }
}
