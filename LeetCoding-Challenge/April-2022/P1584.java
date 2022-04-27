package leetcodingchallenge.april2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: April 26, 2022
 * 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */

// TODO: analyze the time complexity & redo with Prim algorithm

public class P1584 {
    // Kruskal Algorithm approach - using Union-Find data structure to detect cycle
    // time: O(n^2 * log(n)) where n is the number of points
    // space: O(n^2)
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // build the graph - representing by edges - takes O(m)
        List<int[]> allEdges = new ArrayList<>();
        for (int source = 0; source < n; source++) {
            for (int dest = source + 1; dest < n; dest++) {
                int weight = Math.abs(points[source][0] - points[dest][0]) + Math.abs(points[source][1] - points[dest][1]);
                allEdges.add(new int[]{weight, source, dest});
            }
        }
        // sort edges by weight - take O(mlog(m))
        Collections.sort(allEdges, (e1, e2) -> Integer.compare(e1[0], e2[0]));

        // add valid edges into the minimum spanning tree - O(m)
        UnionFind uf = new UnionFind(n);
        int mstCost = 0, mstEdges = 0;
        for (int[] edge : allEdges) {
            int source = edge[1];
            int dest = edge[2];
            if (uf.union(source, dest)) {
                mstCost += edge[0];
                if (++mstEdges == n - 1) {
                    break;
                }
            }
        }

        return mstCost;
    }

    private class UnionFind {
        private int[] root;
        private int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                return true;
            }
            return false;
        }
    }
}

/**
 * references
 * https://leetcode.com/problems/min-cost-to-connect-all-points/solution/
 */