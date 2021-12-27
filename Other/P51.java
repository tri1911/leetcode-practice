package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Date: Dec 23, 2021
// 51. N-Queens
// https://leetcode.com/problems/n-queens/

public class P51 {
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
