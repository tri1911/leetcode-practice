// Mon, Sep 21, 2021

// 516. Longest Palindromic Subsequence
// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

// Example 2:
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".

// Constraints:
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.

// recursion approach
// int solve(int first, int last, const string& s) {
// 	// base cases
// 	// length of 1
// 	if (first == last)
// 		return 1;
// 	// length of 2
// 	if (first + 1 == last) {
// 		if (s[first] == s[last])
// 			return 2;
// 		else
// 			return 1;
// 	}

// 	// remaining cases
// 	if (s[first] == s[last])
// 		return solve(first + 1, last - 1, s) + 2;
// 	return max(solve(first, last - 1, s), solve(first + 1, last, s));
// }

// int longestPalindromeSubseq(string s) {
// 	return solve(0, s.length() - 1, s);
// }

// memoization approach
// top-bottom
// time complexity O(n^2) and space complexity O(n^2)
// int solve(int first, int last, const string& s, vector<vector<int>>& memo) {
// 	if (memo[first][last] > 0)
// 		return memo[first][last];
// 	if (first == last) {
// 		memo[first][last] = 1;
// 		return memo[first][last];
// 	}
// 	if (first + 1 == last) {
// 		if (s[first] == s[last])
// 			memo[first][last] = 2;
// 		else
// 			memo[first][last] = 1;
// 		return memo[first][last];
// 	}
// 	if (s[first] == s[last]) {
// 		memo[first][last] = solve(first + 1, last - 1, s, memo) + 2;
// 	} else {
// 		memo[first][last] = max(solve(first, last - 1, s, memo), solve(first + 1, last, s, memo));
// 	}
// 	return memo[first][last];
// }

// int longestPalindromeSubseq(string s) {
// 	int n = s.length();
// 	vector<vector<int>> memo(n, vector<int>(n));
// 	return solve(0, s.length() - 1, s, memo);
// }

// dynamic programming approach
// bottom-top
int longestPalindromeSubseq(string s) {
	int n = s.length();
	vector<vector<int>> dp(n, vector<int>(n));
	// length of 1
	for (int i = 0; i < n; i++)
		dp[i][i] = 1;
	for (int k = 2; k <= n; k++) {
		for (int first = 0; first <= n - k; first++) {
			int last = first + k - 1;
			if (k == 2)
				dp[first][last] = s[first] == s[last] ? 2 : 1;
			else if (s[first] == s[last])
				dp[first][last] = dp[first + 1][last - 1] + 2;
			else
				dp[first][last] = max(dp[first][last - 1], dp[first + 1][last]);
		}
	}
	return dp[0][n - 1];
}