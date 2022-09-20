package leetcodingchallenge.september2022;

/**
 * Date: September 20, 2022
 * 718. Maximum Length of Repeated Subarray
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */

public class P718 {
    // dynamic programming
    // time: O(mn)
    // space: O(mn)
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, ans = 0;
        // dp[i][j] = the max length of common postfix of nums1[:i] and nums2[:j]
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = i == 0 || j == 0 ? 1 : dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}

/**
 * References
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/solution/
 */