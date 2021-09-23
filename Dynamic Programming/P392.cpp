// Date: Tue, Sep 21, 2021
// 392. Is Subsequence (https://leetcode.com/problems/is-subsequence/)

// Example 1:
// Input: s = "abc", t = "ahbgdc"
// Output: true

// Example 2:
// Input: s = "axc", t = "ahbgdc"
// Output: false

bool isSubsequence(string s, string t) {
	int n_t = t.length();
	int n_s = s.length();
	int p_s = 0;
	int p_t = 0;
	while(p_t < n_t && p_s < n_s) {
		if (s[p_s] == t[p_t])
			p_s++;
		p_t++;
	}
	return p_s == n_s;
}