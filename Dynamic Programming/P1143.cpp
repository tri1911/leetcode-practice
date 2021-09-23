// Date: Tue, Sep 21, 2021
// 1143. Longest Common Subsequence (https://leetcode.com/problems/longest-common-subsequence/)

// Example 1:
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.

// recursion approach (inefficient)
// time complexity O(2^n) & space complexity O(1)
// int solve(const string& text1, const string& text2, int size1, int size2) {
// 	if (size1 == 0 || size2 == 0)
// 		return 0;
// 	if (text1[size1 - 1] == text2[size2 - 1])
// 		return 1 + solve(text1, text2, size1 - 1, size2 - 1);
// 	else
// 		return max(solve(text1, text2, size1, size2 - 1), solve(text1, text2, size1 - 1, size2));
// }

// int longestCommonSubsequence(string text1, string text2) {
//     return solve(text1, text2, text1.length(), text2.length());
// }

// memoization approach
// time complexity O(m*n) and space complexity (m*n)
// int solve(const string& text1, const string& text2, int size1, int size2, vector<vector<int>>& memo) {
// 	if (memo[size1][size2] != -1)
// 		return memo[size1][size2];

// 	if (size1 == 0 || size2 == 0) {
// 		memo[size1][size2] = 0;
// 		return memo[size1][size2];
// 	}

// 	if (text1[size1 - 1] == text2[size2 - 1])
// 		memo[size1][size2] = 1 + solve(text1, text2, size1 - 1, size2 - 1, memo);
// 	else
// 		memo[size1][size2] = max(solve(text1, text2, size1, size2 - 1, memo), solve(text1, text2, size1 - 1, size2, memo));
// 	return memo[size1][size2];
// }

// int longestCommonSubsequence(string text1, string text2) {
// 	int size1 = text1.length(), size2 = text2.length();
// 	vector<vector<int>> memo(size1 + 1, vector<int>(size2 + 1, -1));
//     return solve(text1, text2, size1, size2, memo);
// }

// dynamic programming approach
// time complexity O(m*n) and space complexity (m*n)
int longestCommonSubsequence(string text1, string text2) {
	int size1 = text1.length(), size2 = text2.length();
	vector<vector<int>> dp(size1 + 1, vector<int>(size2 + 1));
	for (int i = 0; i <= size1; i++) {
		for (int j = 0; j <= size2; j++) {
			if (i == 0 || j == 0)
				continue;
			else if (text1[i - 1] == text2[j - 1])
				dp[i][j] = 1 + dp[i - 1][j - 1];
			else
				dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
		}
	}
	return dp[size1][size2];
}