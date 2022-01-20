package leetcodingchallenge.january2022;

// Date: Jan 5, 2022
// https://leetcode.com/problems/palindrome-partitioning/
// 131. Palindrome Partitioning

import java.util.ArrayList;
import java.util.List;

// TODO: review the time complexity calculation

public class P131 {
    // backtracking & dynamic programming approach
    // time complexity: O(n * 2^n)
    // space complexity: O(n^2)
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        decomposeString(s, 0, new ArrayList<>(), ans, isPalindrome);
        return ans;
    }

    private void decomposeString(String s, int start, List<String> current, List<List<String>> ans, boolean[][] isPalindrome) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(current));
        } else {
            for (int end = start; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                    // add the valid palindrome substring into the current list
                    current.add(s.substring(start, end + 1));
                    // recursive call on the rest of string
                    decomposeString(s, end + 1, current, ans, isPalindrome);
                    // replace the last valid substring with another possible valid substring
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}

// reference
// https://leetcode.com/problems/palindrome-partitioning/solution/
// https://www.youtube.com/watch?v=4ykBXGbonlA
// https://leetcode.com/problems/palindrome-partitioning/discuss/1667494/Daily-LeetCoding-Challenge-January-Day-5

/*  separate palindrome checking implementation
    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];
    // find palindrome substrings - which takes O(n^2)
    // isPalindrome[i][j] = true if isPalindrome[i+1][j-1] = true && s[i] == s[j]
    for (int k = 1; k <= n; k++) {
        for (int first = 0; first <= n - k; first++) {
            int last = first + k - 1;
            char ch1 = s.charAt(first);
            char ch2 = s.charAt(last);
            if (k <= 2) {
                isPalindrome[first][last] = ch1 == ch2;
            } else {
                isPalindrome[first][last] = isPalindrome[first + 1][last - 1] && (ch1 == ch2);
            }
        }
    }
 */