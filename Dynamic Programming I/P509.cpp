// compile: g++ sourcefile.cpp

#include <iostream>
using namespace std;

// global variable for counting recursively function calls
int calls = 0;

// recursion solution
// int fib(int n) {
// 	calls++;
// 	if (n == 0 || n == 1) 
// 		return n;
// 	return fib(n - 2) + fib(n - 1);
// }

// memoization solution
int fib(int n, int memo[]) {
	// check whether the subproblem was already solved
	if (memo[n] != -1)
		 return memo[n];
	calls++;
	// solve
	if (n == 0 || n == 1) {
		memo[n] = n;
		return memo[n];
	}
	memo[n] = fib(n - 2, memo) + fib(n - 1, memo);
	return memo[n];
}

// dynamic programming solution
int fib(int n) {
	if (n == 0 || n == 1)
		return n;

	int a = 0;
	int b = 1;
	int result;

	for (int i = 2; i <= n; i++) {
		result = a + b;
		a = b;
		b = result;
	}
	return result;
}

int main() {
	const int SIZE = 100;
	static int memo[SIZE];
	// init the memo array
	for (int i = 0; i < SIZE; i++) {
		memo[i] = -1;
	}
	cout << "Result (using dynamic programming): " << fib(11) << endl;
	cout << "Result (using memoization): " << fib(11, memo) << endl;
	// cout << "Calls count: " << calls << endl;
	return 0;
}