package topInterviewQs;

/**
 * Date: April 06, 2022 - redo on July 24, 2022
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

public class P240 {
    // time: O(m + n)
    // space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}

/**
 * reference
 * https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
 */