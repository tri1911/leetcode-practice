// Date: Thu, Oct 1, 2021
// Redo (did it in Dynamic Programming I already)
// 198. House Robber (https://leetcode.com/problems/house-robber/)

// dynamic programming approach
// idea: consider the nums array from 0 to ith index that is represented by dp[i] = max of:
// 	1. nums[i] + dp[i-2]
//	2. dp[i-1]
// So, if we know dp[i-1], dp[i-2] then we have the solution for dp[i]
// We can optimize the extra space complexity to O(1) by caching the dp[i-1] and dp[i-2]
int rob(vector<int>& nums) {
	int n = nums.size();
	if (n == 1) 
		return nums[0];
	int prev_prev = 0, prev = 0;
	for (int i = 0; i < n; i++) {
		int tmp = prev;
		prev = max(prev_prev + nums[i], prev);
		prev_prev = tmp;
	}
	return prev;
}