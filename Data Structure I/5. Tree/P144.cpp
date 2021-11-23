// Date: Mon, Oct 5, 2021
// 144. Binary Tree Preorder Traversal (https://leetcode.com/problems/binary-tree-preorder-traversal/)

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
// space complexity O(1)
void dfs(TreeNode* current, vector<int>& ans) {
	if (!current)
		return;
	ans.push_back(current->val);
	dfs(current->left, ans);
	dfs(current->right, ans);
}

vector<int> preorderTraversal(TreeNode* root) {
	vector<int> ans;
	dfs(root, ans);
	return ans;
}

// iterative approach 1
// time complexity O(n)
// space complexity O(n)
vector<int> preorderTraversal(TreeNode* root) {
	vector<int> ans;
	stack<TreeNode*> nodeStack;
	nodeStack.push(root);
	while(!nodeStack.empty()) {
		TreeNode* cur = nodeStack.top();
		ans.push_back(cur->val);
		nodeStack.pop();
		if (cur->right)
			nodeStack.push(cur->right); 
		if (cur->left)
			nodeStack.push(cur->left);
	}
	return ans;
}

// iterative approach 2
// time complexity O(n)
// space complexity O(h) where h is the height of the tree
vector<int> preorderTraversal(TreeNode* root) {
	vector<int> ans;
	stack<TreeNode*> nodeStack;
	TreeNode* cur = root;
	while (cur || !nodeStack.empty()) {
		while (cur) {
			ans.push_back(cur->val);
			if (cur->right)
				nodeStack.push(cur->right);
			cur = cur->left;
		}
		if (!nodeStack.empty()) {
			cur = nodeStack.top();
			nodeStack.pop();
		}
	}
	return ans;
}

// reference: 
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// https://www.geeksforgeeks.org/iterative-preorder-traversal/