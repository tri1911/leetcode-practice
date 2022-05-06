package leetcodingchallenge.may2022;

import javafx.util.Pair;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: May 06, 2022
 * 1209. Remove All Adjacent Duplicates in String II
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */

public class P1209 {
    // first attempt using Stack
    // time: O(n)
    // space: O(n)
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        // iterate through characters and populate the stack - takes O(n) time
        for (char ch : s.toCharArray()) {
            Pair<Character, Integer> top = stack.isEmpty() ? null : stack.peek();
            if (top == null || ch != top.getKey()) {
                stack.push(new Pair<>(ch, 1));
            } else {
                int count = top.getValue();
                stack.pop();
                if (count + 1 < k) {
                    stack.push(new Pair<>(ch, count + 1));
                }
            }
        }
        // compose the String solution - takes O(n) time
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> pair = stack.removeLast();
            for (int i = 0; i < pair.getValue(); i++) {
                sb.append(pair.getKey());
            }
        }
        return sb.toString();
    }

    // TODO: implement better solution
    public String _removeDuplicates(String s, int k) {
        return "";
    }
}
