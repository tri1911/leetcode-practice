package leetcodingchallenge.march2022;

/**
 * Date: March 26, 2022
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 */

public class P704 {
    // time: O(log(n))
    // space: O(1)
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
