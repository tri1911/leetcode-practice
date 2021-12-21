package algorithm2.bdfAndDfs;

// date: Dec 16, 2021
// 1091. Shortest Path in Binary Matrix
// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// TODO: double check for better, precise solution

// using Breadth-first search approach
public class P1091 {
    // first attempt
    // time complexity: O(n)
    // space complexity: O(1)
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        int n = grid.length;
//        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
//        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        boolean[][] checked = new boolean[n][n];
//        int[][] distances = new int[n][n];
//        queue.add(new Pair<>(0, 0));
//        checked[0][0] = true;
//        distances[0][0] = 1;
//        while (!queue.isEmpty()) {
//            Pair<Integer, Integer> current = queue.remove();
//            int currentRow = current.getKey();
//            int currentCol = current.getValue();
//            int distance = distances[currentRow][currentCol];
//            if (currentRow == n - 1 && currentCol == n - 1)
//                return distance;
//            for (int i = 0; i < 8; i++) {
//                int newRow = currentRow + directions[i][0];
//                int newCol = currentCol + directions[i][1];
//                if (isValid(newRow, newCol, checked, grid, n)) {
//                    checked[newRow][newCol] = true;
//                    distances[newRow][newCol] = distance + 1;
//                    queue.add(new Pair<>(newRow, newCol));
//                }
//            }
//        }
//        return -1;
//    }

//    private boolean isValid(int row, int col, boolean[][] checked, int[][] grid, int n) {
//        return row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 0 && !checked[row][col];
//    }

    // second attempt (on Dec 20, 2021)
    // time complexity: O(n*n)
    // space complexity: O(1)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int row = current[0];
            int col = current[1];
            if (row == n - 1 && col == n - 1)
                return grid[row][col];
            for (int i = 0; i < 8; i++) {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                if (isValid(grid, newRow, newCol)) {
                    grid[newRow][newCol] = grid[row][col] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length && grid[row][col] == 0;
    }

    public static void main(String[] args) {
        P1091 p = new P1091();

        System.out.println("Expect: 1. Output: " + p.shortestPathBinaryMatrix(new int[][]{{0}}));

        System.out.println("Expect: 2. Output: " + p.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println("Expect: -1. Output: " + p.shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 1}}));

        System.out.println("Expect: 4. Output: " + p.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println("Expect: -1. Output: " + p.shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));

        System.out.println("Expect: 3. Output: " + p.shortestPathBinaryMatrix(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}}));

        System.out.println("Expect: 14. Output: " + p.shortestPathBinaryMatrix(new int[][]{{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}}));
    }
}
