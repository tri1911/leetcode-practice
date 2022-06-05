package leetcodingchallenge.june2022;

/**
 * Date: June 05, 2022
 * 52. N-Queens II
 * https://leetcode.com/problems/n-queens-ii/
 */

public class P52 {
    private int ans;
    // 1-d array represents the current board state
    // board[i] indicates the column which the queen positioned (on ith row)
    // space: O(n)
    private int[] board;

    public int totalNQueens(int n) {
        ans = 0;
        board = new int[n];
        search(0);
        return ans;
    }

    // helper function to check if the current position of queen at `row` is valid
    // time: O(row)
    private boolean isValid(int row) {
        int curCol = board[row], col;
        for (int i = 1; i <= row; i++) {
            col = board[row - i];
            if (col == curCol || col == curCol - i || col == curCol + i)
                return false;
        }
        return true;
    }

    private void search(int row) {
        int n = board.length;
        if (row == n) ans++;
        else {
            // time: O(n)
            for (int col = 0; col < n; col++) {
                board[row] = col;
                if (isValid(row)) {
                    search(row + 1);
                }
            }
        }
    }
}
