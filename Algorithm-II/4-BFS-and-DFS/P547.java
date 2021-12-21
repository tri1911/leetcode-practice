package algorithm2.bdfAndDfs;

// date: Dec 15, 2021
// 547. Number of Provinces
// https://leetcode.com/problems/number-of-provinces/

// TODO: check whether there is another optimized solution?

// time complexity: O(n*n)
// space complexity: O(1) / O(n)
public class P547 {
    // first attempt
//    public static int findCircleNum(int[][] isConnected) {
//        int m = isConnected.length, n = isConnected[0].length;
//        int ans = 0;
//        for (int row = 0; row < m; row++) {
//            for (int col = 0; col < n; col++) {
//                if (isConnected[row][col] == 1) {
//                    dfs(isConnected, -1, row);
//                    ans += 1;
//                }
//            }
//        }
//        return ans;
//    }

//    private static void dfs(int[][] isConnected, int previous, int row) {
//        for (int col = 0; col < isConnected[0].length; col++) {
//            if (isConnected[row][col] == 1) {
//                isConnected[row][col] = 0;
//                if (row != col && col != previous) {
//                    dfs(isConnected, row, col);
//                }
//            }
//        }
//    }

    // second attempt (on Dec 19, 2021)
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += !isVisited[i] ? 1 : 0;
            dfs(isConnected, n, i, isVisited);
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int n, int current, boolean[] isVisited) {
        isVisited[current] = true;
        for (int j = 0; j < n; j++) {
            if (isConnected[current][j] == 1 && !isVisited[j]) {
                dfs(isConnected, n, j, isVisited);
            }
        }
    }

    public static void main(String[] args) {
        P547 p = new P547();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println("Expected: 2. Output: " + p.findCircleNum(isConnected));
         isConnected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
         System.out.println("Expected: 3. Output: " + p.findCircleNum(isConnected));
    }
}