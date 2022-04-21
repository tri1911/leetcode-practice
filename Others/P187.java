package others;

import java.util.*;

/**
 * Date: April 20, 2022
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences
 */

public class P187 {
    // my first attempt - using Map
    // time & space: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub) && map.get(sub) == 1) ans.add(sub);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        return ans;
    }

    // use Set
    // time & space: O(n)
    public List<String> _findRepeatedDnaSequences(String s) {
        if (s.length() > 10_000) return new ArrayList<>();
        Set<String> seen = new HashSet<>(), ans = new HashSet<>();
        String sub;
        for (int i = 0; i <= s.length() - 10; i++) {
            sub = s.substring(i, i + 10);
            if (!seen.add(sub)) ans.add(sub);
        }
        return new ArrayList<>(ans);
    }
}

/**
 * reference
 * https://leetcode.com/problems/repeated-dna-sequences/discuss/53855/7-lines-simple-Java-O(n)
 */