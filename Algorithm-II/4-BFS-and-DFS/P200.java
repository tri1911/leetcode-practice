package algorithm2.bdfAndDfs;


/**
 * Date: Dec 15, 2021 - Redo: August 29, 2022
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */

// TODO: double check for another solution (this is just draft solution)

// time complexity: O(mn)
// space complexity: O(1)
public class P200 {
    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    private static void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] != '1') return;
        grid[row][col] = '0'; // or anything other than 1
        if (row < grid.length - 1) dfs(grid, row + 1, col); // up
        if (col > 0) dfs(grid, row, col - 1);// down
        if (row > 0) dfs(grid, row - 1, col); // right
        if (col < grid[0].length - 1) dfs(grid, row, col + 1); // left
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println("Expect: 1. Received: " + numIslands(grid));
        grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println("Expect: 3. Received: " + numIslands(grid));
    }
}
