// Date: Sat, Oct 2, 2021
// Redo (Already did in Dynamic Programming I)
// 121. Best Time to Buy and Sell Stock (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

// dynamic programming approach
// time complexity: O(n)
// space complexity: O(1)
int maxProfit(vector<int>& prices) {
	int n = prices.size();
	if (n < 2) 
		return 0;
	int min_buy = prices[0], ans = 0;
	for (int i = 1; i < n; i++) {
		// update the min_buy til ith index
		min_buy = min(min_buy, prices[i]);
		// update the max profit by comparing the current max to current price - min_buy
		// the profit from selling on ith day to the day having min price is at least 0 (in case the current day is the min)
		ans = max(ans, prices[i] - min_buy);
	}
	return ans;
}