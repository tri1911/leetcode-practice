// Date: Thu, Oct 1, 2021
// Redo (did it in Dynamic Programming I already)
// 70. Climbing Stairs (https://leetcode.com/problems/climbing-stairs/)

// dynamic programming approach
// idea: the last action maybe taking 1 step or 2 steps: dp[i] = dp[i - 1] + dp[i - 2]
// time complexity: O(n)
// space complexity: O(1)
int climbStairs(int n) {
	if (n == 1) return 1;
	vector<int> dp(n + 1, 1);
	for (int i = 1; i <= n; i++) {
		dp[i] = dp[i - 1];
		if (i >= 2)
			dp[i] += dp[i-2];
	}
	return dp[n];
}

