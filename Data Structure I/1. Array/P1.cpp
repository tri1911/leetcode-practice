// Date: Sat, Oct 2, 2021
// 1. Two Sum

// time complexity O(n)
// space complexity O(n)
vector<int> twoSum(vector<int>& nums, int target) {
	unordered_map<int, int> hash_table;
	for (int i = 0; i < nums.size(); i++) {
		int other = target - nums[i];
		if (hash_table.find(other) != hash_table.end())
			return { hash_table[other], i };
		hash_table[nums[i]] = i;
	}
	return {};
}

// reference: 
// https://www.geeksforgeeks.org/map-vs-unordered_map-c/
// https://www.cplusplus.com/reference/unordered_map/unordered_map/