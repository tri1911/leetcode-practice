// 119. Pascal's Triangle II
// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it

// Example 1:
// Input: rowIndex = 3
// Output: [1,3,3,1]
//      1
//     1 1
//   1  2  1 -> 1 3 1
// 1   3  3  1

// Example 2:
// Input: rowIndex = 0
// Output: [1]

// Example 3:
// Input: rowIndex = 1
// Output: [1,1]

// Constraints:
// 0 <= rowIndex <= 33

// Time complexity O(n^2) (1 + 2 + 3 + ... + n + 1) & Space complexity: O(1)
vector<int> getRow(int rowIndex) {
    vector<int> ans(rowIndex + 1);
    int previous, current;
    for (int i = 0; i <= rowIndex; i++) {
        for (int j = 0; j <= i; j++) {
            previous = current;
            current = ans[j];
            if (j == 0 || j == i)
                ans[j] = 1;
            else
                ans[j] = current + previous;
        }
    }
    return ans;
}