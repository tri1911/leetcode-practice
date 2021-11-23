// Date: Sun, Nov 21, 2021
// 701. Insert into a Binary Search Tree

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
	// time complexity: O(logn) where n is the number of nodes
	// space complexity: O(1)
    TreeNode* insertIntoBST(TreeNode* root, int val) {
    	TreeNode* nodeToInsert = new TreeNode(val);
        if (!root)
        	return nodeToInsert;
        TreeNode* previous = nullptr;
        TreeNode* current = root;
        while (current) {
    		previous = current;
        	if (val <= current->val)
        		current = current->left;
        	else
        		current = current->right;
        }
        if (val <= previous->val)
    		previous->left = nodeToInsert;
    	else
    		previous->right = nodeToInsert;
    	return root;
    }
};