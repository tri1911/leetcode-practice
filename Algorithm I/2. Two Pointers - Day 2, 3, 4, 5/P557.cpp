// Date: Mon, Sep 27, 2021
// 557. Reverse Words in a String III (https://leetcode.com/problems/reverse-words-in-a-string-iii/)

// time complexity O(n)
// space complexity O(1)
string reverseWords(string s) {
	int n = s.size(), left = 0, right = 0;
	while (left < n) {
		// takes O(n) time
		while (s[right] != ' ' && right < n)
			right++;
		// takes O(n) time
		reverse(s.begin() + left, s.begin() + right);
		left = ++right;
	}
	return s;
}
