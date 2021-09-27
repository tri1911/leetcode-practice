// Date: Sun, Sep 26, 2021
// 35. Search Insert Position

// time complexity O(logn)
// space complexity O(1)
int searchInsert(vector<int>& nums, int target) {
	int pivot, left = 0, right = nums.size() - 1;
	while (left <= right) {
		pivot = (left + right) / 2;
		if (nums[pivot] == target)
			return pivot;
		if (nums[pivot] > target)
			right = pivot - 1;
		else
			left = pivot + 1;
	}
	return left;
}