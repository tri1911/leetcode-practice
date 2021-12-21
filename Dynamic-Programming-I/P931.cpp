// 931. Minimum Falling Path Sum
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
// A falling path starts at any element in the first row and chooses the element in the next row that 
// is either directly below or diagonally left/right. Specifically, the next element from position (row, col)
// will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Example 1:
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum underlined below:
// [[2,"1",3],      [[2,"1",3],
//  [6,"5",4],       [6,5,"4"],
//  ["7",8,9]]       [7,"8",9]]

// Example 2:
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is underlined below:
// [["-19",57],
//  ["-40",-5]]

// Example 3:
// Input: matrix = [[-48]]
// Output: -48

// Constraints:
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100

// attempt 1
// failed test case
// [[100,-42,"-46",-41],
//  [31,97,"10",-10],
//  [-58,"-51",82,89],
//  ["51",81,69,-51]]
// int minFallingPathSum(vector<vector<int>> &matrix) {
//     int n = matrix.size();
//     if (n == 1)
//         return matrix[0][0];
//     int ans = 0;
//     int column_min, column_min_pos;
//     for (int row = 0; row < n; row++) {
//         int first = row == 0 ? 0 : max(0, column_min_pos - 1);
//         int last = row == 0 ? n - 1 : min(n - 1, column_min_pos + 1);
//         column_min = matrix[row][first];
//         column_min_pos = first;
//         for (int column = first + 1; column <= last; column++) {
//             if (matrix[row][column] < column_min) {
//                 column_min = matrix[row][column];
//                 column_min_pos = column;
//             }
//             if (column == last) {
//                 ans += column_min;
//             }
//         }
//     }
//     return ans;
// }

// attempt 2 using dynamic programming
// time complexity: O(n^2) & space complexity: O(n)
// int minFallingPathSum(vector<vector<int>> &matrix) {
// 	int n = matrix.size();
// 	if (n == 1) return matrix[0][0];
// 	vector<int> dp(matrix[0].begin(), matrix[0].end());
// 	for (int row = 1; row < n; row++) {
// 		int tmp = dp[0];
// 		dp[0] = matrix[row][0] + min(dp[0], dp[1]);
// 		for (int col = 1; col < n; col++) {
// 			int previous = min(tmp, dp[col]);
// 			if (col + 1 <= n - 1)
// 				previous = min(previous, dp[col + 1]);
// 			tmp = dp[col];
// 			dp[col] = matrix[row][col] + previous;
// 		}
// 	}
// 	int ans = dp[0];
// 	for (int i = 1; i < n; i++)
// 		ans = min(ans, dp[i]);
// 	return ans;
// }

// use the matrix grid yields O(1) space complexity (in-place)
int minFallingPathSum(vector<vector<int>> &matrix) {
	int n = matrix.size();
	for (int row = 1; row < n; row++) {	
		for (int col = 0; col < n; col++) {
			int best = matrix[row - 1][col];
			if (col > 0) 
				best = min(best, matrix[row - 1][col - 1]);
			if (col < n - 1) 
				best = min(best, matrix[row - 1][col + 1]);
			matrix[row][col] += best;
		}
	}
	int ans = matrix[n - 1][0];
	for (int i = 1; i < n; i++)
		ans = min(ans, matrix[n - 1][i]);
	return ans;
}

int main() {
    // vector<vector<int>> matrix{{2, 1, 3},
    //                            {6, 5, 4},
    //                            {7, 8, 9}};
	vector<vector<int>> matrix{{-19, 57},
							   {-40, -5}};

    // vector<vector<int>> matrix{{100, -42, -46, -41},
    //                            {31,  97,  10,  -10},
    //                            {-58, -51, 82,  89},
    //                            {51,  81,  69,  -51}};
    cout << "Output: " << minFallingPathSum(matrix) << endl;    
    return 0;
}