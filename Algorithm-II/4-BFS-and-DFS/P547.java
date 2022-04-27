package algorithm2.bdfAndDfs;

/**
 * Date: Dec 15, 2021 - Redo: April 26, 2022
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/
 */

public class P547 {
    /*  first attempt
        public static int findCircleNum(int[][] isConnected) {
            int m = isConnected.length, n = isConnected[0].length;
            int ans = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (isConnected[row][col] == 1) {
                        dfs(isConnected, -1, row);
                        ans += 1;
                    }
                }
            }
            return ans;
        }

        private static void dfs(int[][] isConnected, int previous, int row) {
            for (int col = 0; col < isConnected[0].length; col++) {
                if (isConnected[row][col] == 1) {
                    isConnected[row][col] = 0;
                    if (row != col && col != previous) {
                        dfs(isConnected, row, col);
                    }
                }
            }
        }
     */

    // second attempt (on Dec 19, 2021)
    // time complexity: O(n*n)
    // space complexity: O(1) / O(n)
    public int _findCircleNum(int[][] isConnected) {
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

    // Disjoint Set Union approach (or Union-Find)
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    // Union-Find implementation
    // Quick Union by rank & Path Compression
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
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

/**
 * references
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3846/
 */