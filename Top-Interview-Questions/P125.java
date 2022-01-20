package topInterviewQs;

/**
 * Date: Jan 10, 2022
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */

public class P125 {
    // time complexity: O(n)
    // space complexity: O(n)
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray())
            if (Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        P125 obj = new P125();
        System.out.println("Expected: false. Received: " + obj.isPalindrome("race a car"));
    }
}

/*
    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
 */