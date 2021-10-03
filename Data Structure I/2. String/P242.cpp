// Date: Sat, Oct 2, 2021
// 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)

// solution 1: hash table
// time complexity: O(n)
// Runtime: 8 ms, faster than 83.76% of C++ online submissions for Valid Anagram.
// space complexity: O(1)
// Memory Usage: 7.3 MB, less than 77.48% of C++ online submissions for Valid Anagram.
bool isAnagram(string s, string t) {
	if (s.length() != t.length()) return false;
	int hash[26] = {};
	for (char ch: s) {
		hash[ch-'a'] += 1;
	}
	for (char ch: t) {
		if (hash[ch-'a'] <= 0)
			return false;
		hash[ch-'a']--;
	}
	return true;
}

// solution 2: sorting
// time complexity: O(nlogn)
// space complexity: O(1)
bool isAnagram(string s, string t) {
	if (s.length() != t.length()) 
		return false;
	sort(s.begin(), s.end());
	sort(t.begin(), t.end());
	for (int i = 0; i < s.length(); i++)
		if (s[i] != t[i])
			return false;
	return true;
}