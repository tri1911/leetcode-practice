package others;

/**
 * Date: Jan 10, 2022
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */

// TODO: checkout for the better implementation (with constant space complexity)
// https://leetcode.com/problems/reverse-words-in-a-string/discuss/47740/In-place-simple-solution
// https://leetcode.com/problems/reverse-words-in-a-string/discuss/47720/Clean-Java-two-pointers-solution-(no-trim(-)-no-split(-)-no-StringBuilder)


public class P151 {
    // use StringBuilder
    // time complexity: O(n) where n is the string length
    // space complexity: O(n)
    public String reverseWords(String s) {
        final StringBuilder ans = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        int right = s.length() - 1, left;
        // just one pass loop
        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ')
                right--;
            left = right;
            while (left >= 0 && s.charAt(left) != ' ')
                word.append(s.charAt(left--));
            if (left != right)
                ans.append(word.reverse().append(' '));
            word.setLength(0); // empty the string builder
            right = left - 1; // update start pointer the for the next iteration
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
    }

    public static void main(String[] args) {
        P151 obj = new P151();
        System.out.println("Expected: blue is sky the.\nReceived: " + obj.reverseWords("the sky is blue") + ".");
        System.out.println("---");
        System.out.println("Expected: world hello.\nReceived: " + obj.reverseWords("  hello world  ") + ".");
        System.out.println("---");
        System.out.println("Expected: example good a.\nReceived: " + obj.reverseWords("a good   example") + ".");
        System.out.println("---");
        System.out.println("Expected: elliot.\nReceived: " + obj.reverseWords(" elliot   ") + ".");
        System.out.println("---");
        System.out.println("Expected: e.\nReceived: " + obj.reverseWords(" e   ") + ".");
    }
}

/*
    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:
    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

/*  Solution sample - Use built-in functions - https://leetcode.com/problems/reverse-words-in-a-string/discuss/47781/Java-3-line-builtin-solution
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
 */

/**
 * reference
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/solution/
 * https://stackoverflow.com/questions/5192512/how-can-i-clear-or-empty-a-stringbuilder
 */