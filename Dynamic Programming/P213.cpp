// 213. House Robber II
// All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one
// Adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night
// Input: an integer array nums representing the amount of money of each house
// Output: the maximum amount of money you can rob tonight without alerting the police

// Example 1:
// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

// Example 2:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 3:
// Input: nums = [1,2,3]
// Output: 3

// Example 4:
// Input: nums = [1]
// Output: 1

// Constraints:
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000

#include <iostream>
#include <vector>

using namespace std;

// recursion solution
// helper function
// first: the first index; last: the last index
// int rob(vector<int> &nums, int first, int last) {
//     // base case
//     if (first == last)
//         return nums[first];
//     if (first > last)
//         return 0;
//     // recursive calls
//     int option1 = nums[last] + rob(nums, first, last - 2);
//     int option2 = nums[last - 1] + rob(nums, first, last - 3);
//     return max(option1, option2);
// }

// int rob(vector<int> &nums) {
//     // cannot rob House[1] and House[n] together
//     // rob either House[1]-House[n-1] or House[2]-House[n]
//     // max of these scenarios yields the desired result
//     int n = nums.size();
//     return max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
// }

// memoization solution
// helper function
// int rob(vector<int> &nums, int first, int last, vector<vector<int>> &memo) {
//     if (first > last)
//         return 0;

//     if (memo[first][last] != -1)
//         return memo[first][last];
//     // base case
//     if (first == last) {
//         memo[first][last] = nums[first];
//         return memo[first][last];
//     }
//     int option1 = nums[last] + rob(nums, first, last - 2, memo);
//     int option2 = nums[last - 1] + rob(nums, first, last - 3, memo);
//     memo[first][last] = max(option1, option2);
//     return memo[first][last];
// }

// int rob(vector<int> &nums) {
//     int n = nums.size();
//     // if the number of houses is 1, then return that house
//     if (n == 1)
//         return nums[0];
//     vector<vector<int>> memo;

//     for (int i = 0; i < n; i++) {
//         vector<int> v(n, -1);
//         memo.push_back(v);
//     }
//     return max(rob(nums, 0, n - 2, memo), rob(nums, 1, n - 1, memo));
// }

// dynamic programming solution
// failed test case:
// [0]
int rob(vector<int>& nums, int first, int last) {
    int option1 = 0, option2 = 0;
    int result;
    for (int i = first; i <= last; i++) {
        result = max(option1 + nums[i], option2);
        option1 = option2;
        option2 = result;
    }
    return result;
}

int rob(vector<int>& nums) {
    int n = nums.size();
    if (n == 1)
        return nums[0];
    return max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
}

int main() {
    vector<int> nums_1{2, 3, 2};
    cout << "Output 1: " << rob(nums_1) << endl;

    // vector<int> nums_2{1, 2, 3, 1};
    // cout << "Output 2: " << rob(nums_2) << endl;

    // vector<int> nums_3{1, 2, 3};
    // cout << "Output 3: " << rob(nums_3) << endl;

    return 0;
}