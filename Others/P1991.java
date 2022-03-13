package others;

/**
 * Date: March 12, 2022
 * 1991. Find the Middle Index in Array
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 */

public class P1991 {
    // time: O(n)
    // space: O(1)
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += i > 0 ? nums[i - 1] : 0;
            if (left == sum - left - nums[i]) return i;
        }
        return -1;
    }
}
