package others;

import java.util.ArrayDeque;

/**
 * Date: Jan 23, 2022
 * 1081. Smallest Subsequence of Distinct Characters (similar to Problem 316)
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

public class P1081 {
    // time: O(n) - each character is pushed and pop at most once
    // space: O(1) - note that the size of extra array, stack are always at most 26
    public String smallestSubsequence(String s) {
        int n = s.length();
        // records the last occurrence index of every distinct characters in string s
        int[] lastOccurrenceIndex = new int[26];
        for (int i = 0; i < n; i++)
            lastOccurrenceIndex[s.charAt(i) - 'a'] = i;
        // stack contains characters in result string
        ArrayDeque<Character> stack = new ArrayDeque<>();
        // array to keep track which character is already included in stack
        boolean[] isAdded = new boolean[26];
        // iterate through each character in string s to update the characters in stack
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            // if the current character is added to stack, then ignore it
            if (isAdded[current - 'a']) continue;
            // otherwise, the current character is not added into stack yet, then add it
            // consider to pop top element in stack (the most recently added character)
            // 1. greater than the value of currently checking character
            // 2. and the top element may occur again later
            // we pop that top element out of the stack
            while (!stack.isEmpty() && stack.peek() > current && i < lastOccurrenceIndex[stack.peek() - 'a'])
                isAdded[stack.pop() - 'a'] = false;
            stack.push(current);
            isAdded[current - 'a'] = true;
        }
        // build the result string from stack
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) sb.append(ch);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        P1081 obj = new P1081();
        System.out.println("Expected: abc. Received: " + obj.smallestSubsequence("bcabc"));
        System.out.println("Expected: acdb. Received: " + obj.smallestSubsequence("cbacdcbc"));
    }
}

/**
 * reference
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/discuss/308210/JavaC%2B%2BPython-Stack-Solution-O(N)
 * https://www.youtube.com/watch?v=muDlIlVE1q4
 */