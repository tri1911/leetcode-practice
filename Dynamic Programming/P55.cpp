// 55. Jump Game
// You are given an integer array nums. You are initially positioned at the array's first index,
// and each element in the array represents your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

// Constraints:
// 1 <= nums.length <= 10^4
// 0 <= nums[i] <= 10^5

#include <iostream>
#include <vector>
using namespace std;

// Failed test case:
// [ 13055, 19141, 12848, 11888, 1185, 9905, 3984, 14772, 18935, 6844, 9851, 13695, 17955, 16359, 14969,
// 6200, 13436, 16940, 13893, 1639, 3233, 11861, 13475, 11963, 8193, 3413, 10952, 8585, 13807, 6320,
// 4507, 1743, 454, 7983, 9677, 8348, 2496, 4585, 11022, 9103, 1096, 6770, 6745, 4350, 2334, 13024,
// 2738, 9444, 1028, 5337, 2446, 272, 5799, 7397, 15000, 4848, 16772, 12860, 11773, 196, 3187, 14016,
// 1314, 1684, 19858, 2598, 16111, 10577, 1643, 12252, 5835, 2819, 17898, 18210, 799, 5010, 19937,
// 1285, 9693, 18155, 484, 9184, 7212, 3474, 14630, 18418, 10108, 1735, 3940, 2877, 18007, 14731,
// 10133, 10470, 15396, 7464, 6936, 261 ]

// Failed Test Case:
// [2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4
// ,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]

// Old solution using memoization; not efficient
// bool canJump(vector<int>& nums, int last, vector<int>& memo) {
//     if (memo[last] != -1)
//         return memo[last] == 1;
//     cout << "Check for last = " << last << endl;
//     if (last == 0)
//         return true;
//     for (int distance = 1; distance <= last; distance++) {
//         int index = last - distance;
//         int max_jump = nums[index];
//         if (max_jump >= distance && canJump(nums, index, memo)) {
//             return true;
//         }
//     }
//     memo[last] = 0;
//     return memo[last] == 1;
// }

// bool canJump(vector<int>& nums) {
//     vector<int> memo(nums.size(), -1);
//     return canJump(nums, nums.size() - 1, memo);
// }

// Time complexity: O(n); Space complexity: O(1)
bool canJump(vector<int>& nums) {
	// the last index/position
	int last = nums.size() - 1;
	// the maximum index can reach
	int max_reach = 0;
	// e.g. [2, 3, 1, 1, 4]: from the position 0, the farthest reaching is 2 (= 0 + 2)
	// from the position 1, can reach 4 (= 1 + 3); we can return true right here
	for (int position = 0; position < last && position <= max_reach; position++) {
		// update the max_reach
		max_reach = max(nums[position] + position, max_reach);
		// return immediately if we can reach the last index
		if (max_reach >= last)
			return true;
	}
	return max_reach >= last;
}

// Solution 20 ms
// bool canJump(vector<int>& nums) {
//     ios::sync_with_stdio(0);
//     cin.tie(0);
//     cout.tie(0);
    
//     int maxjump = 0 ;
//     int n = nums.size() ;
    
//     for (int i = 0; i < n; i++) {
//         if (maxjump >= n - 1)
//             return true;
        
//         if(maxjump == i and nums[i] == 0)
//         	return false;
        
//         maxjump = max(maxjump, i + nums[i]) ;
//     }
//     return false ;
// }

int main() {
	vector<int> nums { 2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,
		9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6 };
	cout << "Output: " << canJump(nums) << endl;
	return 0;
}