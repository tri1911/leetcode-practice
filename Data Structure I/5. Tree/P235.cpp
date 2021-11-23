// Date: Sun, Nov 21, 2021
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    	// takes O(logn)
        TreeNode* prev_p = nullptr;
        TreeNode* current_p = root;
        while (current_p) {
        	if (p == current_p->val)
        		break;
        	prev_p = current_p;
        	if (p < current_p->val)
        		current_p = current_p->left;
        	else
        		current_p = current_p->right;
        }

        // takes O(logn)
        TreeNode* prev_q = root;
        TreeNode* current_q;
        while (current_q) {
        	if (p == current_q->val)
        		break;
        	prev_q = current_q;
        	if (p < current_q->val)
        		current_q = current_q->left;
        	else
        		current_q = current_q->right;
        }

    }
};