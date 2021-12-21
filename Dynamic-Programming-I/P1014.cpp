// 1014. Best Sightseeing Pair
// You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
// The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
// Return the maximum score of a pair of sightseeing spots.

// Example 1:
// Input: values = [8,1,5,2,6]
// Output: 11
// Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

// Example 2:
// Input: values = [1,2]
// Output: 2

// Constraints:
// 2 <= values.length <= 5 * 10^4
// 1 <= values[i] <= 1000

// we need to find: max of (a + b + i - j)
// the problem can be: max of (a + i + b - j)
int maxScoreSightseeingPair(vector<int>& values) {
	int n = values.size();
	// the current max value of left part
	int current_left = values[0] + 0;
	int ans = current_left + (values[1] - 1);
	for (int i = 2; i < n; i++) {
		current_left = max(current_left, values[i - 1] + (i - 1));
		ans = max(ans, current_left + (values[i] - i));
	}
	return ans;
}