package leetcodingchallenge.january2022;

import java.util.*;

/**
 * Date: Jan 15, 2022
 * 1345. Jump Game IV
 * https://leetcode.com/problems/jump-game-iv/
 */

// TODO: read and implement Bidirectional BFS approach

public class P1345 {
    // time: O(n)
    // space: O(n)
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        Map<Integer, List<Integer>> dict = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            dict.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        ArrayDeque<Integer> current = new ArrayDeque<>();
        current.add(0);
        int ans = 0;
        boolean[] visited = new boolean[n];
        while (!current.isEmpty()) {
            ArrayDeque<Integer> next = new ArrayDeque<>();
            for (int node : current) {
                if (node == n - 1) return ans;
                for (int adj : dict.get(arr[node])) {
                    if (!visited[adj]) {
                        next.add(adj);
                        visited[adj] = true;
                    }
                }
                dict.get(arr[node]).clear();
                if (node + 1 < n && !visited[node + 1]) {
                    next.add(node + 1);
                    visited[node + 1] = true;
                }
                if (node - 1 >= 0 && !visited[node - 1]) {
                    next.add(node - 1);
                    visited[node - 1] = true;
                }
            }
            ans++;
            current = next;
        }
        return -1;
    }
}

/**
 * reference
 * https://leetcode.com/problems/jump-game-iv/solution/
 */
