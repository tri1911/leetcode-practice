// Date: Tue, Sep 28, 2021
// 567. Permutation in String (https://leetcode.com/problems/permutation-in-string/)

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

// Constraints:
// 1 <= s1.length, s2.length <= 10^4
// s1 and s2 consist of lowercase English letters.

// sliding window technique
// time complexity: O(n)
// space complexity: O(1)
bool checkInclusion(string s1, string s2) {
	int n1 = s1.size(), n2 = s2.size();

	if (n1 > n2) 
		return false;

	string s1_representation = "";
	string s2_representation = "";
	for (int i = 0; i < 26; i++) {
		s1_representation += '0';
		s2_representation += '0';
	}

	for (int i = 0; i < n1; i++) {
		s1_representation[s1[i] - 'a'] += 1;
		s2_representation[s2[i] - 'a'] += 1;
	}

	if (s1_representation == s2_representation)
		return true;

	for(int i = n1; i < n2; i++) {
		s2_representation[s2[i - n1] - 'a'] -= 1;
		s2_representation[s2[i] - 'a'] += 1;
		if (s1_representation == s2_representation)
			return true;
	}

	return false;
}