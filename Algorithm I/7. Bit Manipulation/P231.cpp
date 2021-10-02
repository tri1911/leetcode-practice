// Date: Fri, Oct 1, 2021
// 231. Power of Two (https://leetcode.com/problems/power-of-two/)

// bit manipulation approach
// the number if power of two should have only 1 bit having the value of 1
// e.g. x = 0100 (4) or 1000 (8) ...
// x - 1 = 0011 (3) or 0111 (7)
// x & (x-1) should be 0 if x is the power of two
// counter example: x = 1100 (12) -> x-1 = 1011 (11) -> x & (x-1) != 0
bool isPowerOfTwo(int n) {
	if (n <= 0)
		return false;
	return !(n & (n-1));
}
// reference: 
// https://www.hackerearth.com/practice/notes/bit-manipulation/
// https://www.geeksforgeeks.org/bit-tricks-competitive-programming/