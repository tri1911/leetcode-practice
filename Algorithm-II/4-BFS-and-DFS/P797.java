package algorithm2.bdfAndDfs;

// date: Dec 16, 2021
// 797. All Paths From Source to Target
// https://leetcode.com/problems/all-paths-from-source-to-target/

import java.util.List;
import java.util.ArrayList;

// TODO: analyze the time & space complexity

// time complexity: O(V + E)
// space complexity: O(V)
public class P797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfs(graph, 0, currentPath, paths);
        return paths;
    }

    private void dfs(int[][] graph, int startNode, List<Integer> currentPath, List<List<Integer>> paths) {
        if (startNode == graph.length - 1) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        for (int adjacentNode : graph[startNode]) {
            currentPath.add(adjacentNode);
            dfs(graph, adjacentNode, currentPath, paths);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        P797 p = new P797();
        System.out.println("Expect: [[0, 1, 3], [0, 2, 3]].\nOutput: " + p.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println("Expect: [[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]].\nOutput: " + p.allPathsSourceTarget(new int[][]{
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
    }
}

// reference
// https://www.youtube.com/watch?v=UlH8zUjyi5s