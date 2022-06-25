package leetcodingchallenge.june2022;

/**
 * Date: June 25, 2022
 * 665. Non-decreasing Array
 * https://leetcode.com/problems/non-decreasing-array/
 */

public class P665 {
    // time: O(n)
    // space: O(1)
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                if (++count > 1) return false;
                if (i - 2 < 0 || nums[i] >= nums[i - 2]) continue;
                else nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}

/**
 * references
 * https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation
 */