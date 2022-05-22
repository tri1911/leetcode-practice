package others;

/**
 * Date: May 21, 2022
 * 908. Smallest Range I
 * https://leetcode.com/problems/smallest-range-i/
 */

public class P908 {
    // time: O(n)
    // space: O(1)
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int dif = max - min;
        return dif > 2 * k ? dif - 2 * k : 0;
    }
}
