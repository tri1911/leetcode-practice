package algorithm2.dynamicProgramming;

/**
 * Date: Dec 22, 2021 - Redo on June 16, 2022
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

// TODO: checkout the Manacher's algorithm with O(n) time

public class P5 {
    // time: O(n*n)
    // space: O(n*n)
    public String _longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, beginIndex = 0;
        for (int k = 1; k <= n; k++) {
            for (int start = 0; start <= n - k; start++) {
                int end = start + k - 1;
                boolean bothEndsMatched = s.charAt(start) == s.charAt(end);
                boolean validSub = (start + 1 < end - 1) ? dp[start + 1][end - 1] : true;
                if (bothEndsMatched && validSub) {
                    dp[start][end] = true;
                    maxLen = k;
                    beginIndex = start;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    // time: O(n*n)
    // space: O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        P5 p = new P5();
        System.out.println("-----------------------------------");
        System.out.println("Input: s = babad. Expect: bab");
        System.out.println("Output: " + p.longestPalindrome("babad"));
        System.out.println("-----------------------------------");
        System.out.println("Input: s = cbbd. Expect: bb");
        System.out.println("Output: " + p.longestPalindrome("cbbd"));
    }
}

/**
 * references
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 */