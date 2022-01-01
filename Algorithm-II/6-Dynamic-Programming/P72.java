package algorithm2.dynamicProgramming;

// date: Dec 24, 2021
// 72. Edit Distance
// https://leetcode.com/problems/edit-distance/

public class P72 {
    // time complexity: O(m*n)
    // space complexity: O(m*n)
    public int minDistance(String word1, String word2) {
        // assume we want to find the min number of operations required
        // to convert word1[i...] to word2[j...] -> we call solve(i, j)
        // we examine the first character of each string
        // if they are equal, we don't need to do anything:
        //    solve(i, j) = solve(i + 1, j + 1)
        // else we have 3 choices
        //    insert: solve(i, j) = 1 + solve(i, j + 1)
        //    delete: solve(i, j) = 1 + solve(i + 1, j)
        //    replace: solve(i, j) = 1 + solve(i + 1, j + 1)
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                if (i == len1 || j == len2)
                    dp[i][j] = (i == len1) ? len2 - j : len1 - i;
                else
                    dp[i][j] = word1.charAt(i) == word2.charAt(j)
                            ? dp[i + 1][j + 1]
                            : 1 + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1]));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        P72 p = new P72();
        System.out.println("----------------------------");
        System.out.println("Input: word1 = `horse`, word2 = `ros`");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.minDistance("horse", "ros"));
        System.out.println("----------------------------");
        System.out.println("Input: word1 = `intention`, word2 = `execution`");
        System.out.println("Expect: 5");
        System.out.println("Output: " + p.minDistance("intention", "execution"));
    }
}
