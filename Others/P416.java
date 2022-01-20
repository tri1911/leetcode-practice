package others;

/**
 * Date: Jan 13, 2022
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */

/*  Observation
    let the sum of elements in 2 partitioned subsets sum1 and sum2 respectively
    sum1 = sum2 -> sum1 = total / 2
    this problem can be rephrased `find the subset have the sum equals total / 2`
    similar to knapsack problem
 */

public class P416 {
    // dynamic programming - bottom up approach
    // time: O(n * t) where t is the total value of the nums array
    // space: O(n * t)
    public boolean canPartition(int[] nums) {
        int n = nums.length, total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        boolean[][] dp = new boolean[n + 1][total / 2 + 1];
        for (int sum = 0; sum <= total / 2; sum++) {
            for (int size = 0; size <= n; size++) {
                if (size == 0) dp[size][sum] = sum == 0 ? true : false;
                else
                    dp[size][sum] = dp[size - 1][sum] || (nums[size - 1] > sum ? false : dp[size - 1][sum - nums[size - 1]]);
            }
        }
        return dp[n][total / 2];
    }
}
