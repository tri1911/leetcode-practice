// Date: Sun, Sep 26, 2021
// 704. Binary Search (https://leetcode.com/problems/binary-search/)

// time complexity: O(logn)
int search(vector<int>& nums, int target) {
	int pivot, left = 0, right = nums.size() - 1;
	while (left <= right) {
		pivot = (left + right) / 2;
		if (nums[pivot] == target)
			return pivot;
		if (nums[pivot] < target)
			left = pivot + 1;
		else
			right = pivot - 1;
	}
	return -1;
}