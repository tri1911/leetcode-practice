// Date: Mon, Sep 20, 2021
// 64. Minimum Path Sum
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

// Example 1:
// Input: grid = [[1,3,1],
// 				  [1,5,1],
// 				  [4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

// Example 2:
// Input: grid = [[1,2,3],
// 				  [4,5,6]]
// Output: 12

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100

// at 3, 3 += min of (2,3) and (3,2)

// recursion approach -> inefficient
// e.g (2,1) <- (2, 0) & (1,1)
// (1, 2)  <- (0, 2) & (1, 1)
// (1, 1) will recursively call twice
// int solve(int row, int col, vector<vector<int>>& grid) {
// 	if (row < 0 || col < 0)
// 		return INT_MAX;
// 	if (row == 0 && col == 0)
// 		return grid[row][col];
// 	return grid[row][col] + min(solve(row - 1, col, grid), solve(row, col - 1, grid));
// }

// int minPathSum(vector<vector<int>>& grid) {
// 	int rows = grid.size();
// 	int cols = grid[0].size();
// 	return solve(rows - 1, cols - 1, grid);
// }

// memoization approach
// time complexity: O(m*n) & space complexity: O(m*n)
// int solve(int row, int col, vector<vector<int>> &grid, vector<vector<int>> &memo) {
//     if (row < 0 || col < 0)
//         return INT_MAX;
//     if (memo[row][col] != -1)
//         return memo[row][col];
//     if (row == 0 && col == 0) {
//     	memo[row][col] = grid[row][col];
//     } else {
//     	memo[row][col] = grid[row][col] + min(solve(row - 1, col, grid, memo), solve(row, col - 1, grid, memo));
//     }
//     return memo[row][col];
// }

// int minPathSum(vector<vector<int>> &grid) {
//     int rows = grid.size();
//     int cols = grid[0].size();
//     vector<vector<int>> memo(rows, vector<int>(cols, -1));
//     return solve(rows - 1, cols - 1, grid, memo);
// }

// dynamic programming approach
// time complexity (m*n) & space complexity O(1)
int minPathSum(vector<vector<int>> &grid) {
	int rows = grid.size();
    int cols = grid[0].size();
    // first row
    for (int col = 1; col < cols; col++)
    	grid[0][col] += grid[0][col - 1];
    // first column
    for (int row = 1; row < rows; row++)
    	grid[row][0] += grid[row - 1][0];
    // other cells
    for (int row = 1; row < rows; row++) {
    	for (int col = 1; col < cols; col++) {
    		grid[row][col] += min(grid[row - 1][col], grid[row][col - 1]);
    	}
    }
    return grid[rows - 1][cols - 1];
}

// dp solution redo
int minPathSum(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) 
                continue;
            else {
                int from_top = i > 0 ? grid[i-1][j] : INT_MAX;
                int from_left = j > 0 ? grid[i][j-1] : INT_MAX;
                grid[i][j] += min(from_top, from_left);
            }
        }
    }
    return grid[m-1][n-1];
}

int main() {
    vector<vector<int>> grid{{1, 3, 1},
                             {1, 5, 1},
                             {4, 2, 1}};
    cout << minPathSum(grid) << endl;
    return 0;
}
