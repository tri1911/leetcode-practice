// 53. Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// Example 2:
// Input: nums = [1]
// Output: 1

// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23

// Constraints:
// 1 <= nums.length <= 3 * 10^4
// -10^5 <= nums[i] <= 10^5

int maxSubArray(vector<int>& nums) {
	int max_sum = nums[0];
	int current_sum = nums[0];
	for (int i = 1; i < nums.size(); i++) {
		// there are two scenarios:
		// 1. the subarray is extended with the current element
		// 2. the current element makes up a new subarray
		// choose the one has the greater sum value
		current_sum = max(current_sum + nums[i], nums[i]);
		max_sum = max(current_sum, max_sum);
	}
	return max_sum;
}