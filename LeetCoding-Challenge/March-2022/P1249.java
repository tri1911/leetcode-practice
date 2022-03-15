package leetcodingchallenge.march2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: March 15, 2022
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */

public class P1249 {
    // own solution
    // time: O(n)
    // space: O(n)
    public String _minRemoveToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int openCount = 0;
        // the key is keeping openCount at the value of 0
        for (char ch : s.toCharArray()) {
            if (ch == '(') openCount++;
            else if (ch == ')') {
                if (openCount == 0) continue;
                else openCount--;
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            if (openCount > 0 && ch == '(') openCount--;
            else sb.append(ch);
        }
        return sb.reverse().toString();
    }

    // another approach (reference)
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>(); // contains indices of `(` need to be removed
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(') stack.push(i);
            else if (ch == ')') {
                if (!stack.isEmpty()) stack.pop();
                else sb.setCharAt(i, '*'); // ')' at ith index is invalid => set as placeholder for being removed
            }
        }
        while (!stack.isEmpty()) sb.setCharAt(stack.pop(), '*'); // set redundant '(' at ith index as placeholder for being removed
        return sb.toString().replaceAll("\\*", "");
    }
}

/**
 * reference
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/discuss/419402/JavaC%2B%2B-Stack
 */