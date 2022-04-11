package leetcodingchallenge.april2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: April 11, 2022
 * 1260. Shift 2D Grid
 * https://leetcode.com/problems/shift-2d-grid/
 */

public class P1260 {
    // time: O(m * n)
    // space: O(1)
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k = k % (m * n);
        // populate the solution 2d list
        List<List<Integer>> ans = new ArrayList<>();
        int offset = m * n - k;
        for (int i = 0; i < m * n; i++) {
            int idx = (i + offset) % (m * n);
            if (i % n == 0) ans.add(new ArrayList<>());
            ans.get(i / n).add(grid[idx / n][idx % n]);
        }
        return ans;
    }

    public static void main(String[] args) {
        P1260 obj = new P1260();
        int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        System.out.println("Expected: [[12, 0, 21, 13], [3, 8, 1, 9], [19, 7, 2, 5], [4, 6, 11, 10]]\nReceived: " + obj.shiftGrid(grid, 4));
    }
}
