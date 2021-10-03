// Date: Fri, Oct 1, 2021
// Redo (already did in Dynamic Programming I Plan before)
// 53. Maximum Subarray (https://leetcode.com/problems/maximum-subarray/)

// Dynamic programming approach (Kandae algorithm)
// time complexity O(n)
// space complexity O(1)
int maxSubArray(vector<int>& nums) {
	int n = nums.size();
    int ans = nums[0];
    int current = nums[0];
    for (int i = 1; i < n; i++) {
        current = max(current + nums[i], nums[i]);
        ans = max(ans, current);
    }
    return ans;
}