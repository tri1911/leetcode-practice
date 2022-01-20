package leetcodingchallenge.january2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Jan 17, 2022
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 */

public class P290 {
    // use dictionary
    // time: O(n)
    // space: O(n)
    public boolean wordPattern(String pattern, String s) {
        // key & value will be saved as Object if no use generics
        // 'b' and "b" will be saved as separated objects
        Map dict = new HashMap();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (Integer i = 0; i < words.length; i++) {
            // put return the previous associated key (null if the key is not added before)
            if (dict.put(words[i], i) != dict.put(pattern.charAt(i), i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P290 obj = new P290();
        System.out.println("Expected: true. Received: " + obj.wordPattern("abba", "dog cat cat dog"));
        System.out.println("Expected: false. Received: " + obj.wordPattern("abba", "dog cat cat fish"));
        System.out.println("Expected: false. Received: " + obj.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("Expected: false. Received: " + obj.wordPattern("abba", "dog dog dog dog"));
    }
}

/**
 * reference
 * https://leetde.com/problems/word-pattern/discuss/73402/8-lines-simple-Java
 */