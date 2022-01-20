package topInterviewQs;

// Date: Dec 27, 2021
// 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

// TODO: read leetcode solution

public class P347 {
    // bucket sort
    // time complexity: O(n)
    // space complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        // edge case
        if (k == n)
            return nums;
        // count number's frequency - takes O(n)
        Map<Integer, Integer> counter = new HashMap<>();
        for (int val : nums)
            counter.put(val, counter.getOrDefault(val, 0) + 1);
        // put entries into bucket - takes O(n)
        List<Integer>[] buckets = new List[n + 1];
        for (int key : counter.keySet()) {
            int freq = counter.get(key);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        System.out.println(Arrays.toString(buckets));
        // find the solution - take O(k)
        int[] ans = new int[k];
        for (int i = n, index = 0; i >= 1 && index < k; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size() && index < k; j++) {
                    ans[index++] = buckets[i].get(j);
                }
            }
        }
        return ans;
    }
}

// reference
// https://leetcode.com/problems/top-k-frequent-elements/solution/
// https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
// https://leetcode.com/problems/top-k-frequent-elements/discuss/740374/Python-5-lines-O(n)-buckets-solution-explained
