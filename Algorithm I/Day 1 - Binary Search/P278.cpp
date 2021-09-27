// Date: Sun, Sep 26, 2021
// 278. First Bad Version (https://leetcode.com/problems/first-bad-version/)
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

int firstBadVersion(int n) {
	if (n == 1)
		return 1;
	int pivot, left = 1, right = n - 1;
	while (left <= right) {
		pivot = (left + right) / 2;
		if (isBadVersion(pivot)) {
			right = pivot - 1;
		} else {
			left = pivot + 1;
		}
	}
	// return isBadVersion(pivot) ? pivot : pivot + 1;
	return left;
}
