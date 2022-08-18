package leetcodingchallenge.august2022;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: August 17, 2022
 * 804. Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/
 */

public class P804 {
    // time: O(n)
    // space: O(n)
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
            StringBuilder transformation = new StringBuilder();
            for (char ch : word.toCharArray()) {
                transformation.append(codes[ch - 'a']);
            }
            transformations.add(transformation.toString());
        }
        return transformations.size();
    }
}
