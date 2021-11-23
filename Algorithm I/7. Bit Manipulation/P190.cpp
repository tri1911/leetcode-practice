// Date: Fri, Oct 1, 2021
// 190. Reverse Bits (https://leetcode.com/problems/reverse-bits/)

// to check the last bit is 1 using AND: (n & 1) == 1 (equals 0 otherwise)
// to flip the last bit using XOR: n ^= 1
// time complexity O(1)
// space complexity O(1)
uint32_t reverseBits(uint32_t n) {
	uint32_t ans = 0;
	for (int i = 0; i < 32; ++i) {
		ans <<= 1;
		if (n & 1)
			ans ^= 1;
		n >>= 1;
	}
	return ans;
}

// reference: 
// https://www.geeksforgeeks.org/reverse-actual-bits-given-number/