package others;

import java.util.ArrayDeque;

/**
 * Date: Jan 23, 2022
 * Remove Duplicate Letters (is the same as Problem 1081)
 * https://leetcode.com/problems/remove-duplicate-letters/
 */

public class P316 {
    // time: O(n)
    // space: O(1)
    public String removeDuplicateLetters(String s) {
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

    public static void main(String[] args) {
        P316 obj = new P316();
        System.out.println("Expected: abc. Received: " + obj.removeDuplicateLetters("bcabc"));
        System.out.println("Expected: acdb. Received: " + obj.removeDuplicateLetters("cbacdcbc"));
    }
}
