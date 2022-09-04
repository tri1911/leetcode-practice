package leetcodingchallenge.september2022;

import java.util.*;

/**
 * Date: September 04, 2022
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */

// TODO: analyze the time complexity

public class P987 {
    // the returned answer sorted in order: x -> y -> value
    // [x:[y:[value]]]
    private Map<Integer, TreeMap<Integer, List<Integer>>> map;
    private int lowX, highX;

    // use HashMap, TreeMap, DFS
    // time: __
    // space: O(n)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        lowX = highX = 0;
        // start from the root (x = 0, y = 0)
        dfs(root, 0, 0);
        // generate the answer from the map
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = lowX; x <= highX; x++) {
            List<Integer> col = new ArrayList<>();
            for (int y : map.get(x).keySet()) {
                Collections.sort(map.get(x).get(y));
                for (int val : map.get(x).get(y)) {
                    col.add(val);
                }
            }
            ans.add(col);
        }
        return ans;
    }

    // dfs traversal to record node's x, y, value
    private void dfs(TreeNode node, int x, int y) {
        if (node == null) return;
        // update the global range of x
        lowX = Math.min(lowX, x);
        highX = Math.max(highX, x);
        // store the current node's x, y, value into the map
        if (!map.containsKey(x)) map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, new ArrayList<>());
        map.get(x).get(y).add(node.val);
        // traverse to the next nodes
        dfs(node.left, x - 1, y + 1);
        dfs(node.right, x + 1, y + 1);
    }

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * References
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231125/Java-HashMap-and-TreeMap-and-PriorityQueue-Solution
 */
