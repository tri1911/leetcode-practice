package leetcodingchallenge.august2022;

/**
 * Date: August 16, 2022 - Already solve it in C++ before
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

public class P387 {
    // time: O(n)
    // space: O(1)
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) counter[ch - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
