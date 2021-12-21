// Date: Sat, Oct 2, 2021
// Redo (Did it in Dynamic Programming I)
// 118. Pascal's Triangle (https://leetcode.com/problems/pascals-triangle/)

// time complexity: O(n^2) <- T(n) = 1 + 2 + 3 + ... + n where n is numRows
// extra space complexity: O(1)
vector<vector<int>> generate(int numRows) {
	vector<vector<int>> ans;
	ans.push_back({1});
	for (int i = 1; i < numRows; i++) {
		vector<int> cur(i + 1);
		for (int j = 0; j < i + 1; j++) {
			if (j == 0 || j == i)
				cur[j] = 1;
			else 
				cur[j] = ans[i-1][j-1] + ans[i-1][j];
		}
		ans.push_back(cur);
	}
	return ans;
}