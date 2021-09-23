// Date: Wed Sep 22, 2021
// 377. Combination Sum IV (https://leetcode.com/problems/combination-sum-iv/)

// recursion approach
// int combinationSum4(vector<int>& nums, int target) {
// 	if (target < 0)
// 		return 0;
// 	if (target == 0)
// 		return 1;
// 	int ans = 0;
// 	// the last added number is num
// 	for (int num: nums) {
// 		ans += combinationSum4(nums, target - num);
// 	}
// 	return ans;
// }

// memoization (top-bottom) approach
// time complexity O(target*n) where n is the size of nums
// space complexity O(target)
// helper function
int combinationSum4(vector<int>& nums, int target, vector<int>& memo) {
	if (target < 0)
		return 0;
	if (target == 0)
		return 1;
	if (memo[target] != -1)
		return memo[target];
	memo[target] = 0;
	// the last added number is num
	for (int num: nums) {
		memo[target] += combinationSum4(nums, target - num, memo);
	}
	return memo[target];
}

int combinationSum4(vector<int>& nums, int target) {
	vector<int> memo(target + 1, -1);
	return combinationSum4(nums, target, memo);
}

// TODO: dynamic programming (bottom-top) approach
// Failed: Exceeded limit runtime
// int combinationSum4(vector<int>& nums, int target) {
//     int n = nums.size();
//     vector<int> dp(target + 1);
//     for (int i = 1; i <= target; i++) {
//         for (int j = 0; j < n; j++) {
//             int remain = i - nums[j];
//             if (remain == 0)
//                 dp[i] += 1;
//             else if (remain > 0)
//                 dp[i] += dp[remain];
//         }
//     }
//     return dp[target];
// }