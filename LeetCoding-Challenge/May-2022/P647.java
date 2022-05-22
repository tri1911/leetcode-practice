package leetcodingchallenge.may2022;

/**
 * Date: May 22, 2022
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 */

// TODO: find out the more optimal solution

public class P647 {
    // first attempt
    // time: O(n^2)
    // space: O(1)
    public int _countSubstrings(String s) {
        int n = s.length(), ans = 0;
        boolean[][] dp = new boolean[n][n];
        // outer loop: O(n)
        for (int k = 1; k <= n; k++) {
            // inner loop: O(n)
            for (int first = 0; first <= n - k; first++) {
                int last = first + k - 1;
                // reduce the palindrome check to O(1)
                boolean bothEndMatched = s.charAt(first) == s.charAt(last);
                if (k == 1) dp[first][last] = true;
                else if (k == 2) dp[first][last] = bothEndMatched;
                else dp[first][last] = bothEndMatched && dp[first + 1][last - 1];
                if (dp[first][last]) ans++;
            }
        }
        return ans;
    }

    // redo with another approach which skips non-valid cases
    public int countSubstrings(String s) {
        int n = s.length(), first, last, ans = 0;
        // character at ith index is the center of the palindrome substring
        // expand the substring from this center character
        // check palindrome validacity from the previous one
        for (int i = 0; i < n; i++) {
            // even length
            first = i;
            last = i + 1;
            while (first >= 0 && last < n && s.charAt(first--) == s.charAt(last++)) ans++;
            // odd length
            first = last = i;
            while (first >= 0 && last < n && s.charAt(first--) == s.charAt(last++)) ans++;
        }
        return ans;
    }
}

/*  0ms runtime model solution
    public int countSubstrings(String S) {
        int len = S.length(), ans = 0;
        for (int i = 0; i < len; i++) {
            int j = i - 1, k = i;
            while (k < len - 1 && S.charAt(k) == S.charAt(k+1)) k++;
            ans += (k - j) * (k - j + 1) / 2;
            i = k++;
            while (j >= 0 && k < len && S.charAt(k++) == S.charAt(j--)) ans++;
        }
        return ans;
    }
 */
