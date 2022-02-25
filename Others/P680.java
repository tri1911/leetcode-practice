package others;

/**
 * Date: Feb 25, 2022
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 */

public class P680 {
    // time: O(n)
    // space: O(1)
    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return validPalindrome(s, i, j - 1) || validPalindrome(s, i + 1, j); // takes O(n)
            }
        }
        return true;
    }

    // helper function
    public boolean validPalindrome(String s, int first, int last) {
        while (first < last) {
            if (s.charAt(first++) != s.charAt(last--)) {
                return false;
            }
        }
        return true;
    }
}
