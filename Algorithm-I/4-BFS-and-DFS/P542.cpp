// Date: Wed, Sep 29, 2021 (Not Done) => Redo Date: Sat Nov 20, 2021
// 542. 01 Matrix (https://leetcode.com/problems/01-matrix/)

// dynamic programming approach
// time complexity: O(r*c)
// space complexity: O(r*c)
vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
	int rows = mat.size(), cols = mat[0].size();
	vector<vector<int>> ans(rows, vector<int>(cols, INT_MAX));
	// the min distance to 0 of a cell can be calculated from 4 neighbours
	// from top-left
	// takes O(r*c) time
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			if (mat[i][j] == 0) {
				ans[i][j] = 0;
			} else {
				if (i-1 >= 0)
					ans[i][j] = min(ans[i][j], ans[i-1][j] + 1);
				if (j-1 >= 0)
					ans[i][j] = min(ans[i][j], ans[i][j-1] + 1);
			}
		}
	}
	// from bottom-right
	// takes O(r*c) time
	for (int i = rows - 1; i >= 0; i--) {
		for (int j = cols - 1; j >= 0; j--) {
			if (i+1 < rows)
				ans[i][j] = min(ans[i][j], ans[i+1][j] + 1);
			if (j+1 < cols)
				ans[i][j] = min(ans[i][j], ans[i][j+1] + 1);
		}
	}
	return ans;
}