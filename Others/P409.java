package others;

/**
 * Date: Feb 20, 2022
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 */

public class P409 {
    // time: O(n)
    // space: O(1)
    public int longestPalindrome(String s) {
        int[] counter = new int[128];
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (++counter[ch] == 2) {
                ans += 2;
                counter[ch] = 0;
            }
        }
        return ans != s.length() ? ans + 1 : ans;
    }
}
