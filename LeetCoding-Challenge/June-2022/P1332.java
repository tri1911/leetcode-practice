package leetcodingchallenge.june2022;

/**
 * Date: June 08, 2022
 * 1332. Remove Palindromic Subsequences
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */

public class P1332 {
    // observation:
    // if s is palindrome -> just need 1 operation
    // otherwise, need 2 operations (first removing all a's, then all b's at the next one)
    // time: O(n)
    // space: O(1)
    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }

    // helper function
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}

/**
 * references
 * https://leetcode.com/problems/remove-palindromic-subsequences/discuss/490303/JavaC%2B%2BPython-Maximum-2-Operations
 */