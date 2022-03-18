package others;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: Jan 23, 2022 - Redo on March 18, 2022 (Leetcode daily challenge)
 * Remove Duplicate Letters (is the same as Problem 1081)
 * https://leetcode.com/problems/remove-duplicate-letters/
 */

public class P316 {
    // time: O(n)
    // space: O(1)
    public String _removeDuplicateLetters(String s) {
        int[] lastOccur = new int[26];
        for (int i = 0; i < s.length(); i++) lastOccur[s.charAt(i) - 'a'] = i;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] isAdded = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if (isAdded[val]) continue;
            while (!stack.isEmpty() && stack.peek() > val && i < lastOccur[stack.peek()]) isAdded[stack.pop()] = false;
            stack.push(val);
            isAdded[val] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int val : stack)
            sb.append((char) (val + 'a'));
        return sb.reverse().toString();
    }

    // redo
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        // find the last occurrence of characters within s
        int[] lastIdx = new int[26];
        for (int i = 0; i < n; i++) lastIdx[s.charAt(i) - 'a'] = i;
        // keep track whether a character was added into the solution
        boolean[] added = new boolean[26];
        // use stack to store valid characters til ith
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            if (!added[cur]) {
                while (!stack.isEmpty() && stack.peek() > cur && lastIdx[stack.peek()] > i) added[stack.pop()] = false;
                stack.push(cur);
                added[cur] = true;
            }
        }
        // make solution from result stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append((char) (stack.pollLast() + 'a'));
        return sb.toString();
    }

    public static void main(String[] args) {
        P316 obj = new P316();
        System.out.println("Expected: abc. Received: " + obj.removeDuplicateLetters("bcabc"));
        System.out.println("Expected: acdb. Received: " + obj.removeDuplicateLetters("cbacdcbc"));
    }
}
