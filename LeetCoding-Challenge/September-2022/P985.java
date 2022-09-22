package leetcodingchallenge.september2022;

/**
 * Date: September 21, 2022
 * 985. Sum of Even Numbers After Queries
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */

public class P985 {
    // time: O(n)
    // space: O(1)
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        nums[queries[0][1]] = nums[queries[0][1]] + queries[0][0];
        int[] ans = new int[queries.length];
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[0] += num;
            }
        }
        for (int i = 1; i < queries.length; i++) {
            int prev = nums[queries[i][1]];
            nums[queries[i][1]] = prev + queries[i][0];
            if (nums[queries[i][1]] % 2 == 0) {
                ans[i] = ans[i - 1] + (prev % 2 == 0 ? queries[i][0] : nums[queries[i][1]]);
            } else {
                ans[i] = ans[i - 1] + (prev % 2 == 0 ? -prev : 0);
            }
        }
        return ans;
    }
}
