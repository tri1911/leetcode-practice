// 309. Best Time to Buy and Sell Stock with Cooldown

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:
// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]

// Example 2:
// Input: prices = [1]
// Output: 0

// Constraints:
// 1 <= prices.length <= 5000
// 0 <= prices[i] <= 1000

// solution with good explanation
// http://leetcode.libaoj.in/best-time-to-buy-and-sell-stock-with-cooldown.html

int maxProfit(vector<int> &prices) {
    int n = prices.size();
    if (n == 1)
        return 0;
    // info at index = 1
    int previous_sell = prices[1] - prices[0];
    int previous_hold = -min(prices[0], prices[1]);
    int previous_empty = 0;
    int current_sell, current_hold, current_empty;
    for (int i = 2; i < n; i++) {
        current_sell = previous_hold + prices[i];
        current_hold = max(previous_hold, previous_empty - prices[i]);
        current_empty = max(previous_empty, previous_sell);
        previous_sell = current_sell;
        previous_hold = current_hold;
        previous_empty = current_empty;
    }
    return max(previous_sell, previous_empty);
}