// 91. Decode Ways
// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"

// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" 
// can be mapped into:
// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
// Given a string s containing only digits, return the number of ways to decode it.
// The answer is guaranteed to fit in a 32-bit integer.

// Example 1:
// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

// Example 2:
// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

// Example 3:
// Input: s = "0"
// Output: 0
// Explanation: There is no character that is mapped to a number starting with 0.
// The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
// Hence, there are no valid ways to decode this since all digits need to be mapped.

// Example 4:
// Input: s = "06"
// Output: 0
// Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

// Constraints:
// 1 <= s.length <= 100
// s contains only digits and may contain leading zero(s).

int numDecodings(string s) {
	if (s[0] == '0') 
		return 0;
	int n = s.size();
    // possible decoded array might end with
    // 1-digit number (e.g. 12, 23, 2) or 2 digit (e.g. 12, 23, 2, 14)
	int one_digit_count = 1, two_digits_count = 0;
    // iterate through each index and update one_digit_count, two_digits_count
    // at the point the current character being added to the decoded array
	for (int i = 1; i < n; i++) {
		int current_char = s[i] - '0';
		int prev_char = s[i - 1] - '0';
		if (current_char == 0) {
			if (prev_char == 1 || prev_char == 2) {
				two_digits_count = one_digit_count;
				one_digit_count = 0;
			}
			else {
				return 0;
			}
		} else {
            // cache the old count for possibilities ending with 1-digit
			int tmp = one_digit_count; 
            // update one_digit_count and two_digits_count
			one_digit_count += two_digits_count;
			if (prev_char * 10 + current_char <= 26)
				two_digits_count = tmp;
			else
				two_digits_count = 0;
		}
	}
	return one_digit_count + two_digits_count;
}
