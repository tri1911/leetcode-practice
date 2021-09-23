// Date: Wed, Sep 22, 2021
// 72. Edit Distance

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character

// Example 1:
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

// Example 2:
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')

// Constraints:
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.

// dynamic programming top-bottom approach
// time complexity of O(mn) and space complexity O(mn) or O(max(m, n))
int minDistance(string word1, string word2) {
	int n1 = word1.length(), n2 = word2.length();
	// dp(i, j) is the solution for suffix of word1 from i and suffix of word2 from j
	vector<vector<int>> dp(n1 + 1, vector<int>(n2 + 1));
	int replace_cost;
	for (int i = n1; i >= 0; i--) {
		for (int j = n2; j >= 0; j--) {
			if (i == n1)
				dp[i][j] = n2 - j;
			else if (j == n2)
				dp[i][j] = n1 - i;
			else {
				if (word1[i] == word2[j])
					dp[i][j] = dp[i + 1][j + 1];
				else
					dp[i][j] = min({ 1 + dp[i + 1][j + 1], 1 + dp[i][j + 1], 1 + dp[i + 1][j] });
			}
		}
	}
	return dp[0][0];
}

// solution: https://www.geeksforgeeks.org/edit-distance-dp-5/