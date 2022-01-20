package leetcodingchallenge.january2022;

// Daily Coding Challenge - Jan 1, 2022
// Date: Jan 6, 2022
// 312. Burst Balloons
// https://leetcode.com/problems/burst-balloons/

public class P312 {
    // time complexity: O(n^3)
    // space complexity: O(n^2)
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // padding with 1 at the beginning and end of the original array
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for (int size = 1; size <= n; size++) {
            for (int start = 1; start <= n - size + 1; start++) {
                int end = start + size - 1;
                // assume we burst the ith balloon at the last order
                for (int i = start; i <= end; i++) {
                    // dp[i][j] always be 0 if i < j because we do not update these cells -> do not need to cover these edge cases
                    dp[start][end] = Math.max(dp[start][end], arr[i] * arr[start - 1] * arr[end + 1] + dp[start][i - 1] + dp[i + 1][end]);
                }
            }
        }
        return dp[1][n];
    }
}

// reference
// https://www.youtube.com/watch?v=VFskby7lUbw&t=661s
// https://leetcode.com/problems/burst-balloons/discuss/1659162/JAVA-or-DP-or-Divide-and-Conquer-or-Sliding-Window-or-Detailed-Explanation-Using-Image
// https://www.geeksforgeeks.org/burst-balloon-to-maximize-coins/
// https://leetcode.com/problems/burst-balloons/discuss/76229/For-anyone-that-is-still-confused-after-reading-all-kinds-of-explanations...
