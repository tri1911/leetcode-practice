// 121. Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0. 

// Constraints:
// 1 <= prices.length <= 10^5
// 0 <= prices[i] <= 10^4

 int maxProfit(vector<int>& prices) {
 	int n = prices.size();
 	if (n == 1)
 		return 0;
 	int min_buy = prices[0];
 	int current_max = prices[1] - min_buy;
 	int ans = max(0, current_max);
 	for (int i = 2; i < n; i++) {
 		min_buy = min(prices[i - 1], min_buy);
 		current_max = max(0, prices[i] - min_buy);
 		ans = max(ans, current_max);
 	}
 	return ans;
 }