package programmingSkills1;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: March 19, 2022
 * 589. N-ary Tree Preorder Traversal
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */

// TODO: implement `iterative` solution

public class P589 {
    private List<Integer> ans;

    // time: O(n)
    // space:O(n)
    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        backtracking(root);
        return ans;
    }

    private void backtracking(Node root) {
        ans.add(root.val);
        for (Node child : root.children) backtracking(child);
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
