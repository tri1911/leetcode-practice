// Date: Fri, Oct 1, 2021
// 191. Number of 1 Bits

// bit manipulation approach
// time complexity O(k) where k is the number of 1s
int hammingWeight(uint32_t n) {
	int count = 0;
	while (n) {
		count++;
		n &= n-1;
	}
	return count;
}

// reference: https://www.hackerearth.com/practice/notes/bit-manipulation/