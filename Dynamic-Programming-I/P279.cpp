// Date: Wed, Sep 22, 2021
// 279. Perfect Squares

// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
// For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

// Example 1:
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.

// Example 2:
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

// Constraints:
// 1 <= n <= 10^4

// recursion approach
// int numSquares(int n) {
// 	if (n == 0)
// 		return 0;
// 	int ans = n;
// 	for (double i = 1; i <= sqrt(n); i++) {
// 		ans = min(ans, 1 + numSquares(n - i * i));
// 	}
// 	return ans;
// }

// memoization approach
int numSquares(int n, vector<int>& memo) {
	if (n == 0)
		return 0;
	if (memo[n] != -1)
		return memo[n];
	memo[n] = n;
	for (double i = 1; i <= sqrt(n); i++) {
		memo[n] = min(memo[n], 1 + numSquares(n - i * i, memo));
	}
	return memo[n];
}

int numSquares(int n) {
	vector<int> memo(n + 1, -1);
	return numSquares(n, memo);
}

// TODO: dynamic programming approach
int numSquares(int n) {
    vector<int> dp(n + 1);
    for (int i = 1; i <= n; i++) {
        int best = INT_MAX;
        for (int j = 1; j * j <= i; j++) {
            best = min(best, dp[i - j * j]);
        }
        dp[i] = 1 + best;
    }
    return dp[n];
}