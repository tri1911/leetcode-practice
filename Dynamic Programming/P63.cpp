// Date: Mon, Sep 20, 2021
// 63. Unique Paths II (https://leetcode.com/problems/unique-paths-ii/)

// memoization approach
// time complexity: O(m*n) & space complexity: O(m*n)
// helper function
int solve(int x1, int y1, vector<vector<int>>& obstacleGrid, vector<vector<int>>& memo) {
	int x2 = obstacleGrid[0].size();
	int y2 = obstacleGrid.size();
	if (x1 > x2 || y1 > y2)
		return 0;
	if (obstacleGrid[y1 - 1][x1 - 1] == 1)
		return 0;
	if (x1 == x2 && y1 == y2)
		return 1;
	if (memo[y1][x1] != -1)
		return memo[y1][x1];
	 memo[y1][x1] = solve(x1, y1 + 1, obstacleGrid, memo) + solve(x1 + 1, y1, obstacleGrid, memo);
	 return memo[y1][x1];
}

int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
	int rows = obstacleGrid.size();
	int cols = obstacleGrid[0].size();
	vector<vector<int>> memo(rows + 1, vector<int>(cols + 1, -1));
	return solve(1, 1, obstacleGrid, memo);
}

// TODO: dynamic programming approach
// Space complexity O(1), in-place update the number ways to reach [y1][x1]
int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
    if (obstacleGrid[0][0] == 1)
        return 0;
    int m = obstacleGrid.size();
    int n = obstacleGrid[0].size();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int cur = obstacleGrid[i][j];
            if (cur == 1)
                obstacleGrid[i][j] = 0;
            else {
                if (i == 0 && j == 0) { 
                    obstacleGrid[i][j] = 1;
                } else {
	                int from_top = (i > 0) ? obstacleGrid[i - 1][j] : 0;
	                int from_left = (j > 0) ? obstacleGrid[i][j-1] : 0;
	                obstacleGrid[i][j] = from_top + from_left;
                }
            }
        }
    }
    return obstacleGrid[m - 1][n - 1];
}