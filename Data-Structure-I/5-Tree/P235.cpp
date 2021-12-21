// Date: Sun, Nov 21, 2021 (Not done) => Redo on Dec 5, 2021
// 235. Lowest Common Ancestor of a Binary Search Tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    // time complexity: O(h) ~ O(logn)
    // space complexity: O(1)
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    	if (root->val > max(p->val, q->val))
            return lowestCommonAncestor(root->left, p, q);
        if (root->val < min(p->val, q->val))
            return lowestCommonAncestor(root->right, p, q);
        return root;
    }
};

// reference
// https://www.youtube.com/watch?v=TIoCCStdiFo