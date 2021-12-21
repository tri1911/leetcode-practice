// 42. Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

// Constraints:
// n == height.length
// 1 <= n <= 2 * 10^4
// 0 <= height[i] <= 10^5

// dynamic programming approach
// for each elevation, the amount of trapping water will be min(max_left, max_right) - height
// the solution will ve solved by summing up the amount of water at all elevations
// time complexity O(n), space complexity O(n)
// int trap(vector<int>& height) {
// 	int size = height.size();
// 	if (size == 1) return 0;
// 	vector<int> max_left(size), max_right(size);
// 	max_left[1] = height[0];
// 	max_right[size - 2] = height[size - 1];
// 	for (int i = 2; i < size; i++) {
// 		max_left[i] = max(max_left[i - 1], height[i - 1]);
// 	}
// 	for (int i = size - 3; i >= 0; i--) {
// 		max_right[i] = max(max_right[i + 1], height[i + 1]);
// 	}
// 	int ans = 0;
// 	for (int i = 1; i < size - 1; i++) {
// 		ans += max(min(max_left[i], max_right[i]) - height[i], 0);
// 	}
// 	return ans;
// }

// dynamic programming approach with space complexity O(1)
int trap(vector<int>& height) {
	int size = height.size();
	if (size == 1) return 0;
	int p_left = 1, p_right = size - 2;
	int max_left = height[0];
	int max_right = height[size - 1];
	int ans = 0;
	while (p_left <= p_right) {
		if (max_left < max_right) {
			if (max_left > height[p_left])
				ans += max_left - height[p_left];
			max_left = max(height[p_left], max_left);
			p_left++;
		} else {
			if (max_right > height[p_right])
				ans += max_right - height[p_right];
			max_right = max(height[p_right], max_right);
			p_right--;
		}
	}
	return ans;
}