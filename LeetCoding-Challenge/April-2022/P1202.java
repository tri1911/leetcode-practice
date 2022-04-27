package leetcodingchallenge.april2022;

import java.util.*;

/**
 * Date: April 27, 2022
 * 1202. Smallest String With Swaps
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */

// TODO: analyze the time complexity & redo using DFS/BFS approach

public class P1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        // connect edges using `union` function - O(m)
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);
            // union
            uf.union(source, destination);
        }
        // extract indices into separate connected component - O(n)
        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int vertex = 0; vertex < n; vertex++) {
            int root = uf.find(vertex);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }
        // populate characters into the solution
        char[] smallestString = new char[n];
        for (List<Integer> indices : rootToComponent.values()) {
            int k = indices.size();
            // notice: the indices is sorted
            // put corresponding characters into separate array
            char[] characters = new char[k];
            int i = 0;
            for (int index : indices) {
                characters[i++] = s.charAt(index);
            }
            // sort the characters in ascending order
            Arrays.sort(characters);
            // populate the solution
            i = 0;
            for (int index : indices) {
                smallestString[index] = characters[i++];
            }
        }
        return new String(smallestString);
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

        private int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        private void union(int x, int y) {
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
            }
        }
    }
}

/**
 * references
 * https://leetcode.com/problems/smallest-string-with-swaps/solution/
 */