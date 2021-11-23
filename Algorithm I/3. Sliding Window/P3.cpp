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

// Date: Sat, Nov 13, 2021
// dynamic programming, sliding window using unordered_map
// time complexity: O(n)
// space complexity: O(d)
int lengthOfLongestSubstring(string s) {
    if (s.size() == 0) 
        return 0;
    unordered_map<char, int> letters;
    int ans = 1, current_len = 1, begin_index = 0;
    letters[s[0]] = 0;
    for (int i = 1; i < s.size(); i++) {
        char current_char = s[i];
        if (letters.find(current_char) != letters.end()) {
            int prev_index = letters[current_char];
            if (prev_index >= begin_index) {
                current_len = i - prev_index;
                begin_index = prev_index + 1;
            } else {
                current_len++;
            }
        } else {
            current_len++;
        }
        ans = max(ans, current_len);
        letters[current_char] = i;
    }
    return ans;
}

// refactor
int lengthOfLongestSubstring(string s) {
    if (s.size() == 0) return 0;
    unordered_map<char, int> last_occurrences;
    int ans = 1, begin = 0;
    last_occurrences[s[0]] = 0;
    for (int end = 1; end < s.size(); end++) {
        char current_char = s[end];
        int prev_index = last_occurrences[current_char];
        if (prev_index >= begin)
            begin = prev_index + 1;
        ans = max(ans, end - begin + 1);
        last_occurrences[current_char] = end;
    }
    return ans;
}