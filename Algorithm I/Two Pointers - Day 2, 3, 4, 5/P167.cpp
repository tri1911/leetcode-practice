// Date: Mon, Sep 27, 2021
// 167. Two Sum II - Input array is sorted (https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

// time complexity: O(n)
// space complexity: O(1)
vector<int> twoSum(vector<int>& numbers, int target) {
	int left = 0, right = numbers.size() - 1;
	while (left < right) {
		int current = numbers[left] + numbers[right];
		if (current == target)
			return vector<int>{left + 1, right + 1};
		if (current > target)
			right--;
		else
			left++;
	}
	return vector<int>{-1, -1};
}