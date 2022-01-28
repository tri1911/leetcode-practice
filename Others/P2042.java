package others;

/**
 * Date: Jan 27, 2022
 * 2042. Check if Numbers Are Ascending in a Sentence
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 */

public class P2042 {
    // time: O(n)
    // space: O(n)
    public boolean areNumbersAscending(String s) {
        int prev = 0;
        for (String token : s.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                int cur = Integer.parseInt(token);
                if (cur <= prev) return false;
                prev = cur;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P2042 obj = new P2042();
        System.out.println("Expected: false. Received: " + obj.areNumbersAscending("hello world 5 x 5"));
    }
}
