package leetcodingchallenge.june2022;

import java.util.Arrays;

/**
 * Date: June 12, 2022
 * 1695. Maximum Erasure Value
 * https://leetcode.com/problems/maximum-erasure-value/
 */

public class P1695 {
    // time: O(n)
    // space: O(n)
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length, ans = 0, first = 0;
        int[] hash = new int[10_001]; // {num:index}
        Arrays.fill(hash, -1);
        int[] ps = new int[n]; // {index:pre-sum}
        for (int i = 0; i < n; i++) {
            // 1. populate the pre-sum array
            ps[i] = (i == 0 ? 0 : ps[i - 1]) + nums[i];
            // 2. compute the score for the unique sub-array ending at ith index
            // updates `first` pointer to `lastIdx + 1` if current num has been seen before
            int lastIdx = hash[nums[i]];
            if (lastIdx != -1 && lastIdx >= first) first = lastIdx + 1;
            // 3. compute the score of current sub-array (& update the global solution)
            ans = Math.max(ans, ps[i] - (first == 0 ? 0 : ps[first - 1]));
            // 4. update the last idx
            hash[nums[i]] = i;
        }
        return ans;
    }
}

/*  Another approach to take a look
    public int _maximumUniqueSubarray(int[] arr) {
        int res = 0;
        boolean[] check = new boolean[10001];
        int l = 0;
        int r = 0;
        int temp = 0;
        while (r < arr.length) {
            if (check[arr[r]] == true) {
                res = Math.max(res, temp);
                while (arr[l] != arr[r]) {
                    temp -= arr[l];
                    check[arr[l]] = false;
                    l++;
                }
                l++;
            } else {
                check[arr[r]] = true;
                temp += arr[r];
            }
            r++;
            res = Math.max(res, temp);
        }
        return res;
    }
 */