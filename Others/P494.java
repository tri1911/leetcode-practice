package others;

/**
 * Date: Jan 13, 2022
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 */

// TODO: check out the official solution

public class P494 {

    /*  Observation: the problem can be thought as:
        count the number of ways to divide nums into 2 subsets such that their difference equals `target`
        sum1 - sum2 = target => sum1 - (total - sum1) = target
        therefore, sum1 = (target + total) / 2
        problem becomes count the subsets having sum = (target + total) / 2
     */

    // dynamic programming
    // time complexity: O(n * t) where t is total value of elements
    // space complexity: O(n * t)
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, total = 0;
        for (int num : nums) total += num;
        if (target > total || total + target < 0 || (total + target) % 2 != 0) return 0; // edge case
        target = (total + target) / 2;
        // dp[i][j] denotes the number of subsets having target sum j in the set with size i (include elements from index 0 to i - 1)
        int[][] dp = new int[n + 1][target + 1];
        for (int sum = 0; sum <= target; sum++) {
            for (int size = 0; size <= n; size++) {
                // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]
                // excludes or includes the last element
                if (size == 0) dp[size][sum] = sum == 0 ? 1 : 0;
                else
                    dp[size][sum] = dp[size - 1][sum] + (nums[size - 1] > sum ? 0 : dp[size - 1][sum - nums[size - 1]]);
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        P494 obj = new P494();
        System.out.println("Expected: 5. Received: " + obj.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("Expected: 1. Received: " + obj.findTargetSumWays(new int[]{1}, 1));
        System.out.println("Expected: 256. Received: " + obj.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
        System.out.println("Expected: 0. Received: " + obj.findTargetSumWays(new int[]{7, 9, 3, 8, 0, 2, 4, 8, 3, 9}, 0));
        System.out.println("Expected: _. Received: " + obj.findTargetSumWays(new int[]{100}, -200));
    }
}

/*
    Constraints:
    1 <= nums.length <= 20
    0 <= nums[i] <= 1000
    0 <= sum(nums[i]) <= 1000
    -1000 <= target <= 1000
 */

/**
 * reference
 * https://leetcode.com/problems/target-sum/solution/
 * https://www.youtube.com/watch?v=hqGa65Rp5LQ
 */