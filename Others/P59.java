package others;

import java.util.Arrays;

/**
 * Date:
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 */

// TODO: check out the official solution if have time

public class P59 {
    // my own solution
    // time: O(n^2)
    // space: O(1)
    public int[][] generateMatrix(int n) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ans = new int[n][n];
        for (int row = 0, col = 0, current = 1, index = 0; current <= n * n; current++) {
            // set value
            ans[row][col] = current;
            // examine next move
            int newRow = row + directions[index][0];
            int newCol = col + directions[index][1];
            // change direction
            if (newRow < 0 || newCol < 0 || newRow >= n || newCol >= n || ans[newRow][newCol] != 0) {
                index = (index + 1) % 4;
                // update the next move
                row += directions[index][0];
                col += directions[index][1];
            } else {
                // update the next move
                row = newRow;
                col = newCol;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P59 obj = new P59();
        System.out.println("Expected: [[1, 2, 3], [8, 9, 4], [7, 6, 5]]\nReceived: " + Arrays.deepToString(obj.generateMatrix(3)));
        System.out.println("----");
        System.out.println("Expected: [[1]]\nReceived: " + Arrays.deepToString(obj.generateMatrix(1)));
    }
}

/**
 * reference
 * https://leetcode.com/problems/spiral-matrix-ii/solution/
 * https://stackoverflow.com/questions/19648240/java-best-way-to-print-2d-array
 */