package algorithm2.dynamicProgramming;

// date: Dec 21, 2021
// 213. House Robber II
// https://leetcode.com/problems/house-robber-ii/

public class P213 {
    /* Recursive & Memoization solutions
        // recursive approach -> overlapped sub-problems
        public int _rob(int[] nums) { return solve(nums, 0, nums.length - 1); }

        // memoization approach
        // time complexity: _
        // space complexity: O(n*n)
        public int rob(int[] nums) {
            int n = nums.length;
            int[][] memo = new int[n][n];
            return solve(nums, 0, nums.length - 1, memo);
        }

        private int solve(int[] nums, int first, int last, int[][] memo) {
            if (first > last)
                return 0;
            if (memo[first][last] != 0)
                return memo[first][last];
            // System.out.println("first: " + first + " & last: " + last);
            return memo[first][last] = Math.max(nums[first] + solve(nums, first + 2, last - 1, memo), solve(nums, first + 1, last, memo));
        }
     */

    // dynamic programming approach
    // time complexity: O(n)
    // space complexity: O(1)
    public int rob(int[] nums) {
        if (nums.length == 1) // edge case
            return nums[0];
        return Math.max(solve(nums, 0, nums.length - 2), solve(nums, 1, nums.length - 1));
    }

    public int solve(int[] nums, int first, int last) {
        // records the maximum value for including & excluding the nums[i]
        int include = 0, exclude = 0;
        int result = 0;
        for (int i = first; i <= last; i++) {
            // update the solution for the range [0, i] based on the last state
            result = Math.max(nums[i] + exclude, include);
            // update the current state for being used in the next round
            exclude = include;
            include = result;
        }
        return result;
    }

    public static void main(String[] args) {
        P213 p = new P213();
        System.out.println("Input: nums = [2, 3, 2]");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.rob(new int[]{2, 3, 2}));
        System.out.println("--------------------------");
        System.out.println("Input: nums = [1, 2, 3, 1]");
        System.out.println("Expect: 4");
        System.out.println("Output: " + p.rob(new int[]{1, 2, 3, 1}));
        System.out.println("--------------------------");
        System.out.println("Input: nums = [1, 2, 3]");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.rob(new int[]{1, 2, 3}));
        System.out.println("--------------------------");
        System.out.println("Input: nums = [3]");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.rob(new int[]{3}));
    }
}
