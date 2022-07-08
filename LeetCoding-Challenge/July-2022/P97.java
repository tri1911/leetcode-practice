package leetcodingchallenge.july2022;

/**
 * Date: July 07, 2022
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 */

// TODO: learn the official solution (memoization + dp approaches)

public class P97 {
    // approach 1: brute force
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return helper(s1, 0, s2, 0, "", s3);
    }

    private boolean helper(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length()) return true;
        System.out.println("res: " + res);
        boolean ans = false;
        if (i < s1.length())
            ans |= helper(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            ans |= helper(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;
    }
}

/**
 * references
 * https://leetcode.com/problems/interleaving-string/solution/
 */