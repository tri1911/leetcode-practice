#include <iostream>
using namespace std;

// T0 = 0; T1 = 1; T2 = 1; Tn+3 = Tn + Tn+1 + Tn+2 (for n >= 0)
// 0 <= n <= 37
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1

// global counting the method calls
int count1 = 0;
int count2 = 0;

// recursion solution
int tribonacci(int n) {
	count1++;
	if (n == 0)
		 return 0;
	if (n == 1 || n == 2)
		return 1;
	return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
}

// memoization solution
int tribonacci(int n, int memo[]) {
	// check whether this subproblem was alredy solved
	if (memo[n] != -1)
		return memo[n];
	// solve
	count2++;
	if (n == 0) {
		memo[n] = 0;
		return memo[n];
	}
	if (n == 1 || n == 2) {
		memo[n] = 1;
		return memo[n];
	}
	memo[n]	= tribonacci(n - 3, memo) + tribonacci(n - 2, memo) + tribonacci(n - 1, memo);
	return memo[n];
}

// dynamic programming solution
int tribonacciUsingDynamicProgramming(int n) {
	if (n == 0)
		 return 0;
	if (n == 1 || n == 2)
		return 1;
	// solve
	int a = 0, b = 1, c = 1;
	int result;
	for (int i = 3; i <= n; i++) {
		result = a + b + c;
		a = b;
		b = c;
		c = result;
	}
	return result;
}

int main() {
	const int SIZE = 37;
	int n;

	cout << "Enter n: ";
	cin >> n;

	// memoization array
	int memo[SIZE + 1];

	while(n >= 0 && n <= 37) {
		// reset the counting
		count1 = count2 = 0;
		// reset memoization
		for (int i = 0; i <= SIZE; i++) {
			memo[i] = -1;
		}

		cout << "Answer (using recursion): " << tribonacci(n) << endl;
		cout << "Calls: " << count1 << " times" << endl;
		cout << endl;

		cout << "Answer (using memoization): " << tribonacci(n, memo) << endl;
		cout << "Calls: " << count2 << " times" << endl;
		cout << endl;

		cout << "Answer (using dynamic programming): " << tribonacciUsingDynamicProgramming(n) << endl;
		cout << endl;

		cout << "=============================================================" << endl;
		cout << "Enter n: ";
		cin >> n;
	}
	return 0;
}