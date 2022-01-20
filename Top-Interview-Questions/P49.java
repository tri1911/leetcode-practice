package topInterviewQs;

// Date: Jan 8, 2022
// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/

import java.util.*;

// TODO: review the optimized solution (the trick of converting the char[] counter to a string)

public class P49 {
    /*  First Attempt
        // time complexity: O(n*m)
        // space complexity: O(n)
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Map<Character, Integer>, List<String>> dict = new HashMap<>();
            Map<Character, Integer> counter;
            // takes O(n * m) where n is the length of strs & m is the max length of elements in strs
            for (String str : strs) {
                counter = new HashMap<>();
                for (char ch : str.toCharArray())
                    counter.put(ch, counter.getOrDefault(ch, 0) + 1);
                if (!dict.containsKey(counter)) {
                    dict.put(counter, new ArrayList<>());
                }
                dict.get(counter).add(str);
            }

            // takes O(n)
            // List<List<String>> ans = new ArrayList<>();
            // for (List<String> group : dict.values()) ans.add(group);
            // return ans;

            // do this instead
            return new ArrayList<>(dict.values());
        }
     */

    // optimized solution
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] counters = new char[26];
            for (char ch : s.toCharArray())
                counters[ch - 'a']++;
            String key = String.valueOf(counters);
            // System.out.println("key = " + key);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        P49 obj = new P49();
        System.out.println("----");
        System.out.println("Expected: [[bat], [nat, tan], [ate, eat, tea]]");
        System.out.println("Received: " + obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("----");
        System.out.println("Expected: [[]]");
        System.out.println("Received: " + obj.groupAnagrams(new String[]{""}));
        System.out.println("----");
        System.out.println("Expected: [[a]]");
        System.out.println("Received: " + obj.groupAnagrams(new String[]{"a"}));
    }
}

// reference
// https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution