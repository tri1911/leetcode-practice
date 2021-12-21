// Date: Sat, Oct 2, 2021
// 566. Reshape the Matrix (https://leetcode.com/problems/reshape-the-matrix/)

// My idea:
// 4x2
// 00 will be 0*2+0 = 0 -> pattern: row * cols + col
// 01 will be 0*2+1 = 1
// 10 will be 1*2+0 = 2
// 11 will be 1*2+1 = 3
// 20 will be 2*2+0 = 4
// 20 will be 2*2+1 = 5
// 30 will be 3*2+0 = 6
// 31 will be 3*2+1 = 7
// 1x4
// 0123
// 4567
// 12 will find out by 1 = 6 / 4 and 2 = 6 % 4 -> pattern: row = x / cols and col = x % cols

// time complexity: O(mn)
// space complexity: O(1)
vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
	int m = mat.size(), n = mat[0].size();
	if (m*n != r*c) 
		return mat;
	vector<vector<int>> ans(r, vector<int>(c));
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			int num = i * n + j;
			ans[num/c][num%c] = mat[i][j];
		}
	}
	return ans;
}