// 198. House Robber
// automatically contact the police if two adjacent houses were broken into on the same night
// Input: array nums representing the amount of money of each house
// Output: return the maximum amount of money you can rob tonight without alerting the police

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.

// Example 3:
// Input: nums = [2,1,1,2]
// Output: 4

// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

#include <iostream>
#include <vector>
using namespace std;

// helper function
// int max(int a, int b) {
// 	if (a > b)
// 		return a;
// 	else
// 		return b;
// }

// recursion solution
// int rob(int nums[], int n) {
// 	// base case
// 	if (n <= 0)
// 		return 0;
// 	if (n == 1)
// 		return nums[0];
// 	total++;
// 	int first = nums[n - 1] + rob(nums, n - 2);
// 	int second = nums[n - 2] + rob(nums, n - 3);
// 	return max(first, second);
// }

// memoization solution
// helper function
// int rob(int nums[], int n, int memo[]) {
// 	// base case
// 	if (n <= 0)
// 		return 0;
// 	if (memo[n] != -1)
// 		return memo[n];
// 	if (n == 1) {
// 		memo[n] = nums[0];
// 		return memo[n];
// 	}
// 	int first = nums[n - 1] + rob(nums, n - 2, memo);
// 	int second = nums[n - 2] + rob(nums, n - 3, memo);
// 	memo[n] = max(first, second);
// 	return memo[n];
// }

// int rob(int nums[], int n) {
// 	// memoization array
// 	int memo[n + 1];
// 	for (int i = 1; i <= n; i++) {
// 		memo[i] = -1;
// 	}
// 	return rob(nums, n, memo);
// }

// dynamic programming solution
int rob(vector<int>& nums) {
	int size = nums.size();
	int first = 0, second = 0;
	int result;
	for (int i = 0; i < size; i++) {
		result = max(first + nums[i], second);
		first = second;
		second = result;
	}
	return result;
}

int main() {
	int nums1[] = { 1, 2, 3, 1 };
	cout << "Output 1: " << rob(nums1, 4) << endl;

	int nums2[] = { 2, 7, 9, 3, 1 };
	cout << "Output 2: " << rob(nums2, 5) << endl;

	int nums3[] = { 2, 1, 1, 2 };
	cout << "Output 3: " << rob(nums3, 4) << endl;

	
	int nums4[] = { 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2 };
	cout << "Output 4: " << rob(nums4, 31) << endl;

	return 0;
}
