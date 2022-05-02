package leetcodingchallenge.may2022;

/**
 * Date: May 02, 2022
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 */

public class P905 {
    // first attempt
    // time: O(n)
    // space: O(1)
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 != 0) right--;
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }
}

/**
 * references
 * https://leetcode.com/problems/sort-array-by-parity/solution/
 */