package algorithm2.dynamicProgramming;

/**
 * Date: Dec 23, 2021
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */

public class P300 {
    /* time complexity: O(n*n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
     */

    // TODO: check out the better approach (with time O(nlog(n) using Patience Sorting)
    public int lengthOfLIS(int[] nums) {
        return 1;
    }

    public static void main(String[] args) {
        P300 p = new P300();
        System.out.println("------------------------");
        System.out.println("Input: nums = [10, 9, 2, 5, 3, 7, 101, 18]");
        System.out.println("Expect: 4");
        System.out.println("Output: " + p.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println("------------------------");
        System.out.println("Input: nums = [0, 1, 0, 3, 2, 3]");
        System.out.println("Expect: 4");
        System.out.println("Output: " + p.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println("------------------------");
        System.out.println("Input: nums = [7, 7, 7, 7, 7, 7, 7]");
        System.out.println("Expect: 1");
        System.out.println("Output: " + p.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}

/**
 * References
 * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
 * https://www.youtube.com/watch?v=22s1xxRvy28
 * https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
 */