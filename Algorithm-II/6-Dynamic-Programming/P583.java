package algorithm2.dynamicProgramming;

/**
 * Date: Dec 23, 2021 - Redo on Tue, June 14, 2022
 * 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */

// TODO: check out the leetcode solution with space complexity O(n)
// https://leetcode.com/problems/delete-operation-for-two-strings/solution/

public class P583 {
    // recursive approach
    // there exist overlapped sub-problems (does not necessarily resolve everytime revisit them)
    public int _minDistance(String word1, String word2) {
        return helper(0, 0, word1, word2);
    }

    private int helper(int i, int j, String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (i == len1 || j == len2)
            return i == len1 ? len2 - j : len1 - i;
        if (word1.charAt(i) == word2.charAt(j))
            return helper(i + 1, j + 1, word1, word2);
        return 1 + Math.min(helper(i + 1, j, word1, word2), helper(i, j + 1, word1, word2));
    }

    // optimized solution using dynamic programming
    // time complexity: O(m*n)
    // space complexity: O(m*n)
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        // dp[i][j] denotes the minimum number of steps required
        // to make word1[i...] and word2[j...] the same
        int[][] dp = new int[len1 + 1][len2 + 1];
        // bottom-right to top-left
        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                if (i == len1 || j == len2)
                    dp[i][j] = i == len1 ? len2 - j : len1 - i;
                else
                    dp[i][j] = word1.charAt(i) != word2.charAt(j) ? 1 + Math.min(dp[i + 1][j], dp[i][j + 1]) : dp[i + 1][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        P583 p = new P583();
        System.out.println("------------------------------");
        System.out.println("Input: word1 = `sea`, word2 = `eat`");
        System.out.println("Expect: 2");
        System.out.println("Output: " + p.minDistance("sea", "eat"));
        System.out.println("------------------------------");
        System.out.println("Input: word1 = `leetcode`, word2 = `etco`");
        System.out.println("Expect: 4");
        System.out.println("Output: " + p.minDistance("leetcode", "etco"));
    }
}
