package leetcodingchallenge.june2022;

import java.util.List;

/**
 * Date: June 13, 2022 (just redo - already solve it in C++)
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 */

public class P120 {
    // time: O(n)
    // space: O(1)
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 1) return triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int row = 1; row < rows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> curRow = triangle.get(row);
            for (int col = 0; col <= row; col++) {
                int best = col == 0 ? prevRow.get(col) : col == row ? prevRow.get(col - 1) : Math.min(prevRow.get(col - 1), prevRow.get(col));
                curRow.set(col, curRow.get(col) + best);
                if (row == rows - 1) ans = Math.min(ans, curRow.get(col));
            }
        }
        return ans;
    }
}
