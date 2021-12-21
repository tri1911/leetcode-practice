// Date: Thu, Oct 1, 2021
// 46. Permutations (https://leetcode.com/problems/permutations/)

// recursion approach
// time complexity O(n!)
// space complexity O(1)
void dfs(vector<vector<int>>& ans, vector<int>& nums, int i) {
	if (i == nums.size())
		ans.push_back(nums);
	else {
		for (int j = i; j < nums.size(); j++) {
			swap(nums[i], nums[j]);
			dfs(ans, nums, i + 1);
			swap(nums[i], nums[j]);
		}
	}
}

vector<vector<int>> permute(vector<int>& nums) {
	vector<vector<int>> ans;
	dfs(ans, nums, 0);
	return ans;
}