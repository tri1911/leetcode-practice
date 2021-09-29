// Date: Mon, Sep 27, 2021
// 344. Reverse String (https://leetcode.com/problems/reverse-string/)

// time complexity O(n)
// space complexity O(1)
void reverseString(vector<char>& s) {
	for(int left = 0, right = s.size() - 1; left < right; left++, right--)
		swap(s[left], s[right]);
}