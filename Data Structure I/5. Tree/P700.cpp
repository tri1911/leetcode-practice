// Date: Sun, Nov 21, 2021
// 700. Search in a Binary Search Tree

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
	// depth-first search approach
	// time complexity: O(n)
	// space complexity: O(1)
    TreeNode* searchBST(TreeNode* root, int val) {
    	if (!root)
    		return nullptr;
        if (root->val == val)
        	return root;
        if (root->val < val)
        	return searchBST(root->right, val);
        return searchBST(root->left, val);
    }
};