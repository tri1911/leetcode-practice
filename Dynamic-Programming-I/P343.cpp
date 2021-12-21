// Date: Wed, Sep 22, 2021
// 343. Integer Break (https://leetcode.com/problems/integer-break/)
// Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
// Return the maximum product you can get.

// Example 1:
// Input: n = 2
// Output: 1
// Explanation: 2 = 1 + 1, 1 × 1 = 1.

// Example 2:
// Input: n = 10
// Output: 36
// Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 

// Constraints:
// 2 <= n <= 58

// recursion approach
// int integerBreak(int n) {
// 	int ans = n - 1;
// 	for (int i = 1; i < n - 1; i++) {
// 		ans = max(ans, i * max(n - i, integerBreak(n - i)));
// 	}
// 	return ans;
// }

// memoization approach
int integerBreak(int n, vector<int>& memo) {
	if (memo[n] != -1)
		return memo[n];
	memo[n] = n - 1;
	for (int i = 1; i < n - 1; i++) {
		memo[n] = max(memo[n], i * max(n - i, integerBreak(n - i, memo)));
	}
	return memo[n];
}

int integerBreak(int n) {
	vector<int> memo(n + 1, -1);
	return integerBreak(n, memo);
}

// TODO: Dynamic programming
// time complexity: O(n^2)
// space complexity: O(n)
int integerBreak(int n) {
    vector<int> dp(n + 1);
    for (int i = 2; i <= n; i++) {
        dp[i] = i - 1;
        for (int j = i - 2; j >= 1; j--) {
            dp[i] = max(dp[i], j * max(i - j, dp[i - j]));
        }
    }
    return dp[n];
}