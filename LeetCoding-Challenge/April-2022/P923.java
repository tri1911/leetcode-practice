package leetcodingchallenge.april2022;

import java.util.Arrays;

/**
 * Date: April 06, 2022
 * 923. 3Sum With Multiplicity
 * https://leetcode.com/problems/3sum-with-multiplicity/
 */

// TODO: check out other approaches if have time

public class P923 {
    // my own solution
    // time: O(n^2)
    // space: O(1)
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(arr);
        int n = arr.length, ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int remain = target - arr[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[j] + arr[k];
                if (sum == remain) {
                    if (arr[j] == arr[k]) {
                        ans += (k - j + 1) * (k - j) / 2;
                        ans %= MOD;
                        break;
                    } else {
                        int n1 = 1, n2 = 1;
                        while (j < k && arr[j] == arr[++j]) n1++;
                        while (j < k && arr[k] == arr[--k]) n2++;
                        ans += n1 * n2;
                        ans %= MOD;
                    }
                } else if (sum < remain) {
                    while (j < k && arr[j] == arr[++j]) ;
                } else {
                    while (j < k && arr[k] == arr[--k]) ;
                }
            }
        }
        return ans;
    }
}

/**
 * reference
 * https://leetcode.com/problems/3sum-with-multiplicity/solution/
 */