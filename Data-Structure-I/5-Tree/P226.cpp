// Date: Sun, Nov 21, 2021
// 226. Invert Binary Tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // Depth First Search approach
    // time complexity: O(n)
    // space complexity: O(1)
    void dfs(TreeNode* current) {
        if (!current)
            return;
        TreeNode* tmp = current->left;
        current->left = current->right;
        current->right = tmp;
        dfs(current->left);
        dfs(current->right);
    }

    TreeNode* invertTree(TreeNode* root) {
        if (!root)
            return nullptr;
        dfs(root);
        return root;
    }
};