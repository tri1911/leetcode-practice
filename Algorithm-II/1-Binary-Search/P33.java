package algorithm2.binarySearch;

// date: Dec 13, 2021
// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/

// time complexity: O(log(n))
// space complexity: O(1)
public class P33 {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            // found target
            if (nums[mid] == target)
                return mid;
            // left part is sorted
            if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else { // otherwise, right part is sorted
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.println("Expected: 1. Received: " + search(nums, 1));
    }
}
