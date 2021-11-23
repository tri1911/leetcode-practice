// Date: Wed, Oct 6, 2021
// 145. Binary Tree Postorder Traversal (https://leetcode.com/problems/binary-tree-postorder-traversal/)

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

// recursive approach
// time complexity O(n)
// space complexity O(n)
void helper(vector<int>& ans, TreeNode* current) {
    if (current) {
        helper(ans, current->left);
        helper(ans, current->right);
        ans.push_back(current->val);
    }
}

vector<int> postorderTraversal(TreeNode* root) {
    vector<int> ans;
    helper(ans, root);
    return ans;
}

// 