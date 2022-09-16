package leetcodingchallenge.september2022;

/**
 * Date: September 15, 2022
 * 2007. Find Original Array From Doubled Array
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 */

public class P2007 {
    // time & space: O(max)
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];
        // find the maximum value within changed array - takes O(n)
        int max = Integer.MIN_VALUE;
        for (int num : changed) max = Math.max(max, num);
        if (max % 2 != 0) return new int[0];
        // hash table contains element counts - takes O(n)
        int[] counter = new int[max + 1];
        for (int num : changed) counter[num]++;
        // edge case: when there exists zero in the original array -> number of zeros in changed array should be even
        if (counter[0] % 2 != 0) return new int[0];
        // find the original array - takes O(max)
        int[] ans = new int[n / 2];
        // the next to-populate index
        int idx = counter[0] / 2;
        if (idx >= ans.length) return ans;
        // examine possible values starting from 1
        for (int num = 1; num <= max; num++) {
            if (counter[num] == 0) continue;
            if (num * 2 > max || counter[num] > counter[num * 2]) return new int[0];
            // populate the original array
            int count = counter[num];
            for (int i = 0; i < count; i++) {
                ans[idx++] = num;
                counter[num]--;
                counter[num * 2]--;
            }
        }
        return ans;
    }
}

/*  5ms Solution
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0) return new int[0];
        int max = Integer.MIN_VALUE;
        for(int num : changed) max = Math.max(max, num);
        if(max%2 != 0) return new int[0];

        int[] cnts = new int[max+1];
        for(int num : changed) cnts[num]++;

        int[] res = new int[changed.length/2];
        if(cnts[0] % 2 != 0) return new int[0];
        int idx = cnts[0]/2;
        for(int i = 1; i < cnts.length; i++) {
            if(cnts[i] == 0) continue;
            if(2*i > max || cnts[i] > cnts[2*i]) return new int[0];
            int cnt = cnts[i];
            cnts[2*i] -= cnt;
            while(cnt-- > 0) res[idx++] = i;
        }

        return res;
    }
 */