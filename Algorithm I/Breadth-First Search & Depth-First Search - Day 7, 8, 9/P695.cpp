// Date: Tue, Sep 28, 2021
// 695. Max Area of Island (https://leetcode.com/problems/max-area-of-island/)

// time complexity O(m*n)
// space complexity O(1)
int helper(int row, int col, vector<vector<int>>& grid) {
	int rows = grid.size(), cols = grid[0].size();
	if (!(row >= 0 && row < rows && col >= 0 && col < cols) || grid[row][col] == 0)
		return 0;
	grid[row][col] = 0;
	return 1 + helper(row, col + 1, grid) + helper(row, col - 1, grid) + helper(row + 1, col, grid) + helper(row - 1, col, grid);
}

int maxAreaOfIsland(vector<vector<int>>& grid) {
	int ans = 0;
	int rows = grid.size(), cols = grid[0].size();
	for (int row = 0; row < rows; row++) {
		for (int col = 0; col < cols; col++) {
			if (grid[row][col] == 1) 
				ans = max(ans, helper(row, col, grid));
		}
	}
	return ans;
}