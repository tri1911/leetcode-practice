// Date: Sat, Nov 21, 2021
// 112. Path Sum

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
    // Depth-First Search algorithm
    // time complexity: O(n)
    // space complexity: O(1)
    bool dfs(TreeNode* current, int currentSum, int targetSum) {
        if (!current->left && !current->right)
            return (currentSum + current->val) == targetSum;
        currentSum += current->val;
        bool result = false;
        if (current->left)
            result = result || dfs(current->left, currentSum, targetSum);
        if (current->right)
            result = result || dfs(current->right, currentSum, targetSum);
        return result;
    }
    
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (!root)
            return false;
        return dfs(root, 0, targetSum);
    }
};