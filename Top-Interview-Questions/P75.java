package topInterviewQs;

// Date: Jan 6, 2022
// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/

// TODO: review the solution with one-pass algorithm using only constant extra space

import java.util.Arrays;

public class P75 {
    /*  First Attempt - use counting sort
        // time complexity: O(n)
        // space complexity: O(1)
        public void sortColors(int[] nums) {
            int[] counter = new int[3];
            // count the frequencies - takes O(n) time
            for (int num : nums)
                counter[num]++;
            // override elements in the original array - takes O(n) time
            int i = 0;
            for (int j = 0; j < 3; j++) {
                if (counter[j] > 0) {
                    for (int k = 0; k < counter[j]; k++) {
                        nums[i++] = j;
                    }
                }
            }
        }
     */

    // Dutch national flag problem
    // one-pass and constant extra space
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] > 1) {
                swap(nums, mid, right--);
            } else if (nums[mid] < 1) {
                swap(nums, left++, mid++);
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        P75 obj = new P75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println("Expected: [0, 0, 1, 1, 2, 2]");
        obj.sortColors(nums);
        System.out.println("Received: " + Arrays.toString(nums));
    }
}

// reference
// https://en.wikipedia.org/wiki/Dutch_national_flag_problem