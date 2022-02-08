package leetcodingchallenge.february2022;

/**
 * Date: Feb 7, 2022
 * 389. Find the Difference
 * https://leetcode.com/problems/find-the-difference/
 */

public class P389 {
    // first attempt
    // time: O(n)
    // space: O(1)
    public char _findTheDifference(String s, String t) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray())
            counter[ch - 'a']++;
        for (char ch : t.toCharArray())
            if (--counter[ch - 'a'] < 0) return ch;
        return ' ';
    }

    // smart, optimized solution
    public char findTheDifference(String s, String t) {
        int val = t.charAt(s.length());
        for (int i = 0; i < s.length(); i++) {
            val -= s.charAt(i);
            val += t.charAt(i);
            // OR
            // val ^= s.charAt(i);
            // val ^= t.charAt(i);
        }
        return (char) val;
    }
}

/**
 * reference
 * https://leetcode.com/problems/find-the-difference/discuss/86850/Simple-JAVA-8ms-solution-4-lines
 */
