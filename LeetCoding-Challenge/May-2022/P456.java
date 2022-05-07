package leetcodingchallenge.may2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: May 07, 2022
 * 456. 132 Pattern
 * https://leetcode.com/problems/132-pattern/
 */

public class P456 {
    // monotonic stack
    // time: O(n)
    // space: O(n) (can be O(1))
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer third = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            // here current is the first (while third is the greatest valid third)
            if (third != null && current < third) return true;
            // here current is the second
            while (!stack.isEmpty() && stack.peek() < current) third = stack.pop();
            stack.push(current);
        }
        return false;
    }
}

/**
 * references
 * https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C%2B%2B-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation.
 */
