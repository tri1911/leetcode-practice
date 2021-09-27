// 45. Jump Game II
// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Your goal is to reach the last index in the minimum number of jumps.
// You can assume that you can always reach the last index.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2

// Constraints:
// 1 <= nums.length <= 10^4
// 0 <= nums[i] <= 1000

#include <iostream>
#include <vector>

using namespace std;

// Attempt 1
// Failed Test Case:
// [7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]

// int jump(vector<int>& nums) {
// 	int last = nums.size() - 1;
// 	int max_reach = 0, min_jump = 0;

// 	for (int position = 0; position < last && position <= max_reach; position++) {
// 		if (position + nums[position] > max_reach) {
// 			min_jump++;
// 			max_reach = position + nums[position];
// 		}
// 		if(max_reach >= last)
// 			return min_jump;
// 	}
// 	return min_jump;
// }

// Attempt 2
int jump(vector<int> &nums) {
    if (nums.size() == 1)
        return 0;
    if (nums[0] == 0)
        return -1;
    
    int last = nums.size() - 1;
    int min_jump = 0, max_reach = 0, end = 0;

    for (int current = 0; current < last && current <= max_reach; current++) {
        max_reach = max(current + nums[current], max_reach);
        if (max_reach >= last)
            return min_jump + 1;
        if (current == end) {
            min_jump++;
            end = max_reach;
        }
    }
    return -1;
}

int main() {
    vector<int> nums{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
    cout << "Output: " << jump(nums) << endl;

    return 0;
}