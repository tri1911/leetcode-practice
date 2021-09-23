// 1314. Matrix Block Sum
// Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
// i - k <= r <= i + k,
// j - k <= c <= j + k, and
// (r, c) is a valid position in the matrix.

// Example 1:
// Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
// Output: [[12,21,16],[27,45,33],[24,39,28]]

// Example 2:
// Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
// Output: [[45,45,45],[45,45,45],[45,45,45]]

// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n, k <= 100
// 1 <= mat[i][j] <= 100

// dynamic programming approach
// time complexity: O(mxn) & space complexity: O(mxn)
vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
	int rows = mat.size();
	int cols = mat[0].size();
	// compute the prefix sum array
	vector<vector<int>> dp(rows, vector<int>(cols));
	// first row
	for (int col = 0; col < cols; col++) {
		if (col)
			dp[0][col] = dp[0][col - 1] + mat[0][col];
		else 
			dp[0][col] = mat[0][col];
	}
	// first column
	for (int row = 1; row < rows; row++) {
		dp[row][0] = dp[row - 1][0] + mat[row][0];
	}
	// other
	for (int row = 1; row < rows; row++) {
		for (int col = 1; col < cols; col++){
			dp[row][col] = dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col - 1] + mat[row][col];
		}
	}
	vector<vector<int>> ans(rows, vector<int>(cols));
	for (int row = 0; row < rows; row++) {
		for (int col = 0; col < cols; col++) {
			// compute the boundary
			int min_col = max(0, col - k);
			int max_col = min(cols - 1, col + k);
			int min_row = max(0, row - k);			
			int max_row = min(rows - 1, row + k);
			// ans[row][col] = dp[max_row][max_col] - dp[min_row - 1][max_col] - dp[max_row][min_col - 1] + dp[min_row - 1][min_col - 1];
			ans[row][col] = dp[max_row][max_col];
			if (min_row > 0 && min_col > 0)
				ans[row][col] += dp[min_row - 1][min_col - 1];
			if (min_col > 0)
				ans[row][col] -= dp[max_row][min_col - 1];
			if (min_row > 0)
				ans[row][col] -= dp[min_row - 1][max_col];
		}
	}
	return ans;
}

// solution links
// https://shareablecode.com/snippets/matrix-block-sum-c-solution-leetcode-Zksa-bHN7
// O(1) extra space
// https://leetcode.com/problems/matrix-block-sum/discuss/1459378/C%2B%2B-or-Prefix-sum-%2B-Sliding-window-or-O(n*m)-time-or-O(1)-extra-space
