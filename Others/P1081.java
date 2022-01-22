package others;

import java.util.ArrayDeque;

/**
 * Date: Jan 22, 2022
 * 1081. Smallest Subsequence of Distinct Characters
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

public class P1081 {
    public String smallestSubsequence(String s) {
        int n = s.length();
        // stack contains characters for result
        ArrayDeque<Character> stack = new ArrayDeque<>();
        // records the last occurrence of distinct characters in string s
        int[] lastSeen = new int[26];
        for (int i = 0; i < n; i++)
            lastSeen[s.charAt(i) - 'a'] = i;

        for (int i = 0; i < n; i++) {
            int value = s.charAt(i) - 'a';
            // character at stack top < its lastSeen - indicates it will occur later
        }

        return "";
        // bca b
    }
}

/**
 * reference
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/discuss/308210/JavaC%2B%2BPython-Stack-Solution-O(N)
 * https://www.youtube.com/watch?v=muDlIlVE1q4
 */