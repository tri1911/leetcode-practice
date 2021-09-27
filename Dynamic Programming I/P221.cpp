// Date: Mon, Sep 20, 2021

// 221. Maximal Square
// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

// Example 1:
// Input: matrix = [["1","0","1","0","0"],
// 					["1","0","1","1","1"],
// 					["1","1","1","1","1"],
// 					["1","0","0","1","0"]]
// Output: 4

// Example 2:
// Input: matrix = [["0","1"],
// 					["1","0"]]
// Output: 1

// Example 3:
// Input: matrix = [["0"]]
// Output: 0

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.

// dynamic programming
// time complexity O(m*n) & space complexity O(1)
int maximalSquare(vector<vector<char>>& matrix) {
	int rows = matrix.size();
	int cols = matrix[0].size();
	vector<vector<int>> dp(rows, vector<int>(cols));
	int ans = 0;
	for (int row = 0; row < rows; row++) {
		for (int col = 0; col < cols; col++) {
			if (matrix[row][col] == '1') {
				dp[row][col] = 1;
				if (row > 0 && col > 0) {
					dp[row][col] += min({dp[row - 1][col - 1], dp[row][col - 1], dp[row - 1][col]});
				}
				ans = max(ans, dp[row][col]);
			}
		}
	}
	return ans * ans;
}