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


// Another Solution made by myself on Fri, Nov 12, 2021
// Helper function
bool binarySearch(vector<int>& nums, int target) {
    int l = 0, r = nums.size() - 1, pivot;
    while (l <= r) {
        pivot = (l + r) / 2;
        if (target == nums[pivot])
            return true;
        if (target > nums[pivot])
            l = pivot + 1;
        else
            r = pivot - 1;
    }
    return false;
}

// T = O(m + log(n))
bool searchMatrix(vector<vector<int>>& matrix, int target) {
    int m = matrix.size(), n = matrix[0].size();
    // O(m)
    for (int i = 0; i < m; i++) {
        int first = matrix[i][0], last = matrix[i][n - 1];
        if (target >= first && target <= last) {
            // O(log(n))
            return (binarySearch(matrix[i], target));
        }
    }
    return false;
}