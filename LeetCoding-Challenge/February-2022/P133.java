package leetcodingchallenge.february2022;

import javafx.util.Pair;
import java.util.*;

/**
 * Date: Feb 23, 2022
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 */

// TODO: find the better approach (like no hash map)

public class P133 {
    // my own solution
    // time: O(E + V) where E = # of edges & V = # of vertices
    // space: O(V)
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node ans = new Node(node.val);
        // a queue to store unvisited nodes to examine (along with its clone) - space: O(V)
        Queue<Pair<Node, Node>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(node, ans));
        // a dictionary to record clone nodes by its value - space: O(V)
        Map<Integer, Node> cloneNodes = new HashMap<>();
        cloneNodes.put(ans.val, ans);
        // a set to mark visited nodes - space: O(V)
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);
        while (!queue.isEmpty()) {
            Pair<Node, Node> head = queue.poll();
            Node currentOriginal = head.getKey();
            Node currentClone = head.getValue();
            for (Node neighbor : currentOriginal.neighbors) {
                int val = neighbor.val;
                Node cloneNeighbor;
                if (!cloneNodes.containsKey(val)) {
                    cloneNeighbor = new Node(val);
                    cloneNodes.put(val, cloneNeighbor);
                } else {
                    cloneNeighbor = cloneNodes.get(val);
                }
                // add unvisited node into the queue (along with its clone)
                if (!visited.contains(val)) {
                    queue.offer(new Pair<>(neighbor, cloneNeighbor));
                    visited.add(val);
                }
                // add clone neighbors
                currentClone.neighbors.add(cloneNeighbor);
            }
        }
        return ans;
    }

    // Definition for a Node.
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
