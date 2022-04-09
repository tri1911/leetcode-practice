package topInterviewQs;

/**
 * Date: Dec 27, 2021 - Redo on April 09, 2022
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.*;

public class P347 {
    /*  bucket sort approach
        // time complexity: O(n)
        // space complexity: O(n)
        public int[] _topKFrequent(int[] nums, int k) {
            int n = nums.length;
            // edge case
            if (k == n) return nums;
            // count number's frequency - takes O(n)
            Map<Integer, Integer> counter = new HashMap<>();
            for (int val : nums)
                counter.put(val, counter.getOrDefault(val, 0) + 1);
            // put entries into bucket - takes O(n)
            List<Integer>[] buckets = new List[n + 1];
            for (int key : counter.keySet()) {
                int freq = counter.get(key);
                if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
                buckets[freq].add(key);
            }
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
     */

    /**
     * quick selection algorithm approach
     */

    private Map<Integer, Integer> counter;
    private int[] unique;

    // time: O(n)
    // space: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // count frequencies
        counter = new HashMap<>();
        for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);
        // store unique values
        int n = counter.size(), i = 0;
        unique = new int[n];
        for (int key : counter.keySet()) unique[i++] = key;
        // use quick selection to determine the correct index of kth largest frequent element (pivot)
        quickSelect(0, n - 1, n - k);
        // extract the right part from the pivot which is desired solution
        return Arrays.copyOfRange(unique, n - k, n);
    }

    // helper function to arrange the kth large frequent element into its correct place within `unique`
    // expected time complexity: O(n) - worst case: O(n^2)
    private void quickSelect(int first, int last, int target) {
        // base case: when the list contains only one element
        if (first == last) return;
        // randomly choose the pivot
        Random rand = new Random();
        int pivotIdx = first + rand.nextInt(last - first);
        // partition unique[first...last] based on the pivot
        int returnedIdx = partition(first, last, pivotIdx);
        // check whether the returned pivot index is our desired index
        if (returnedIdx == target) return;
        // if not, recursively finding the correct one
        if (returnedIdx > target) quickSelect(first, returnedIdx - 1, target);
        else quickSelect(returnedIdx + 1, last, target);
    }

    // helper function to partition the `unique` array
    private int partition(int first, int last, int pivotIdx) {
        int pivotFreq = counter.get(unique[pivotIdx]);
        // 1. swap the pivot to the last index
        swap(pivotIdx, last);
        // 2. move all less frequent elements to the left
        int end = first; // this is the index coming after the last element of the left part
        for (int i = first; i < last; i++) {
            if (counter.get(unique[i]) < pivotFreq) {
                swap(i, end++);
            }
        }
        // 3. swap back the pivot to its correct place
        swap(end, last);
        // 4. return the determined pivot index
        return end;
    }

    // helper function to swap element within `unique` array
    private void swap(int i, int j) {
        int tmp = unique[i];
        unique[i] = unique[j];
        unique[j] = tmp;
    }
}

/**
 * reference
 * https://leetcode.com/problems/top-k-frequent-elements/solution/
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/740374/Python-5-lines-O(n)-buckets-solution-explained
 */