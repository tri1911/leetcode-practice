package leetcodingchallenge.march2022;

/**
 * Date: March 28, 2022
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */

public class P81 {
    // time:
    // space:
    public boolean search(int[] nums, int target) {
        for (int num : nums) if (target == num) return true;
        return false;
    }

    public static void main(String[] args) {
        P81 obj = new P81();
        System.out.println("Expected: true. Received: " + obj.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println("Expected: false. Received: " + obj.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}

/**
 * reference
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solution/
 */
