// Date: Nov 29, 2021
// 204. Count Primes
// https://leetcode.com/problems/count-primes/

// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

// time complexity: O(n)?
// space complexity: O(n)
int countPrimes(int n) {
	vector<bool> isPrime(n, true);
	for (int p = 2; p * p < n; p++) {
		if (isPrime[p]) {
			for (int j = p; p * j < n; j++) {
				isPrime[p * j] = false;
			}
		}
	}
	int ans = 0;
	for (int i = 2; i < n; i++) {
		if (isPrime[i]) ans++;
	}
	return ans;
}
