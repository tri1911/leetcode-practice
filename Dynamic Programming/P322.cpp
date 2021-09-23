// Date: Wed, Sep 22, 2021
// 322. Coin Change

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.

// Example 1:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:
// Input: coins = [2], amount = 3
// Output: -1

// Example 3:
// Input: coins = [1], amount = 0
// Output: 0

// Example 4:
// Input: coins = [1], amount = 1
// Output: 1

// Example 5:
// Input: coins = [1], amount = 2
// Output: 2

// Constraints:
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2^31 - 1
// 0 <= amount <= 10^4

// recursion approach (inefficient -> Time Limit Exceeded)
// int coinChange(vector<int>& coins, int amount) {
// 	// base case
// 	if (amount == 0) 
// 		return 0;
// 	if (amount < 0)
// 		return -1;
// 	int ans = INT_MAX;
// 	bool isSolved = false;
// 	for (int coin: coins) {
// 		int result = coinChange(coins, amount - coin);
// 		if (result != -1) {
// 			isSolved = true;
// 			ans = min(ans, result + 1);
// 		}
// 	}
// 	return isSolved ? ans : -1;
// }

// memoization approach
// time complexity ??? and space complexity O(amount)
// helper function
int solve(vector<int>& coins, int amount, vector<int>& memo) {
	if (amount == 0)
		return 0;
	if (amount < 0)
		return -1;
	if (memo[amount] != -2)
		return memo[amount];
	int ans = INT_MAX;
	bool isSolved = false;
	for (int coin: coins) {
		int result = solve(coins, amount - coin, memo);
		if (result != -1) {
			ans = min(ans, result);
			isSolved = true;
		}
	}
	memo[amount] = isSolved ? ans + 1 : -1;
	return memo[amount];
}

int coinChange(vector<int>& coins, int amount) {
	if (amount == 0)
		return 0;
	vector<int> memo(amount + 1, -2);
	return solve(coins, amount, memo);
}

// TODO
// dynamic programming approach
int coinChange(vector<int> &coins, int amount) {
    if (amount == 0) 
    	return 0;
    vector<int> dp(amount + 1, -1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.size(); j++) {
            int remain_value = i - coins[j];
            if (remain_value == 0)
                dp[i] = 1;
            else if (remain_value < 0)
                continue;
            else if (remain_value > 0 && dp[remain_value] != -1)
                dp[i] = dp[i] != -1 ? min(dp[i], 1 + dp[remain_value]) : 1 + dp[remain_value];
        }
    }
    return dp[amount];
}
