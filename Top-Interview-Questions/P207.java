package topInterviewQs;

// Date: Jan 8, 2022
// 207. Course Schedule
// https://leetcode.com/problems/course-schedule/

import java.util.*;

// TODO: Review Topological sort + find out about better implementation
// https://en.wikipedia.org/wiki/Topological_sorting
// https://www.youtube.com/watch?v=Q9PIxaNGnig
// https://www.geeksforgeeks.org/topological-sorting/
// https://iq.opengenus.org/topological-sort-bfs/
// https://iq.opengenus.org/topological-sorting-dfs/

public class P207 {
    // topological sort with BDF
    // time complexity: O(V + E)
    // space complexity: O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisites represent edges and numCourses represents number of vertices
        // adjacency list represents the directed graph
        List<Integer>[] adj = new List[numCourses];
        // in-degree = 0 indicates that all prerequisites of ith vertex was completed
        int[] indegree = new int[numCourses];
        // build the adjacency list and update vertices' in-degree - takes O(E)
        for (int[] prerequisite : prerequisites) {
            // each prerequisite represents an edge u->v where u = prerequisite[1] and v = prerequisite[0]
            int u = prerequisite[1];
            int v = prerequisite[0];
            if (adj[u] == null) adj[u] = new ArrayList<>();
            adj[u].add(v);
            indegree[v]++;
        }
        // enqueue vertices having 0 in-degree into the queue - takes O(V)
        Queue<Integer> queue = new LinkedList<>();
        for (int vertex = 0; vertex < numCourses; vertex++) {
            if (indegree[vertex] == 0) {
                queue.offer(vertex);
            }
        }
        // this variable keeps track the number of courses you are able to finish
        // note that a course will be considered as finished if all their prerequisites were completed (in-degree = 0)
        int count = 0;
        // process vertices in the queue one by one - takes O(V + E)
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            if (adj[u] == null) continue;
            // iterate though adjacent vertices
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        P207 obj = new P207();
        System.out.println("Expected: false. Received: " + obj.canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
        System.out.println("Expected: true. Received: " + obj.canFinish(2, new int[][]{{1, 0}}));
        System.out.println("Expected: true. Received: " + obj.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }
}

// reference
// https://www.youtube.com/watch?v=rG2-_lgcZzo
// https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
