// 714. Best Time to Buy and Sell Stock with Transaction Fee
// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:
// Input: prices = [1,3,2,8,4,9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// - Buying at prices[0] = 1
// - Selling at prices[3] = 8
// - Buying at prices[4] = 4
// - Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

// Example 2:
// Input: prices = [1,3,7,5,10,3], fee = 3
// Output: 6

// Constraints:
// 1 <= prices.length <= 5 * 10^4
// 1 <= prices[i] < 5 * 10^4
// 0 <= fee < 5 * 10^4

int maxProfit(vector<int>& prices, int fee) {
	int n = prices.size();
	int prev_no_hold = 0;
	int prev_hold = - prices[0];
	int current_no_hold, current_hold;
	for (int i = 1; i < n; i++) {
		current_no_hold = max(prev_no_hold, prev_hold + prices[i] - fee);
		current_hold = max(prev_no_hold - prices[i], prev_hold);
		prev_no_hold = current_no_hold;
		prev_hold = current_hold;
	}
	return prev_no_hold;
}