// Date: Wed, Sep 29, 2021
// 994. Rotting Oranges (https://leetcode.com/problems/rotting-oranges/)

int orangesRotting(vector<vector<int>>& grid) {
	int m = grid.size(), n = grid[0].size();
	queue<pair<int, int>> q;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (grid[i][j] == 2) {
				q.push({i, j});
			}
		}
	}
	int ans = 0;
	int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	while (!q.empty()) {
		bool rotted = false;
		pair<int, int> current = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int new_row = current.first + dir[i][0], new_col = current.second + dir[i][1];
			if (new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && grid[new_row][new_col] == 1) {
				grid[new_row][new_col] = 2;
				q.push({ new_row, new_col });
				rotted = true;
			}
		}
		if (rotted)
			ans += 1;
	}

	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			if (grid[i][j] == 1)
				return -1;
	return ans;
}