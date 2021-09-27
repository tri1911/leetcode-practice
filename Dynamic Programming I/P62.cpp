// Date: Mon, Sep 20, 2021
// 62. Unique Paths (https://leetcode.com/problems/unique-paths/)

// recursion approach (however it is inefficient)
// helper function
// int solve(int x1, int y1, int x2, int y2) {
// 	if (x1 == x2 && y1 == y2)
// 		return 1;
// 	if (x1 > x2 || y1 > y2)
// 		return 0;
// 	return solve(x1 + 1, y1, x2, y2) + solve(x1, y1 + 1, x2, y2);
// }

// int uniquePaths(int m, int n) {
// 	return solve(1, 1, m, n);
// }

// memoization approach
// time complexity O(m*n) and space complexity O(m*n)
// int solve(int x1, int y1, int x2, int y2, vector<vector<int>>& memo) {
//     if (x1 == x2 && y1 == y2)
//         return 1;
//     if (x1 > x2 || y1 > y2)
//         return 0;
//     if (memo[y1][x1] != -1)
//         return memo[y1][x1];
//     memo[y1][x1] = solve(x1 + 1, y1, x2, y2, memo) + solve(x1, y1 + 1, x2, y2, memo);
//     return memo[y1][x1];
// }

// int uniquePaths(int m, int n) {
//     vector<vector<int>> memo(m + 1, vector<int>(n + 1, -1));
//     return solve(1, 1, n, m, memo);
// }

// TODO: practice using dynamic programming approach
// dp[y1][x1] = dp[y1 - 1][x1] + dp[y1][x1 - 1]
// Time and space: O(mn)
int uniquePaths(int m, int n) {
    vector<vector<int>> dp(m + 1, vector<int>(n + 1));
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == 1 || j == 1) 
                dp[i][j] = 1;
            else
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    return dp[m][n];
}