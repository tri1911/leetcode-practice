// Min Cost Climbing Stairs
// You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
// Once you pay the cost, you can either climb one or two steps.
// You can either start from the step with index 0, or the step with index 1.
// Return the minimum cost to reach the top of the floor.

// Example 1:
// Input: cost = [10,15,20]
// Output: 15
// Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.

// Example 2:
// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].

// Constraints:
// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999

#include <iostream>
using namespace std;

// helper function
int min(int a, int b) {
	if (a > b)
		return b;
	else
		return a;
}

// recursion solution
// int minCostClimbingStairs(int cost[], int n) {
// 	if (n < 2)
// 		return 0;

// 	int first = minCostClimbingStairs(cost, n - 1) + cost[n - 1];
// 	int second = minCostClimbingStairs(cost, n - 2) + cost[n - 2];
// 	return min(first, second);
// }

// memoization solution
// helper function
// int minCostClimbingStairs(int cost[], int n, int memo[]) {
// 	if (memo[n] != -1)
// 		return memo[n];

// 	if (n < 2)
// 		return 0;

// 	int first = minCostClimbingStairs(cost, n - 1, memo) + cost[n - 1];
// 	int second = minCostClimbingStairs(cost, n - 2, memo) + cost[n - 2];
// 	memo[n] = min(first, second);
// 	return memo[n];
// }

// int minCostClimbingStairs(int cost[], int n) {
// 	int memo[n + 1];
// 	for (int i = 0; i <= n; i++)
// 		memo[i] = -1;
// 	return minCostClimbingStairs(cost, n, memo);
// }

// dynamic programming solution
int minCostClimbingStairs(int cost[], int n) {
	int first = 0;
	int second = 0;
	int result;

	for (int i = 2; i <= n; i++) {
		result = min(first + cost[i-2], second + cost[i-1]);
		first = second;
		second = result;
	}
	return result;
}

int main() {
	int cost[] = { 1,100,1,1,1,100,1,1,100,1 };
	cout << "Output: " << minCostClimbingStairs(cost, 10) << endl;
	return 0;
}