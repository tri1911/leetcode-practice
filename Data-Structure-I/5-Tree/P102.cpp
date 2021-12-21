// Date: Sun, Nov 21, 2021
// 102. Binary Tree Level Order Traversal

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
	// my own solution
	// time complexity: O(n) where n is the number of nodes
	// space complexity: O(n)
    vector<vector<int>> levelOrder(TreeNode* root) {
    	if (!root)
    		return {};

        vector<vector<int>> ans;

        queue<TreeNode*> my_queue;
        my_queue.push(root);

        while (!my_queue.empty()) {
        	queue<TreeNode*> tmp_queue;
        	vector<int> tmp_vector;
        	while(!my_queue.empty()) {
        		TreeNode* current = my_queue.front();
        		my_queue.pop();
        		if (current->left)
        			tmp_queue.push(current->left);
        		if (current->right)
        			tmp_queue.push(current->right);
				tmp_vector.push_back(current->val);
        	}
        	my_queue = tmp_queue;
        	ans.push_back(tmp_vector);
        }
        return ans;
    }
};