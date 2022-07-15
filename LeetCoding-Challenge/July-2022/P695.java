package leetcodingchallenge.july2022;

/**
 * Date: July 15, 2022 - Already solved this problem on Nov 2021
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/
 */

// TODO: implement with iterative approach (as official solution)

// recursive depth-first search approach
// time: O(r*c)
// time: O(1)
public class P695 {
    private int m, n, current, ans;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        ans = current = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                current = 0;
                dfs(grid, i, j);
                ans = Math.max(ans, current);
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 1) {
            grid[row][col] = 0;
            current++;
            if (row > 0) dfs(grid, row - 1, col);
            if (row < m - 1) dfs(grid, row + 1, col);
            if (col > 0) dfs(grid, row, col - 1);
            if (col < n - 1) dfs(grid, row, col + 1);
        }
    }
}

/**
 * references
 * https://leetcode.com/problems/max-area-of-island/solution/
 */