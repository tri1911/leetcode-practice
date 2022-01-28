package others;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Date: Jan 26, 2022
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 */

// TODO: read the official solution if have time (and post solution to discuss if can)

public class P503 {
    // own solution
    // time: O(n)
    // space: O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 2; i >= 0; i--)
            stack.push(nums[i]);
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        P503 obj = new P503();
        System.out.println("Expected: [2, -1, 2]. Received: " + Arrays.toString(obj.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println("Expected: [2, 3, 4, -1, 4]. Received: " + Arrays.toString(obj.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}

/**
 * reference
 * https://leetcode.com/problems/next-greater-element-ii/solution
 */
