package topInterviewQs;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Jan 13, 2022
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */

public class P13 {
    public int romanToInt(String s) {
        Map<Character, Integer> table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        int n = s.length();
        int ans = 0;
        char current, next;
        for (int i = 0; i < n - 1; i++) {
            current = s.charAt(i);
            next = s.charAt(i + 1);
            if (table.get(current) < table.get(next))
                ans -= table.get(current);
            else
                ans += table.get(current);
        }
        return ans + table.get(s.charAt(n - 1));
    }

    public static void main(String[] args) {
        P13 obj = new P13();
        System.out.println("Expected: 3. Received: " + obj.romanToInt("III"));
        System.out.println("Expected: 58. Received: " + obj.romanToInt("LVIII"));
        System.out.println("Expected: 1994. Received: " + obj.romanToInt("MCMXCIV"));
    }
}

/**
 * reference
 * https://leetcode.com/problems/roman-to-integer/discuss/6537/My-Straightforward-Python-Solution
 */
