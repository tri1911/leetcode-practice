// Date: Mon, Sep 27, 2021
// 189. Rotate Array (https://leetcode.com/problems/rotate-array/)

// method 1
// time complexity: O(n)
// space complexity: O(n)
void rotate(vector<int>& nums, int k) {
	int n = nums.size();
	vector<int> tmp(n);
	for (int i = 0; i < n; i++) {
		tmp[(i + k) % n] = nums[i];
	}
	nums = tmp;
}

// int n = nums.size();
// int current = 0, next;
// int current_value = nums[current], tmp;
// for (int i = 0; i < n; i++) {
// 	next = (current + k) % n;
// 	tmp = nums[next];
// 	nums[next] = current_value;
// 	current = next;
// 	current_value = tmp;
// }

// method 2
// time complexity: O(n)
// space complexity: O(1)
void reverse(vector<int>& nums, int first, int last) {
	for (; first < last; first++, last--)
		swap(nums[first], nums[last]);
}

void rotate(vector<int>& nums, int k) {
	int size = nums.size();
	int steps = k % size;
	reverse(nums, 0, size - 1);
	reverse(nums, 0, steps - 1);
	reverse(nums, steps, size - 1);
}

// TODO: Juggling Algorithm