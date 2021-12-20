package algorithm2.binarySearch;

// date: Dec 13, 2021
// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

// time complexity: O(log(n))
// space complexity: O(1)
public class P74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int value = matrix[mid/n][mid%n];
            if (target == value)
                return true;
            if (target < value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println("Expected: true. Received: " + searchMatrix(matrix, 3));
        System.out.println("Expected: false. Received: " + searchMatrix(matrix, 13));
    }
}
