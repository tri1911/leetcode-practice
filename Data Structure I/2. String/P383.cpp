// Date: Sat, Oct 2, 2021
// 383. Ransom Note (https://leetcode.com/problems/ransom-note/)

// Solution 1: sorting & 2 pointers
// time compleixty O(nlogn)
// space complexity O(1)
bool canConstruct(string ransomNote, string magazine) {
	sort(ransomNote.begin(), ransomNote.end());
	sort(magazine.begin(), magazine.end());
	int p1 = 0, p2 = 0;
	int n1 = ransomNote.length(), n2 = magazine.length();
	while (p1 < n1 && p2 < n2) {
		if (ransomNote[p1] == magazine[p2])
			p1++;
		p2++;
	}
	return p1 == n1;
}

// Solution 2: Hash Table (Better)
// time complexity: O(n) where n is the length of magazine string
// Runtime: 8 ms, faster than 98.15% of C++ online submissions for Ransom Note.
// space complexity: O(1)
// Memory Usage: 8.8 MB, less than 38.91% of C++ online submissions for Ransom Note.
bool canConstruct(string ransomNote, string magazine) {
	int hash[26] = {};
	for (char ch: magazine) {
		hash[ch-'a'] += 1;
	}
	for (char ch: ransomNote) {
		if (hash[ch-'a'] <= 0)
			return false;
		hash[ch-'a']--;
	}
	return true;
}