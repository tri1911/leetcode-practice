package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Jan 16, 2022
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 */

// TODO: read official solution

public class P205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sDict = new HashMap<>();
        Map<Character, Integer> tDict = new HashMap<>();
        for (Integer i = 0; i < s.length(); i++) {
            if (sDict.put(s.charAt(i), i) != tDict.put(t.charAt(i), i)) return false;
        }
        return true;
    }
}

/**
 * reference
 * https://leetcode.com/problems/isomorphic-strings/solution/
 */