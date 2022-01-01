package algorithm2.dynamicProgramming;

// date: Dec 22, 2021
// 5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/

// TODO: checkout Leetcode's solution at https://leetcode.com/problems/longest-palindromic-substring/solution/

public class P5 {
    // time complexity: O(n*n)
    // space complexity: O(n*n)
    public String longestPalindrome(String s) {
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
