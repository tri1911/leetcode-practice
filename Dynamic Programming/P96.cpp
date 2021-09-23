// Date: Sat, Sep 18 2021

// 96. Unique Binary Search Trees
// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

// Example 1:
// Input: n = 3
// Output: 5

// Example 2:
// Input: n = 1
// Output: 1

// Constraints:
// 1 <= n <= 19

// dynamic programming approach
// time complexity: O(n^2) & Space complexity: O(n)
// iterate every nodes i in [1...n]
// compute the number of unique binary search tree with the ith node is the root
// e.g. for n = 3, if the node 1 is the root then the left subtree has the size of 0
// and the right subtree has the size of 2 (nodes 2 and 3)
// similarly, if the node 2 is the root then the left subtree has the size of 1 (node 1)
// and the right subtree has the size of 1 (node 3)
// we calculate the number of uniqe BST for each subtree
// the total number of unique BST for case i will be the number of left subtree * right subtree
// the global total number will be the sum of cases
int numTrees(int n) {
	// dp array to store the result of subtree having the size of i
	vector<int> dp(n + 1, 0);
	// base case
	dp[0] = 1;
	dp[1] = 1;
	// run n - 2 times
	// i is the size of subproblem (i = 2, 3, 4 ... n)
	for (int i = 2; i <= n; i++) {
		// run 2 + 3 + ... + n times = 
		// j is the index of the root node (j = 1, 2, 3 ... n)
		for (int j = 1; j <= i; j++) {
			// left subtree = from 1 to j - 1 = solution of the subproblem having the size of j - 1, which is dp[j - 1]
			// right subtree = from j + 1 to i = solution of the subproblem having the size of i - j, which is dp[i - j]
			// the product of these two results is the total number of unique BST for the root node j
			dp[i] += dp[j - 1] * dp[i - j];
		}
	}
	return dp[n];
}

// size i = 3
// root j = 1
// left = [] dp[0], right = [2,3] dp[2] => 1 * 2
// root j = 2
// left = [1] = dp[1], right = [3] = dp[1] => 1 * 1 
// root j = 3
// left = [1,2] dp[2], right = [] dp[0] => 2 * 1
// total = 2 + 1 + 2 = 5