package algorithm2.binarySearch;

// date: Dec 13, 2021
// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// time complexity: O(log(n))
// space complexity: O(1)
public class P153 {
    public static int findMin(int[] nums) {
        int first = nums[0];
        if (nums.length == 1)
            return first;
        if (first < nums[nums.length - 1])
            return first;
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] > first) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Expect: 1. Received: " + findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println("Expect: 0. Received: " + findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println("Expect: 11. Received: " + findMin(new int[]{11, 13, 15, 17}));
        System.out.println("Expect: 1. Received: " + findMin(new int[]{2, 1}));
        System.out.println("Expect: 1. Received: " + findMin(new int[]{3, 4, 5, 6, 1, 2}));
    }
}

// reference
// https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/?ref=lbp