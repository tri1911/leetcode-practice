// Date: Wed, Oct 6, 2021
// 94. Binary Tree Inorder Traversal

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
// space complexity: if count call stacks then in the worst case O(n); average case is O(logn)
void helper(vector<int>& ans, TreeNode* current) {
	if (current) {
		helper(ans, current->left);
		ans.push_back(current->val);
		helper(ans, current->right);
	}
}

vector<int> inorderTraversal(TreeNode* root) {
	vector<int> ans;
	helper(ans, root);
	return ans;
}

// iterative approach using stack
// time complexity O(n)
// space complexity O(n)
vector<int> inorderTraversal(TreeNode* root) {
	vector<int> ans;
	stack<TreeNode*> nodes;
	TreeNode* cur = root;
	while(cur || !nodes.empty()) {
		while (cur) {
			nodes.push(cur);
			cur = cur->left;
		}
		cur = nodes.top();
		nodes.pop();
		ans.push_back(cur->val);
		cur = cur->right;
	}
	return ans;
}