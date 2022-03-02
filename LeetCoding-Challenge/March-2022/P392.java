package leetcodingchallenge.march2022;

/**
 * Date: March 02, 2022
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */

public class P392 {
    // time: O(n)
    // space: O(1)
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n1 > n2) return false;
        int p1 = 0, p2 = 0;
        while (p1 < n1 && p2 < n2) p1 += s.charAt(p1) == t.charAt(p2++) ? 1 : 0;
        return p1 == n1;
    }
}
