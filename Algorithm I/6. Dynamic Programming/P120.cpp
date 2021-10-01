// Date: Thu, Oct 1, 2021
// Redo (did it in Dynamic Programming I before)
// 120. Triangle (https://leetcode.com/problems/triangle/)

// dynamic programming approach
// idea: for each row j at row i: dp[i][j] = triangle[i][j] + min(dp[i-1][j], dp[i-1][j-1])
// we are able to find out the solution for dp[i][j] if we know dp[i-1][.]
// time complexity: O(n) where n is the number of elements in total
// space complexity: O(1)
int minimumTotal(vector<vector<int>>& triangle) {
	int rows = triangle.size();
	if (rows == 1) 
		return triangle[0][0];
	for (int i = 1; i < rows; i++) {
		int cols = triangle[i].size();
		for (int j = 0; j < cols; j++) {
			int best = INT_MAX;
			if (j > 0)
				best = min(best, triangle[i-1][j-1]);
			if (j < cols-1)
				best = min(best, triangle[i-1][j]);
			triangle[i][j] += best;
		}
	}
	int ans = INT_MAX;
	for (int i: triangle[rows-1])
		ans = min(ans, i);
	return ans;
}