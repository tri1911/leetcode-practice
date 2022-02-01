package leetcodingchallenge.february2022;

/**
 * Date: Jan 31, 2022
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class P121 {
    // time: O(n)
    // space: O(1)
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return ans;
    }
}
