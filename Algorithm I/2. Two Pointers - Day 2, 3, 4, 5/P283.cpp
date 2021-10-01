// Date: Mon, Sep 27, 2021
// 283. Move Zeroes

// my solution
// time complexity O(n)
// space complexity O(1)
void moveZeroes(vector<int>& nums) {
	int n = nums.size();
	int count = 0;
	for (int i = 0; i < n; i++) {
		if (nums[i] == 0)
			count++;
		else
			nums[i-count] = nums[i];
	}

	for (int i = n - count; i < n; i++) {
		nums[i] = 0;
	}
}

// two-pointer approach
// before slow pointer: non-zeros
// slow pointer - current: zeros
void moveZeroes(vector<int>& nums) {
	// ios::sync_with_stdio(false);
	// cin.tie(nullptr);
	for (int current = 0, lastZeroPosition = 0; current < nums.size(); current++) {
		if (nums[current] != 0)
			nums[lastZeroPosition++] = nums[current];
	}
}
