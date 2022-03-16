package leetcodingchallenge.march2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: March 16, 2022
 * 946. Validate Stack Sequences
 * https://leetcode.com/problems/validate-stack-sequences/
 */

public class P946 {
    // time & space: O(n)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 0;
        for (int val : pushed) {
            stack.push(val);
            while (!stack.isEmpty() && stack.peek() == popped[current]) {
                stack.pop();
                current++;
            }
        }
        return current == pushed.length;
    }

    public static void main(String[] args) {
        P946 obj = new P946();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println("Expected: true. Received: " + obj.validateStackSequences(pushed, popped));
        System.out.println("---");
        popped = new int[]{4, 3, 5, 1, 2};
        System.out.println("Expected: false. Received: " + obj.validateStackSequences(pushed, popped));
    }
}

/**
 * reference
 * https://leetcode.com/problems/validate-stack-sequences/solution/
 */