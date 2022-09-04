package leetcodingchallenge.august2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: August 31, 2022
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */

public class P417 {
    // time & space: O(mn)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        // 0 - unvisited, 1 - pacific ocean reachable, 2 - atlantic ocean reachable
        // notice that 0(00), 1(01), 2(02)
        // leverage the AND operator such that (00 & anything) and (01 & 10) = 0
        // we can only continue the dfs only when the `weight` & `cell value` = 0; otherwise, we terminate the dfs process 
        int[][] visited = new int[m][n];
        // vertically
        for (int i = 0; i < m; i++) {
            // pacific
            dfs(i, 0, 1, Integer.MIN_VALUE, heights, visited, ans);
            // atlantic
            dfs(i, n - 1, 2, Integer.MIN_VALUE, heights, visited, ans);
        }
        // horizontally
        for (int j = 0; j < n; j++) {
            // pacific
            dfs(0, j, 1, Integer.MIN_VALUE, heights, visited, ans);
            // atlantic
            dfs(m - 1, j, 2, Integer.MIN_VALUE, heights, visited, ans);
        }
        return ans;
    }

    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int row, int col, int weight, int height, int[][] heights, int[][] visited, List<List<Integer>> ans) {
        int m = heights.length, n = heights[0].length;
        // only make the next move if the visited[row][col] is unvisited (0) or not 3 or different from last visited (e.g. already 1, current 2)
        // in other words, only making next move if visited[row][col] & weight == 0
        if (row < 0 || col < 0 || row == m || col == n || (weight & visited[row][col]) != 0 || heights[row][col] < height) {
            return;
        }
        visited[row][col] |= weight;
        // found the cell that can connect to both pacific and atlantic
        if (visited[row][col] == 3) {
            ans.add(Arrays.asList(row, col));
        }
        // dfs moves
        for (int[] direction : directions) {
            dfs(row + direction[0], col + direction[1], weight, heights[row][col], heights, visited, ans);
        }
    }
}

/*  2 ms solution
    static void dfs(int i, int j, int w, int h, int[][] M, byte[] dp, List<List<Integer>> ans) {
        int ij = i * M[0].length + j;
        if ((dp[ij] & w) > 0 || M[i][j] < h) return;
        dp[ij] += w;
        h = M[i][j];
        if (dp[ij] == 3) ans.add(Arrays.asList(i,j));
        if (i + 1 < M.length) dfs(i+1, j, w, h, M, dp, ans);
        if (i > 0) dfs(i-1, j, w, h, M, dp, ans);
        if (j + 1 < M[0].length) dfs(i, j+1, w, h, M, dp, ans);
        if (j > 0) dfs(i, j-1, w, h, M, dp, ans);
    }
    public List<List<Integer>> pacificAtlantic(int[][] M) {
        List<List<Integer>> ans = new ArrayList<>();
        if (M.length == 0) return ans;
        int y = M.length, x = M[0].length;
        byte[] dp = new byte[x * y];
        for (int i = 0; i < x; i++) {
            dfs(0, i, 1, M[0][i], M, dp, ans);
            dfs(y-1, i, 2, M[y-1][i], M, dp, ans);
        }   
        for (int i = 0; i < y; i++) {
            dfs(i, 0, 1, M[i][0], M, dp, ans);
            dfs(i, x-1, 2, M[i][x-1], M, dp, ans);
        }
        return ans;
    }
*/
