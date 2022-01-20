package topInterviewQs;

// Date: Jan 9, 2022
// 210. Course Schedule II
// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

// TODO: implement Topological sort with DFS, check out the official solution
// https://leetcode.com/problems/course-schedule-ii/solution/

public class P210 {
    // BFS - Kahn Algorithm
    // we enqueue vertices having the 0 incoming edges (in-degree)
    // then, we dequeue vertices and add it into solution array
    // time complexity: O(V + E)
    // space complexity: O(V + E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // represents the directed graph by using the adjacency list
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        // populate the adj from prerequisites (edges) array
        for (int[] edge : prerequisites) {
            int source = edge[1];
            int destination = edge[0];
            if (adj[source] == null) adj[source] = new ArrayList<>();
            // add the neighbor vertex into source vertex's list
            adj[source].add(destination);
            // AND update the source's in-degree along the way
            indegree[destination]++;
        }
        // enqueue vertices having 0 in-degree (courses that can be taken because all prerequisites are met)
        Queue<Integer> queue = new LinkedList<>();
        for (int vertex = 0; vertex < numCourses; vertex++) {
            if (indegree[vertex] == 0)
                queue.offer(vertex);
        }
        int[] ans = new int[numCourses];
        int i = 0;
        // dequeue vertices in the queue and enqueue its neighbours
        while (!queue.isEmpty()) {
            int source = queue.poll();
            ans[i++] = source;
            if (adj[source] == null) continue;
            for (int destination : adj[source]) {
                indegree[destination]--;
                if (indegree[destination] == 0)
                    queue.offer(destination);
            }
        }
        if (i < numCourses)
            return new int[0];
        return ans;
    }

    public static void main(String[] args) {
        P210 obj = new P210();
        int[] ans = obj.findOrder(2, new int[][]{{1, 0}});
        System.out.println("Expected: [0, 1]\n Received: " + Arrays.toString(ans));
        System.out.println("---");
        ans = obj.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println("Expected: [0, 2, 1, 3]\n Received: " + Arrays.toString(ans));
        System.out.println("---");
        ans = obj.findOrder(1, new int[][]{});
        System.out.println("Expected: [0]\n Received: " + Arrays.toString(ans));
        System.out.println("---");
        ans = obj.findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        System.out.println("Expected: []\n Received: " + Arrays.toString(ans));
    }
}
