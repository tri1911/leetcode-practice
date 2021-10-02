// Date: Fri, Oct 1, 2021
// 136. Single Number (https://leetcode.com/problems/single-number/)
// Constraint: linear runtime and constant extra space

int singleNumber(vector<int>& nums) {
	int ans = 0;
	for (int num: nums) {
		ans ^= num;
	}
	return ans;
}

// reference: 
// https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
https://www.geeksforgeeks.org/bits-manipulation-important-tactics/