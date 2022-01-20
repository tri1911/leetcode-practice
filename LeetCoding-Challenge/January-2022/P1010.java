package leetcodingchallenge.january2022;

// Daily LeetCoding Challenge - Jan 2, 2022
// Date: Sun, Jan 2, 2022
// 1010. Pairs of Songs With Total Durations Divisible by 60
// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

public class P1010 {
    /* first attempt using modula and hash map
    // time complexity: O(n)
    // space complexity: O(1) -> keys = [0, 59] always
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, ans = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        // phase 1: populate counter - takes O(n)
        for (int i = 0; i < n; i++) {
            int val = time[i] % 60;
            counter.put(val, counter.getOrDefault(val, 0) + 1);
        }
        // phase 2: count valid pairs
        for (int val : counter.keySet()) {
            int count = counter.get(val);
            // edge case are 0 and 30
            // 30 30 30 = 2 + 1 = 3 -> (n - 1) + (n - 2) + ... + 1 = n * (n - 1) / 2
            if (val == 30 || val == 0)
                ans += count * (count - 1) / 2;
            else if (val < 30 && counter.containsKey(60 - val))
                ans += count * counter.get(60 - val);
        }
        return ans;
    }
     */

    // time complexity: O(n)
    // space complexity: O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] counter = new int[60];
        for (int val : time) {
            val %= 60;
            int other = (val == 0) ? 0 : 60 - val;
            ans += counter[other];
            counter[val]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        P1010 obj = new P1010();
        System.out.println("Expected: 3. Received: " + obj.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println("Expected: 3. Received: " + obj.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}

/* simpler implementations but the idea is similar
    https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/1660700/daily-leetcoding-challenge-january-day-2
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;
        for (int i = 0; i < time.Length; i++) {
            int curr = time[i] % 60;
            if (curr == 0)
                count += remainders[0];
            else
                count += remainders[60 - curr];
            remainders[curr]++;
        }
        return count;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] counter = new int[60];
        for(int val : time) {
            count += counter[(600 - val) % 60];
            counter[val % 60]++;
        }
        return count;
    }

 */
