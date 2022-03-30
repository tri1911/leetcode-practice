package others;

/**
 * Date: March 29, 2022
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 */

public class P485 {
    // time: O(n)
    // space: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, start = 0;
        while (start < nums.length) {
            while (start < nums.length && nums[start] != 1) start++;
            int end = start;
            while (end < nums.length && nums[end] == 1) end++;
            ans = Math.max(ans, end - start);
            start = end;
        }
        return ans;
    }
}
