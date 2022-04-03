package others;

/**
 * Date: Feb 25, 2022 - Redo on April 01, 2022
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 */

public class P680 {
    // time: O(n)
    // space: O(1)
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return check(s, left, right - 1) || check(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    // helper function (time: O(n))
    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
