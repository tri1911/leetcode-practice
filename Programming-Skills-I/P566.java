package programmingSkills1;

import java.util.Arrays;

/**
 * Date: March 20, 2022
 * 566. Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/
 */

public class P566 {
    // time: O(m * n)
    // space: O(1)
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        int[][] ans = new int[r][c];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int index = row * n + col;
                ans[index / c][index % c] = mat[row][col];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P566 obj = new P566();
        System.out.println("Expected: [[1, 2], [3, 4]]\nReceived: " + Arrays.deepToString(obj.matrixReshape(new int[][]{{1}, {2}, {3}, {4}}, 2, 2)));
    }
}
