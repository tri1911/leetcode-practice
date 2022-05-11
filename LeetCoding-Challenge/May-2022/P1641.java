package leetcodingchallenge.may2022;

/**
 * Date: May 11, 2022
 * 1641. Count Sorted Vowel Strings
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 */

// TODO: analyze time complexity + implements bottom-up approach (dynamic programming)

public class P1641 {
    // I firstly try using recursive approach
    // however, calculates overlapping cases is redundant
    // so, optimize by using dynamic programming to cache results

    /*  recursive approach
        public int countVowelStrings(int n) {
            int ans = 0;
            for (int current = 1; current <= 5; current++) {
                ans += backtracking(current, n - 1);
            }
            return ans;
        }

        private int backtracking(int current, int n) {
            if (n == 0) return 1;
            int sum = 0;
            for (int next = current; next <= 5; next++) {
                sum += backtracking(next, n - 1);
            }
            return sum;
        }
     */

    // memoization (top-down) approach
    public int countVowelStrings(int n) {
        int ans = 0;
        int[][] memo = new int[6][n + 1];
        for (int current = 1; current <= 5; current++) {
            ans += backtracking(current, n - 1, memo);
        }
        return ans;
    }

    private int backtracking(int current, int n, int[][] memo) {
        if (n == 0) return 1;
        if (memo[current][n] > 0) return memo[current][n];
        int sum = 0;
        for (int next = current; next <= 5; next++) {
            sum += backtracking(next, n - 1, memo);
        }
        return memo[current][n] = sum;
    }

    public static void main(String[] args) {
        P1641 obj = new P1641();
        System.out.println("Expected: 5. Received: " + obj.countVowelStrings(1));
        System.out.println("Expected: 15. Received: " + obj.countVowelStrings(2));
        System.out.println("Expected: 35. Received: " + obj.countVowelStrings(3));
    }
}

/**
 * references
 * https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918498/JavaC%2B%2BPython-DP-O(1)-Time-and-Space
 */