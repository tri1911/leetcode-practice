package topInterviewQs;

// Date: Jan 8, 2022
// 26. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.Arrays;

public class P26 {
    /*  First attempt
        // time complexity: O(n)
        // space complexity: O(1)
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int i = 1, j = 1;
            while (j < n) {
                while (j < n && nums[j] <= nums[i - 1]) j++;
                if (j == n) break;
                nums[i++] = nums[j];
            }
            return i;
        }
     */

    // optimized implementation
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // pointer to track the next position to populate the next element
        int current = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1])
                nums[current++] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return current;
    }

    public static void main(String[] args) {
        P26 obj = new P26();
        System.out.println("Expected: 2, nums = [1, 2, _]");
        System.out.println("Received: " + obj.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println("---");
        System.out.println("Expected: 5, nums = [0, 1, 2, 3, 4, _, _, _, _, _]");
        System.out.println("Received: " + obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
