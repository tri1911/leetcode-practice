// 1567. Maximum Length of Subarray With Positive Product
// Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
// A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
// Return the maximum length of a subarray with positive product.

// Example 1:
// Input: nums = [1,-2,-3,4]
// Output: 4
// Explanation: The array nums already has a positive product of 24.
// Example 2:

// Input: nums = [0,1,-2,-3,-4]
// Output: 3
// Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
// Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.

// Example 3:
// Input: nums = [-1,-2,-3,0,1]
// Output: 2
// Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].

// Example 4:
// Input: nums = [-1,2]
// Output: 1

// Example 5:
// Input: nums = [1,2,3,5,-6,4,0,10]
// Output: 4

// Constraints:
// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9

#include <iostream>
#include <vector>

using namespace std;

// failed test case: 
// [1000000000,1000000000]
// runtime error
// signed integer overflow: 1000000000 * 1000000000 cannot be represented in type 'int' (current_product)

// Attempt 1
// [5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2]
// Wrong answer (Output: 6 - Expected: 8) - [-10,-7,21,20,-12,-34,26,2]
// int getMaxLen(vector<int> &nums) {
//     int ans = 0;
//     int count = 0;
//     long int current_product = 1;

//     for (int value: nums) {
//         count++;
//         current_product *= value;
//         if (current_product > 0)
//             ans = max(count, ans);

//         if (value > 0)
//             ans = max(1, ans);

//         if (value == 0) {
//             count = 0;
//             current_product = 1;
//         }
//     }
//     return ans;
// }

// Attempt 2
// [1,2,3,5,-6,4,0,10]
// Wrong answer (Output: 5 - Expected: 4) 
// int getMaxLen(vector<int> &nums) {
//     int ans = 0;
//     int num_count = 0;
//     int minus_count = 0;
//     for (int value: nums) {
//         if (value == 0) {
//             ans = max(ans, num_count - (minus_count % 2));
//             num_count = 0;
//             minus_count = 0;
//             continue;
//         } else if (value < 0) {
//             minus_count++;
//         }
//         num_count++;
//     }
//     ans = max(ans, num_count - (minus_count % 2));
//     return ans;
// }

// Attempt 3 (Using Dynamic Programming)
int getMaxLen(vector<int> &nums) {
	int ans = 0, current_positive = 0, current_negative = 0;
	for(int value : nums) {
		if (value == 0) {
			current_positive = current_negative = 0;
		} else if (value > 0) {
			current_positive++;
			// e.g. 0 1 ...
			if (current_negative != 0)
				current_negative++;
			ans = max(ans, current_positive);
		} else {
			swap(current_positive, current_negative);
			current_negative++;
			// e.g. 0 -1 ...
			if (current_positive != 0)
				current_positive++;
			ans = max(ans, current_positive);
		}
	}
	return ans;
}

int main() {
    vector<int> nums{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2};
    cout << "Output: " << getMaxLen(nums) << endl;
    return 0;
}

// Good solution explaination for dynamic programming
// https://www.youtube.com/watch?v=FqpfLr76a1k
