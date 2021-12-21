// Date: Sun, Nov 21, 2021
// 101. Symmetric Tree

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
	// my own solution using Breadth-First Search approach
	// time complexity: O(n) where n is the number of nodes
	// space complexity: O(n)
    bool isSymmetric(TreeNode* root) {
        if (!root->left && !root->right)
        	return true;
        queue<TreeNode*> my_queue;
        my_queue.push(root->left);
        my_queue.push(root->right);
        while(!my_queue.empty()) {
        	TreeNode* first = my_queue.front();
        	my_queue.pop();
        	TreeNode* second = my_queue.front();
        	my_queue.pop();
            
        	if ((first && !second) || (!first && second) || (first && second && first->val != second->val))
        		return false;
            
            if (first && second) {
                my_queue.push(first->left);
                my_queue.push(second->right);

                my_queue.push(first->right);
                my_queue.push(second->left);
            }
        }
        return true;
    }
};