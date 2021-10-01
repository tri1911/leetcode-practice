// Date: Thu, Sep 30, 2021
// 77. Combinations (https://leetcode.com/problems/combinations/)

// recursion approach (do by myself)
// helper function to combine the number at begin number to the rest of elements in the list
void helper(vector<vector<int>>& ans, vector<int>& tmp, int begin, int n, int k) {
	if (k == 0) {
		ans.push_back(tmp);
		return;
	}
	for (int i = begin; i <= n - k + 1; i++) {
		tmp.push_back(i);
		helper(ans, tmp, i + 1, n, k - 1);
		tmp.pop_back();
	}
}

vector<vector<int>> combine(int n, int k) {
	vector<vector<int>> ans;
	vector<int> tmp;
	helper(ans, tmp, 1, n, k);
	return ans;
}

// solution: https://www.geeksforgeeks.org/make-combinations-size-k/