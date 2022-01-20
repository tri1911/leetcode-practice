package others;

/**
 * Date: Jan 13, 2022
 * 650. 2 Keys Keyboard
 * https://leetcode.com/problems/2-keys-keyboard/
 */

// TODO: implement using dynamic programming & re-calculate the time complexity of the below solution

public class P650 {
    // find sum of prime factorizations
    // time complexity: O(sqrt(n))
    // space complexity: O(1)
    public int minSteps(int n) {
        int ans = 0, d = 2;
        // prime factors of n is less than or equal sqrt(n)
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}

/*  dp solution sample
    public int minSteps(int n) {
        // dp[i][j] - min steps required to just get pasted j symbols for number i
        Integer[][] dp = new Integer[n+1][(n+1)];
        // cannot paste more than half
        if (n == 1) return 0;
        if (n == 2) return 2;
        dp[1][1] = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = Integer.MAX_VALUE;
            for (int j = 1; j <= i/2; j++) {
                if (dp[i-j][j] != null) {
                    dp[i][j] = 1+dp[i-j][j];
                    ans = Math.min(ans, dp[i][j]);
                }
            }
            dp[i][i] = ans+1;
        }
        return ans;
    }
 */

/**
 * reference
 * https://leetcode.com/problems/2-keys-keyboard/solution/
 * https://leetcode.com/problems/2-keys-keyboard/discuss/105899/Java-DP-Solution
 */
