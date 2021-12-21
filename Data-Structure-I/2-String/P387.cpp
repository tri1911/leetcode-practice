// Date: Sat, Oct 2, 2021
// 387. First Unique Character in a String (https://leetcode.com/problems/first-unique-character-in-a-string/submissions/)

// time complexity: O(n)
// space complexity: O(1)
int firstUniqChar(string s) {
	int hash[26] = {};
	// fill data to the hash table
	for (int i = 0; i < s.length(); i++)
		hash[s[i] - 'a'] += 1;
	// search for the target index
	for (int i = 0; i < s.length(); i++)
		if (hash[s[i] - 'a'] == 1)
			return i;
	return -1;
}