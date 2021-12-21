package algorithm2.bdfAndDfs;

// date: Dec 16, 2021
// 130. Surrounded Regions
// https://leetcode.com/problems/surrounded-regions/

import java.util.Arrays;

// TODO: Check out whether there is another better solution?

// time complexity: O(m*n)
// space complexity: O(1)
public class P130 {
    public void solve(char[][] board) {
        int n = board.length;
        // first row
        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }
        }
        // last row
        for (int col = 0; col < n; col++) {
            if (board[n - 1][col] == 'O') {
                dfs(board, n - 1, col);
            }
        }
        // first column
        for (int row = 0; row < n; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }
        }
        // last column
        for (int row = 0; row < n; row++) {
            if (board[row][n - 1] == 'O') {
                dfs(board, row, n - 1);
            }
        }
        // convert characters
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (board[row][col] == 'O') {
            board[row][col] = 'A';
            if (row > 0)
                dfs(board, row - 1, col);
            if (row < board.length - 1)
                dfs(board, row + 1, col);
            if (col > 0)
                dfs(board, row, col - 1);
            if (col < board.length - 1)
                dfs(board, row, col + 1);
        }
    }

    public static void main(String[] args) {
        P130 p = new P130();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        p.solve(board);
        System.out.println("Expect: [[X, X, X, X], [X, X, X, X], [X, X, X, X], [X, O, X, X]]. \nOutput: " + Arrays.deepToString(board));
        board = new char[][]{{'X'}};
        p.solve(board);
        System.out.println("Expect: [[X]]. \nOutput: " + Arrays.deepToString(board));
    }
}

// reference
// https://stackoverflow.com/questions/19648240/java-best-way-to-print-2d-array
// https://leetcode.com/problems/surrounded-regions/discuss/41612/A-really-simple-and-readable-C%2B%2B-solutionuff0conly-cost-12ms