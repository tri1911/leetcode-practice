// 120. Triangle
// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row,
//  you may move to either index i or index i + 1 on the next row.

// Example 1:
// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

// Example 2:
// Input: triangle = [[-10]]
// Output: -10

// Constraints:
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -10^4 <= triangle[i][j] <= 10^4

// Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

int minimumTotal(vector<vector<int>>& triangle) {
	int rows = triangle.size();
	for (int row = 1; row < rows; row++) {
		int cols = triangle[row].size();
		for (int col = 0; col < cols; col++) {
			int best = INT_MAX;
			if (col > 0)
				best = triangle[row - 1][col - 1];
			if (col < cols - 1)
				best = min(best, triangle[row - 1][col]);
			triangle[row][col] += best;
		}
	}
	int ans = triangle[rows - 1][0];
	for(int col = 1; col < triangle[rows - 1].size(); col++)
		ans = min(ans, triangle[rows - 1][col]);
	return ans;
}