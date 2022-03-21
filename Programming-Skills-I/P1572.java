package programmingSkills1;

/**
 * Date: March 20, 2022
 * 1572. Matrix Diagonal Sum
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */

public class P1572 {
    // first attempt
    // time: O(n^2)
    // space: O(1)
    public int _diagonalSum(int[][] mat) {
        int ans = 0, n = mat.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col || row == n - 1 - col) {
                    ans += mat[row][col];
                }
            }
        }
        return ans;
    }

    // optimized approach
    // time: O(n)
    // space: O(1)
    public int diagonalSum(int[][] mat) {
        int ans = 0, n = mat.length;
        for (int i = 0; i < n; i++) {
            ans += mat[i][i];
            ans += mat[i][n - 1 - i];
        }
        if (n % 2 == 1) ans -= mat[n / 2][n / 2];
        return ans;
    }
}
