// Date: Tue, Sep 28, 2021
// 3. Longest Substring Without Repeating Characters (https://leetcode.com/problems/permutation-in-string/)

// sliding window technique
// time complexity O(n)
// space complexity O(d)
int lengthOfLongestSubstring(string s) {
	int n = s.size();
	int ans = 0, begin = 0;
	vector<int> last_occurrence(256, -1);
	for (int end = 0; end < n; end++) {
		int last_seen_index = last_occurrence[s[end]];
		if (last_seen_index >= begin)
			begin = last_seen_index + 1;
		last_occurrence[s[end]] = end;
		ans = max(ans, end - begin + 1);
	}
	return ans;
}