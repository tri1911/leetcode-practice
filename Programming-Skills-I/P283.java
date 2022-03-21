package programmingSkills1;

/**
 * Date: March 20, 2022
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */

public class P283 {
    // time: O(n)
    // space: O(1)
    public void moveZeroes(int[] nums) {
        int firstZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[firstZero];
                nums[firstZero++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
