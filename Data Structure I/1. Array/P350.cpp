// Date: Sat, Oct 2, 2021
// 350. Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// 		- using solution 1 (with sorting)
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
//		- using solution 2 (with hash table)

// Solution 1: sorting
// time complexity: O(nlogn)
// space complexity: O(1)
vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
	int n1 = nums1.size(), n2 = nums2.size();
	// sorting takes O(nlogn) time
	sort(nums1.begin(), nums1.end());
	sort(nums2.begin(), nums2.end());
	int p1 = 0, p2 = 0;
	vector<int> ans;
	while (p1 < n1 && p2 < n2) {
		if (nums1[p1] == nums2[p2])
			ans.push_back(nums1[p1++]), p2++;
		else if (nums1[p1] > nums2[p2])
			p2++;
		else
			p1++;
	}
	return ans;
}

// Solution 2: hash table
// time complexity: O(m + n)
// space complexity: O(m + n)
vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
	if (nums1.size() > nums2.size())
		return intersect(nums2, nums1);
	// hash table contains the value and its frequency in array
	// choose the smaller array to hash
	unordered_map<int, int> hash;
	for (int num: nums1) {
		if (hash.find(num) != hash.end())
			hash[num] += 1;
		else
			hash[num] = 1;
	}
	vector<int> ans;
	// iterate through the second array to check whether there are duplicates with the first array
	for (int num: nums2) {
		if (hash.find(num) != hash.end() && hash[num] > 0) {
			ans.push_back(num);
			hash[num] -= 1;
		}
	}
	return ans;
}
