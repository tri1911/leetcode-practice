package leetcodingchallenge.august2022;

import java.util.Arrays;

/**
 * Date: August 18, 2022
 * 1338. Reduce Array Size to The Half
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */

public class P1338 {
    // time: O(n*log(n))
    // space: O(1)
    public int minSetSize(int[] arr) {
        int[] counter = new int[100_001];
        for (int num : arr) counter[num]++;
        Arrays.sort(counter);
        int i = 0, sum = 0, ans = 0;
        while (sum < arr.length / 2) {
            sum += counter[100_000 - i++];
            ans++;
        }
        return ans;
    }

    // TODO: checkout this faster implementation (5ms) which uses bucket sort -> reduce the time complexity to linear time
    public int _minSetSize(int[] arr) {
        int min = 1000000, max = 0;
        for (int val : arr) {
            min = Math.min(val, min);
            max = Math.max(val, max);
        }
        int[] count = new int[max - min + 1];
        for (int val : arr) {
            count[val - min]++;
        }
        int[] bucket = new int[arr.length + 1];
        for (int val : count) {
            if (val != 0) bucket[val]++;
        }

        int size = 0, sum = 0;
        final int half = arr.length >> 1;
        for (int i = arr.length; i > 0; i--) {
            while (bucket[i]-- != 0) {
                sum += i;
                size++;
                if (sum >= half) return size;
            }
        }
        return 0;
    }
}
