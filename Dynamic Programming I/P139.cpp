// 139. Word Break
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.

// Example 3:
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

// Constraints:
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

bool isContain(string str, const vector<string>& wordDict) {
	if (str.empty())
		return true;
	for (string word: wordDict) {
		if (word.compare(str) == 0)
			return true;
	}
	return false;
}

// dynamic programming approach
// time complexity O(n^2) where n is the length of string (assume searching the word in the dictionary takes O(1) time complexity)
// space complexity O(n)
bool wordBreak(string s, vector<string>& wordDict) {
	int n = s.length();
	vector<bool> dp(n + 1);
	dp[n] = true;
	dp[n - 1] = isContain(s.substr(n - 1, 1), wordDict);
	for (int i = n - 2; i >= 0; i--) {
		for (int j = i + 1; j <= n; j++) {
			string prefix = s.substr(i, j - i);
			if (isContain(prefix, wordDict) && dp[j]) {
				dp[i] = true;
				break;
			}
		}
	}
	return dp[0];
}