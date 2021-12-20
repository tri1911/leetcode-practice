package algorithm2.binarySearch;

// Date: Dec 13, 2021
// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// time complexity: O(log(n))
// space complexity: O(1)
public class P34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int[] ans = new int[2];
        // find starting position, takes O(log(n))
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target <= nums[mid]) {
                ans[0] = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // does not find target then return [-1, -1]
        if (nums[ans[0]] != target)
            return new int[]{-1, -1};
        // find ending position, takes O(log(n))
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target >= nums[mid]) {
                ans[1] = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}