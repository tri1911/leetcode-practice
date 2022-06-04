package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date: Dec 23, 2021 - Redo: June 04, 2022
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 */

public class P51 {
    // array represents the board state [index : value] <=> [row : at which col queen is]
    // space: O(n)
    private int[] state;

    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        state = new int[n];
        backtracking(0);
        return ans;
    }

    private void backtracking(int row) {
        int n = state.length;
        // base case
        if (row == n) {
            ans.add(stateToString());
        } else {
            // check possible cols
            for (int col = 0; col < n; col++) {
                state[row] = col;
                if (isValid(row)) {
                    backtracking(row + 1);
                }
            }
        }
    }

    // time: O(row)
    private boolean isValid(int row) {
        int col = state[row];
        for (int i = 1; i <= row; i++) {
            if (state[row - i] == col ||
                    state[row - i] == col - i ||
                    state[row - i] == col + i)
                return false;
        }
        return true;
    }

    // time: O(n)
    private List<String> stateToString() {
        int n = state.length;
        StringBuilder template = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) template.append('.');
        for (int col : state) {
            template.setCharAt(col, 'Q');
            list.add(template.toString());
            template.setCharAt(col, '.');
        }
        return list;
    }

    // test
    public static void main(String[] args) {
        P51 p = new P51();
        System.out.println("--------------------");
        System.out.println("Input: n = 4");
        System.out.println("Expect: [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]");
        System.out.println("Output: " + p.solveNQueens(4));
        System.out.println("--------------------");
        System.out.println("Input: n = 1");
        System.out.println("Expect: [[Q]]");
        System.out.println("Output: " + p.solveNQueens(1));
    }
}

/*  First Attempt on Dec 23, 2021
    // use backtracking approach
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] board = new int[n];
        search(0, board, ans);
        return ans;
    }

    // helper functions
    private void search(int row, int[] board, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            ans.add(toStringList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (isValid(row, col, board))
                search(row + 1, board, ans);
        }
    }

    private boolean isValid(int row, int col, int[] board) {
        for (int i = 1; i <= row; i++) {
            if (board[row - i] == col || board[row - i] == col - i || board[row - i] == col + i)
                return false;
        }
        return true;
    }

    private List<String> toStringList(int[] board) {
        int n = board.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String rowStr = "";
            int col = board[i];
            for (int j = 0; j < n; j++) {
                rowStr += j == col ? 'Q' : '.';
            }
            result.add(rowStr);
        }
        return result;
    }
*/