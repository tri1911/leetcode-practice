// Date: Nov 27, 2021
// 611. Valid Triangle Number
// https://leetcode.com/problems/valid-triangle-number/

// sorting approach
// time complexity O(n^2)
// space complexity O(1)
public int triangleNumber(int[] nums) {
	int n = nums.length;
	if (n < 3) {
		return 0;
	}
	int ans = 0;
	// takes O(nlogn)
	Arrays.sort(nums);
	// outer loop takes O(n)
	// fix first point
	for (int i = 0; i < n - 2; i++) {
		if (nums[i] != 0) {
			int k = i + 2;
			// k and j takes O(2n) in total => nested loop takes O(n)
			// fix second point
			for (int j = i + 1; j < n - 1; j++) {
				// do not need to reintialize k for new j
				// because nums[new j] > nums[old j] => old k's automatically satisfied
				while (k < n && nums[i] + nums[j] > nums[k])
					k++;
				ans += k - j - 1;
			}
		}
	}

	return ans;
}