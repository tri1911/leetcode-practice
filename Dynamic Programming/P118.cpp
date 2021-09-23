// 118. Pascal's Triangle
// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it.

// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Example 2:
// Input: numRows = 1
// Output: [[1]]

// Constraints:
// 1 <= numRows <= 30

// T(n) = O(n^2)
vector<vector<int>> generate(int numRows) {
	vector<vector<int>> ans(numRows);
	ans[0].push_back(1);
	for (int i = 1; i < numRows; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0 || j == i)
				ans[i].push_back(1);
			else
				ans[i].push_back(ans[i - 1][j - 1] + ans[i - 1][j]);
		}
	}
	return ans;
}