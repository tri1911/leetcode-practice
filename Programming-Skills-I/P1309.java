package programmingSkills1;

/**
 * Date: March 22, 2022
 * 1309. Decrypt String from Alphabet to Integer Mapping
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */

public class P1309 {
    // time: O(n)
    // space: O(1)
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            int val = s.charAt(i) - '0';
            if (i <= len - 3 && s.charAt(i + 2) == '#') {
                val = 10 * val + (s.charAt(i + 1) - '0');
                i += 3;
            } else {
                i++;
            }
            sb.append((char) (val - 1 + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P1309 obj = new P1309();
        System.out.println("Expected: jkab. Received: " + obj.freqAlphabets("10#11#12"));
        System.out.println("Expected: acz. Received: " + obj.freqAlphabets("1326#"));
    }
}
