package algorithm2.dynamicProgramming;

// date: Dec 23, 2021
// 139. Word Break
// https://leetcode.com/problems/word-break/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139 {
    // dynamic programming approach
    // time complexity: O(n*n)
    // space complexity: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i + 1; j++) {
                if ((j == 0 || dp[j - 1]) && wordSet.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        P139 p = new P139();
        System.out.println("---------------------");
        System.out.println("Input: s = 'leetcode', wordDict = ['leet', 'code']. Expect: true");
        System.out.println("Output: " + p.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println("---------------------");
        System.out.println("Input: s = 'applepenapple', wordDict = ['apple', 'pen']. Expect: true");
        System.out.println("Output: " + p.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println("---------------------");
        System.out.println("Input: s = 'catsandog', wordDict = ['cats', 'dog', 'sand', 'and', 'cat']. Expect: false");
        System.out.println("Output: " + p.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}

// reference
// https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution