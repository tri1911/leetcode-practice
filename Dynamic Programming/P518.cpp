// Date: Wed, Sep 22, 2021
// 518. Coin Change 2 (https://leetcode.com/problems/coin-change-2/)

// recursion approach (inefficient) -> Time Limit Exceeded
// int solve(int amount, int coins_size, vector<int>& coins) {
// 	if (amount == 0)
// 		return 1;
// 	if (amount < 0)
// 		return 0;
// 	if (coins_size == 0)
// 		return 0;
// 	return solve(amount, coins_size - 1, coins) + solve(amount - coins[coins_size - 1], coins_size, coins);
// }

// int change(int amount, vector<int>& coins) {
// 	return solve(amount, coins.size(), coins);
// }

// memoization approach (top-bottom)
int solve(int amount, int coins_size, vector<int>& coins, vector<vector<int>>& memo) {
	if (amount == 0)
		return 1;
	if (amount < 0)
		return 0;
	if (coins_size == 0)
		return 0;
	if (memo[coins_size][amount] != -1) 
		return memo[coins_size][amount];
	return memo[coins_size][amount] = solve(amount, coins_size - 1, coins, memo) + solve(amount - coins[coins_size - 1], coins_size, coins, memo);
}

int change(int amount, vector<int>& coins) {
	vector<vector<int>> memo(coins.size() + 1, vector<int>(amount + 1, -1));
	return solve(amount, coins.size(), coins, memo);
}

// Solution: https://www.geeksforgeeks.org/coin-change-dp-7/

// TODO: dynamic programming approach (bottom-top)
int change(int amount, vector<int>& coins) {
    int n = coins.size();
    vector<vector<int>> dp(n + 1, vector<int>(amount + 1));
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= amount; j++) {
            if (j == 0)
                dp[i][j] = 1;
            else {
                int remain = j - coins[i - 1];
                if (remain >= 0)
                    dp[i][j] += dp[i][remain];
                dp[i][j] += dp[i-1][j];
            }
        }
    }
    return dp[n][amount];
}