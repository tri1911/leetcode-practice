// Date: Sun, Nov 21, 2021
// 653. Two Sum IV - Input is a BST

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
    // first try using inorder traversal + 2 pointer approach
    // time complexity: O(n) where n is the number of nodes
    // space complexity: O(n)
    void inorderTraversal(TreeNode* current, vector<int>& v) {
        if (!current)
            return;
        if (current->left)
            inorderTraversal(current->left, v);
        v.push_back(current->val);
        if (current->right)
            inorderTraversal(current->right, v);
    }

    bool findTarget(TreeNode* root, int k) {
        // convert the tree into a sorted array using inorder traversal
        vector<int> v;
        inorderTraversal(root, v);
        int left = 0, right = v.size() - 1;
        while (left != right) {
            int sum = v[left] + v[right];
            if (sum == k)
                return true;
            if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
};