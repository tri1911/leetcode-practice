// Date: Mon, Sep 20, 2021

// 5. Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.

// Example 2:
// Input: s = "cbbd"
// Output: "bb"

// Example 3:
// Input: s = "a"
// Output: "a"

// Example 4:
// Input: s = "ac"
// Output: "a"

// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.

// dynamic programming approach
// time complexity O(n^2) & space complexity O(n^2)
// reuse palindrome checked substring
// e.g we will know whether dabad is a palindrome substring based on aba
// start from a -> bab -> dbabd (palindrome check of substring of length 3 is concluded from substring of length 1)
// or aa -> baab (palindrome check of substring of length 4 is concluded from substring of length 2)
string longestPalindrome(string s) {
	int length = s.length();
	// 2d dp array that stores the palindrome verification of the substring from i to j
	vector<vector<bool>> dp(length, vector<bool>(length, false));
	// base case
	// start with substring with the length of 1
	int max_start = 0;
	int max_length = 1;
	for (int i = 0; i < length; i++)
		dp[i][i] = true;

	// substring with the length of 2
	for (int i = 0; i < length - 1; i++) {
		if (s[i] == s[i + 1]) {
			dp[i][i+1] = true;
			max_length = 2;
			max_start = i;
		}
	}

	// other lengths (from 3 to length)
	for (int n = 3; n <= length; n++) {
		// length = 6, n = 3, 0 1 2 3 4 5 -> check from 0 to 3 -> upper limit = 6 - 3
		for (int start = 0; start <= length - n; start++) {
			// 0 to 2, 1 to 3 -> from start to start + n - 1
			int end = start + n - 1;
			if (dp[start+1][end-1] && s[start] == s[end]) {
				dp[start][end] = true;
				if (n > max_length) {
					max_length = n;
					max_start = start;
				}
			}
		}
	}
	return s.substr(max_start, max_length);
}

// another solution with space complexity O(1)
string longestPalindrome(string s) {
    int max_length = 0;
    int max_start = 0;
    int odd_length = 0, even_length = 0;
    int length = s.length();
    for (int i = 0; i < length; ++i) {
        // center of odd length
        int start = i;
        int end = i;
        while (start >= 0 && end < length && s[start] == s[end]) {
            start--;
            end++;
        }
        odd_length = end - start - 1;
        if (odd_length > max_length) {
            max_length = odd_length;
            max_start = start + 1;
        }

        // center of even length
        start = i;
        end = i + 1;
        while (start >= 0 && end < length && s[start] == s[end]) {
            start--;
            end++;
        }
        even_length = end - start - 1;
        if (even_length > max_length) {
            max_length = even_length;
            max_start = start + 1;
        }
    }
    return s.substr(max_start, max_length);
}