// Date: Tue, Sep 28, 2021
// 617. Merge Two Binary Trees (https://leetcode.com/problems/merge-two-binary-trees/)

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
	// time complexity: O(n) where n is the max length among two trees
	// space complexity: O(1)
   //  TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
   //  	TreeNode* head = nullptr;
   //      if (!root1 && root2) {
   //      	head = new TreeNode(root2->val);
			// head->left = mergeTrees(nullptr, root2->left);
			// head->right = mergeTrees(nullptr, root2->right);
   //      } else if (root1 && !root2) {
   //      	head = new TreeNode(root1->val);
   //      	head->left = mergeTrees(root1->left, nullptr);
			// head->right = mergeTrees(root1->right, nullptr);
   //      } else if (root1 && root2) {
   //      	head = new TreeNode(root1->val + root2->val);
   //      	head->left = mergeTrees(root1->left, root2->left);
			// head->right = mergeTrees(root1->right, root2->right);
   //      }
   //      return head;
   //  }

	// Revised version
    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
    	TreeNode* head = nullptr;
        if (!root1)
        	return root2;
        if (!root2)
        	return root1;
        root1->val += root2->val;
        root1->left = mergeTrees(root1->left, root2->left);
        root1->right = mergeTrees(root1->right, root2->right);
        return root1;
    }
};