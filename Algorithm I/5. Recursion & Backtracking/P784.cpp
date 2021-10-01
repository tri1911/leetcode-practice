// Date: Thu, Sep 30, 2021
// 784. Letter Case Permutation (https://leetcode.com/problems/letter-case-permutation/)
// solution: https://dev.to/seanpgallivan/solution-letter-case-permutation-5dgn

void dfs(vector<string>& ans, string& s, int i, int len) {
	if (i == len)
		ans.push_back(s);
	else {
		dfs(ans, s, i + 1, len);
		if (isalpha(s[i])) {
			s[i] = isupper(s[i]) ? tolower(s[i]) : toupper(s[i]);
			dfs(ans, s, i + 1, len);
		}
	}
}

vector<string> letterCasePermutation(string s) {
	vector<string> ans;
	dfs(ans, s, 0, s.length());
	return ans;
}
