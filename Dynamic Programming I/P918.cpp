// 918. Maximum Sum Circular Subarray
// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
// A circular array means the end of the array connects to the beginning of the array.
// Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
// A subarray may only include each element of the fixed buffer nums at most once. 
// Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

// Example 1:
// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3

// Example 2:
// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

// Example 3:
// Input: nums = [3,-1,2,-1]
// Output: 4
// Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

// Example 4:
// Input: nums = [3,-2,2,-3]
// Output: 3
// Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

// Example 5:
// Input: nums = [-2,-3,-1]
// Output: -1
// Explanation: Subarray [-1] has maximum sum -1

// Constraints:
// n == nums.length
// 1 <= n <= 3 * 10^4
// -3 * 10^4 <= nums[i] <= 3 * 10^4

// we check 2 scenerios
// 1. use Kandae's algorithm to find max sum subarray as normal
// 2. for subarray that given by wrapping around, calculate the max sum with: sum_all - min
int maxSubarraySumCircular(vector<int>& nums) {
	int n = nums.size();
	int global_max, global_min, current_max, current_min, sum_all;
	int current_value = nums[0];
	global_max = global_min = current_max = current_min = sum_all = current_value;

	for (int i = 1; i < n; i++) {
		int value = nums[i];
		// add current value to sum_all
		sum_all += value;
		// update global max
		current_max = max(0, current_max) + value;
		global_max = max(current_max, global_max);
		// update global min
		current_min = min(0, current_min) + value;
		global_min = min(current_min, global_min);
	}
	// corner case: all elements have negative value
	if (sum_all == global_min)
		return global_max;
	return max(global_max, sum_all - global_min);
}