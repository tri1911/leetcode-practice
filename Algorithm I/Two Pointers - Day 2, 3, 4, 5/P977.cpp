// Date: 
// 977. Squares of a Sorted Array (https://leetcode.com/problems/squares-of-a-sorted-array/)

// method 1
// time complexity O(n)
// space complexity O(n)
vector<int> sortedSquares(vector<int>& nums) {
	int n = nums.size();
	vector<int> ans(n);
	int i = 0;
	int positive = 0, negative;
	while (positive < n && nums[positive] < 0)
		positive++;
	negative = positive - 1;
	while (positive < n && negative >= 0) {
		int n1 = nums[positive] * nums[positive];
		int n2 = nums[negative] * nums[negative];
		if ( n1  > n2) {
			ans[i] = n2;
			negative--;
		} else {
			ans[i] = n1;
			positive++;
		}
		i++;
	}
	while (negative >= 0) {
		ans[i] = nums[negative] * nums[negative];
		negative--;
		i++;
	}
	while (positive < n) {
		ans[i] = nums[positive] * nums[positive];
		positive++;
		i++;
	}
	return ans;
}

// method 2
vector<int> sortedSquares(vector<int>& nums) {
	int n = nums.size();
	int left = 0, right = n - 1;
	vector<int> ans(n);
	for (int i = n - 1; i >= 0; i--) {
		int n1 = nums[left] * nums[left];
		int n2 = nums[right] * nums[right];
		if (n1 > n2) {
			ans[i] = n1;
			left++;
		} else {
			ans[i] = n2;
			right--;
		}
	}
	return ans;
}

// solution: https://www.geeksforgeeks.org/sort-array-converting-elements-squares/