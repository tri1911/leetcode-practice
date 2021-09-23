// 304. Range Sum Query 2D - Immutable
// Given a 2D matrix matrix, handle multiple queries of the following type:
// Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

// Implement the NumMatrix class:
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix `matrix`.
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by 
// its upper left corner (row1, col1) and lower right corner (row2, col2).

// Example 1:
// Input
// ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
// [[[[3, 0, 1, 4, 2],
// 	[5, 6, 3, 2, 1],
// 	[1, 2, 0, 1, 5],
// 	[4, 1, 0, 1, 7],
// 	[1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
// Output
// [null, 8, 11, 12]
// Explanation
// NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
// numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
// numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
// numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// -10^5 <= matrix[i][j] <= 10^5
// 0 <= row1 <= row2 < m
// 0 <= col1 <= col2 < n
// At most 10^4 calls will be made to sumRegion.

// time complexity is O(m*n)
// space complexity is O(m*n)
class NumMatrix {
public:
    int rows;
    int cols;
    vector<vector<int>> prefix_sum;

    NumMatrix(vector<vector<int>> &matrix) {
        rows = matrix.size();
        cols = matrix[0].size();
        prefix_sum = vector<vector<int>>(rows + 1, vector<int>(cols + 1));
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                prefix_sum[row][col] =
                        prefix_sum[row - 1][col] + prefix_sum[row][col - 1] - prefix_sum[row - 1][col - 1] +
                        matrix[row - 1][col - 1];
            }
        }

    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        int n1 = prefix_sum[row2 + 1][col2 + 1];
        int n2 = prefix_sum[row1][col2 + 1];
        int n3 = prefix_sum[row2 + 1][col1];
        int n4 = prefix_sum[row1][col1];
        return prefix_sum[row2 + 1][col2 + 1] - prefix_sum[row1][col2 + 1] - prefix_sum[row2 + 1][col1] +
               prefix_sum[row1][col1];
    }
};

int main() {
    vector<vector<int>> matrix{{3, 0, 1, 4, 2},
                               {5, 6, 3, 2, 1},
                               {1, 2, 0, 1, 5},
                               {4, 1, 0, 1, 7},
                               {1, 0, 3, 0, 5}};
    NumMatrix *obj = new NumMatrix(matrix);
    cout << "Output (2, 1, 4, 3): " << obj->sumRegion(2, 1, 4, 3) << endl;
    cout << "Output (1,1,2,2): " << obj->sumRegion(1, 1, 2, 2) << endl;
    cout << "Output (1, 2, 2, 4): " << obj->sumRegion(1, 2, 2, 4) << endl;
    return 0;
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */