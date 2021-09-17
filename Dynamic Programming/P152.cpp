// 152. Maximum Product Subarray
// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
// It is guaranteed that the answer will fit in a 32-bit integer.
// A subarray is a contiguous subsequence of the array.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

// Constraints:
// 1 <= nums.length <= 2 * 10^4
// -10 <= nums[i] <= 10
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// failed test case:
// [-2,3,-4]

int maxProduct(vector<int>& nums) {
	int n = nums.size();
	int global_max, current_max, current_min;
	global_max = current_max = current_min = nums[0];
	
	int choice1, choice2;

	for (int i = 1; i < n; i++) {
		int value = nums[i];
		choice1 = current_max * value;
		choice2 = current_min * value;
		current_max = max(value, max(choice1, choice2));
		current_min = min(value, min(choice1, choice2));
		global_max = max(global_max, current_max);
	}
	return global_max;
}