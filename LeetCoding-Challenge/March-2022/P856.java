package leetcodingchallenge.march2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: March 17, 2022
 * 856. Score of Parentheses
 * https://leetcode.com/problems/score-of-parentheses/
 */

public class P856 {
    // own solution
    // time & space: O(n)
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            // since the max value between a balanced parentheses is 2^24
            // I choose `Integer.MAX_VALUE` as a boundary value
            if (ch == '(') {
                stack.push(Integer.MAX_VALUE);
            } else {
                int computedVal = 0;
                while (stack.peek() != Integer.MAX_VALUE) computedVal += stack.pop();
                stack.pop();
                stack.push(computedVal == 0 ? 1 : 2 * computedVal);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) ans += stack.pop();
        return ans;
    }

    // TODO: read official solution

    public static void main(String[] args) {
        P856 obj = new P856();
        System.out.println("Expected: 1. Received: " + obj.scoreOfParentheses("()"));
        System.out.println("Expected: 2. Received: " + obj.scoreOfParentheses("(())"));
        System.out.println("Expected: 2. Received: " + obj.scoreOfParentheses("()()"));
        System.out.println("Expected: 6. Received: " + obj.scoreOfParentheses("(()(()))"));
    }
}

/**
 * reference
 * https://leetcode.com/problems/score-of-parentheses/solution/
 */
