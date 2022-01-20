package others;

import java.util.Arrays;

/**
 * Date: Jan 13, 2022
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 */

// TODO: review the official solution

public class P27 {
    // time: O(n)
    // space: O(1)
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) nums[i] = nums[--n];
            else i++;
        }
        return n;
    }

    /*  two pointers approach (my own implementation)
        int n = nums.length;
        if (n == 0) return 0;
        int left = 0, right = n - 1;
        while (left < right) {
            // we may not need to swap just assign the value at the end to it
            if (nums[left] == val && nums[right] != val) swap(nums, left, right);
            if (nums[left] != val) left++;
            if (nums[right] == val) right--;
        }
        System.out.println(Arrays.toString(nums));
        return left + (nums[left] != val ? 1 : 0);
     */

    public static void main(String[] args) {
        P27 obj = new P27();
        System.out.println("Expected: 5. [0, 1, 4, 0, 3, _, _, _]\nReceived: " + obj.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println("---");
        System.out.println("Expected: 2. [2, 2, _, _]\nReceived: " + obj.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println("---");
        System.out.println("Expected: 0. []\nReceived: " + obj.removeElement(new int[]{}, 0));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * reference
 * https://leetcode.com/problems/remove-element/solution/
 */