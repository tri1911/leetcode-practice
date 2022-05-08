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
        // determine if there exist: first < third < second
        Deque<Integer> stack = new ArrayDeque<>();
        // valid `third` requires there is at least one element larger than it which is the `second`
        Integer third = null;
        // iterate through the array from back to front
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            // here `current` is the `first` -> uses it to compare with the valid, greatest `third` (if have one)
            if (third != null && current < third) return true;
            // here `current` is the `second` -> uses it to update the greatest, valid `third`
            // the monotonic stack ensures the elements ordered in ascending order -> the last popped element is the greatest `third`
            while (!stack.isEmpty() && stack.peek() < current) third = stack.pop();
            // push the current number into stack (only pushing if its does not appear in the stack OR there is nothing in stack)
            if (stack.isEmpty() || current != stack.peek()) stack.push(current);
        }
        return false;
    }
}

/**
 * references
 * https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C%2B%2B-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation.
 */
