package leetcodingchallenge.january2022;

/**
 * Date: Jan 30, 2022
 * 1672. Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/
 */

public class P1672 {
    // time: O(mn)
    // space: O(1)
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
