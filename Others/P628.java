// Date: Nov 27, 2021
// 628. Maximum Product of Three Numbers
// https://leetcode.com/problems/maximum-product-of-three-numbers/

// Solution 1
// sorting approach
// time complexity: O(nlogn)
// space complexity: O(logn)
public int maximumProduct(int[] nums) {
	int n = nums.length;
	Arrays.sort(nums);
	return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
}

// Solution 2
// time complexity: O(n)
// space complexity: O(1)
public int maximumProduct(int[] nums) {
	// min1 < min2
	int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
	// max1 > max2 > max3
	int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

	for (int n: nums) {
		// update min1, min2
		if (n <= min1) {
			min2 = min1;
			min1 = n;
		} else if (n < min2) { // min1 < n < min2
			min2 = n;
		}

		// update max1, max2, max3
		if (n >= max1) {
			max3 = max2;
			max2 = max1;
			max1 = n;
		} else if (n >= max2) { // max2 <= n < max1
			max3 = max2;
			max2 = n;
		} else if (n > max3) { // max3 < n < max2
			max3 = n;
		}
	}
	return Math.max(min1 * min2 * max1, max1 * max2 * max3);
}