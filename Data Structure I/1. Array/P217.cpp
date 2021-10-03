// Date: Fri, Oct 1, 2021
// 217. Contains Duplicate (https://leetcode.com/problems/contains-duplicate/)

// sorting approach
// time complexity O(nlogn)
// space complexity O(1)
bool containsDuplicate(vector<int>& nums) {
	int n = nums.size();
	sort(nums.begin(), nums.end()); // take O(nlogn)
	for (int i = 1; i < n; i++) {
		if (nums[i-1] == nums[i])
			return true;
	}
	return false;
}

// hash table approach
bool containsDuplicate(vector<int>& nums) {
	set<int> s;
	for (int i: nums) {
		if (s.find(i) != s.end())
			return true;
		s.insert(i);
	}
	return false;
}