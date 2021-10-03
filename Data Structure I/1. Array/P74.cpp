// Date: Sat, Oct 2, 2021
// 74. Search a 2D Matrix (https://leetcode.com/problems/search-a-2d-matrix/)

// idea: using binary search
// time complexity: O(logmn)
// space complexity: O(1)
bool searchMatrix(vector<vector<int>>& matrix, int target) {
	int m = matrix.size(), n = matrix[0].size();
	int low = 0, high = m * n - 1;
	while (low <= high) {
		int pivot = (high + low) / 2;
		int value = matrix[pivot/n][pivot%n];
		if (value == target)
			return true;
		if (target > value)
			low = pivot + 1;
		else
			high = pivot - 1;
	}
	return false;
}