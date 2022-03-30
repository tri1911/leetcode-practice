package algorithm2.binarySearch;

// Date: Dec 13, 2021 - redo on March 29, 2022
// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

public class P74 {
    // time: O(log(n))
    // space: O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int row = mid / cols, col = mid % cols;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Expected: true. Received: " + searchMatrix(matrix, 3));
        System.out.println("Expected: false. Received: " + searchMatrix(matrix, 13));
    }
}
