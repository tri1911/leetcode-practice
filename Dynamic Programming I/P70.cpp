// Climbing Stairs
// takes n steps to reach the top
// either climb 1 or 2 steps
// how many distinct ways?
// 1 <= n <= 45

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step


#include <iostream>
using namespace std;

// Recursion Solution
// the final climbing maybe 1 or 2 steps
// if the final climbing = 1, then climbing (n - 1) steps -> how many ways to reaching (n - 1) steps
// that is: climbStairs(n-1) ways
// if the final climbing = 2, then climbing (n - 2) steps -> how many ways to reaching (n - 2) steps
// that is: climbStairs(n-2) ways
// result: climbStairs(n-1) + climbStairs(n-2) ways
int climbStairs_recursion(int n) {
	// base cases
	if (n < 0)
		return 0;
	if (n == 0)
		return 1;
	return climbStairs_recursion(n - 1) + climbStairs_recursion(n - 2);
}

// Memoization Solution
// Helper function
int climbStairs(int n, int memo[]) {
    // base cases
    if (n < 0)
        return 0;
    if (n == 0)
        return 1;
    // check
    if (memo[n] != -1)
        return memo[n];

    memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    return memo[n];
}

int climbStairs(int n) {
    int memo[n + 1];
    for (int i = 0; i <= n; i++)
		memo[i] = -1;
    return climbStairs(n, memo);
}

int main() {
	int n;

	cout << "Input: ";
	cin >> n;

	while (n >= 1 && n <= 45) {
		cout << "Output: " << climbStairs_recursion(n) << endl;
		cout << "Output: " << climbStairs(n) << endl;
		cout << endl;

		cout << "Input: ";
		cin >> n;
	}
	
	return 0;
}