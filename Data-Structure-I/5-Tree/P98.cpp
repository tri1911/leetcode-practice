// Date: Nov 30, 2021
// 98. Validate Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// TODO
// Improved solution using iterative inorder traversal
// time complexity:
// space complexity: 
bool isValidBST(TreeNode* root) {

}

// helper function that add value of tree nodes in sorted order
void inorder(TreeNode* root, vector<int>& arr) {
	if (root) {
		inorder(root->left, arr);
		arr.push_back(root->val);
		inorder(root->right, arr);
	}
}

// time complexity: O(n)
// space complexity: O(n)
bool isValidBST(TreeNode* root) {
	vector<int> treeAsArr;
	inorder(root, treeAsArr);
	for(int i = 1; i < treeAsArr.size(); i++) {
		if (treeAsArr[i-1] >= treeAsArr[i])
			return false;
	}
	return true;
}

