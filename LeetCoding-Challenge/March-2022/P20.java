package leetcodingchallenge.march2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: March 13, 2022
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */

public class P20 {
    // time: O(n)
    // space: O(1)
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }
        return stack.isEmpty();
    }
}
