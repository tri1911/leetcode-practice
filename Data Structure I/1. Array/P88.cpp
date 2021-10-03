// Date: Sat, Oct 2, 2021
// 88. Merge Sorted Array (https://leetcode.com/problems/merge-sorted-array/)

// Example: 
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]

// solution 1
// moving forward using temp
// time complexity O(m+n)
// space complexity O(m)
void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
	int p1 = 0, p2 = 0, i = 0;
	vector<int> tmp(nums1.begin(), nums1.begin() + m);
	while (p1 < m && p2 < n) {
		if (tmp[p1] <= nums2[p2])
			nums1[i++] = tmp[p1++];
		else
			nums1[i++] = nums2[p2++];
	}
	while (p1 < m)
		nums1[i++] = tmp[p1++];

	while (p2 < n)
		nums1[i++] = nums2[p2++];
}

// solution 2
// moving backward without using temp
// time complexity O(m+n)
// space complexity O(m)
void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
	int p1 = m-1, p2 = n-1, i = m + n - 1;
	while (p1 >= 0 && p2 >= 0) {
		if (nums1[p1] >= nums2[p2])
			nums1[i--] = nums1[p1--];
		else
			nums1[i--] = nums2[p2--];
	}
	while (p1 >= 0)
		nums1[i--] = nums1[p1--];
	while (p2 >= 0)
		nums1[i--] = nums2[p2--];
}

// concise version
void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
	int p1 = m-1, p2 = n-1, i = m + n - 1;
	while (p2 >= 0)
		nums1[i--] = p1 >= 0 && nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
}