package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Feb 8, 2022
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 */

public class P54 {
    // time: O(mn)
    // space: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, row = 0, col = 0, moveIndex = 0; i < m * n; i++) {
            ans.add(matrix[row][col]); // record the value
            matrix[row][col] = -101; // mark as seen
            int newRow = row + directions[moveIndex][0];
            int newCol = col + directions[moveIndex][1];
            // change direction
            if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || matrix[newRow][newCol] == -101) {
                moveIndex = (moveIndex + 1) % 4;
                // update the next move
                row += directions[moveIndex][0];
                col += directions[moveIndex][1];
            } else {
                // update the next move
                row = newRow;
                col = newCol;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P54 obj = new P54();
        System.out.println("Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]\nReceived: " + obj.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]\nReceived: " + obj.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
