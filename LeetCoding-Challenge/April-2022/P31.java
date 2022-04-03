package leetcodingchallenge.april2022;

/**
 * Date: April 03, 2022
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 */

public class P31 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public void nextPermutation(int[] nums) {
        // observation through an example: 1432 -> 2134
        // we can see for the part 432, we can't find the greater one
        // at the first index, we can replace it with the immediate greater (which is 2)

        // algorithm:
        // determine the index i such that nums[i] > nums[i - 1]
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        // inverse nums[i...n-1]
        int first = i, last = nums.length - 1;
        while (first < last) swap(nums, first++, last--);
        // swap the number at index of `i - 1` with the immediate greater than it (if needed)
        if (i == 0) return;
        // find the immediate greater
        int j = i;
        while (nums[j] <= nums[i - 1]) j++;
        // swap
        swap(nums, i - 1, j);
    }

    // helper function - time: O(1)
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * reference
 * https://leetcode.com/problems/next-permutation/solution/
 */