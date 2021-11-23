// Date: Wed, Sep 29, 2021 - Redo: Sat, Nov 20, 2021
// 994. Rotting Oranges (https://leetcode.com/problems/rotting-oranges/)

// int orangesRotting(vector<vector<int>>& grid) {
// 	int m = grid.size(), n = grid[0].size();
// 	queue<pair<int, int>> q;
// 	for (int i = 0; i < m; i++) {
// 		for (int j = 0; j < n; j++) {
// 			if (grid[i][j] == 2) {
// 				q.push({i, j});
// 			}
// 		}
// 	}
// 	int ans = 0;
// 	int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
// 	while (!q.empty()) {
// 		bool rotted = false;
// 		pair<int, int> current = q.front();
// 		q.pop();
// 		for (int i = 0; i < 4; i++) {
// 			int new_row = current.first + dir[i][0], new_col = current.second + dir[i][1];
// 			if (new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && grid[new_row][new_col] == 1) {
// 				grid[new_row][new_col] = 2;
// 				q.push({ new_row, new_col });
// 				rotted = true;
// 			}
// 		}
// 		if (rotted)
// 			ans += 1;
// 	}

// 	for (int i = 0; i < m; i++)
// 		for (int j = 0; j < n; j++)
// 			if (grid[i][j] == 1)
// 				return -1;
// 	return ans;
// }

// Fix on Nov 20, 2021
// time complexity: O(n)
// space complexity: O(n)
int orangesRotting(vector<vector<int>>& grid) {
    int rows = grid.size(), cols = grid[0].size();
    int ans = 0;
    queue<pair<int, int>> my_queue;
    
    // find the location of rotten oranges
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            // if the cell contains a rotten orange
            if (grid[i][j] == 2) {
                my_queue.push({i, j});
            }
        }
    }
    
    vector<vector<int>> directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    pair<int, int> current;
    int prev = 2;

    while (!my_queue.empty()) {
        // inspect the front of queue
        current = my_queue.front();
        int value = grid[current.first][current.second];
        my_queue.pop();
        // check 4-directionally adjacent
        for (vector<int> direction: directions) {
            int new_r = current.first + direction[0];
            int new_c = current.second + direction[1];
            if (new_r >= 0 && new_r < rows && new_c >= 0 && new_c < cols && grid[new_r][new_c] == 1) {
                grid[new_r][new_c] = value + 1;
                my_queue.push({new_r, new_c});
            }
        }
        if (value > prev) {
            prev = value;
            ans += 1;
        }
    }
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1) {
                return -1;
            }
        }
    }
    
    return ans;
}