package leetcodingchallenge.january2022;

/**
 * Date: Jan 25, 2022
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/
 */

public class P941 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3 || arr[0] >= arr[1])
            return false;
        boolean isIncreasing = true;
        for (int i = 2; i < n; i++) {
            // if duplicate values are found, immediately returns false
            if (arr[i - 1] == arr[i])
                return false;
            // there are two states
            // 1. increasing
            // toggle the state if decreasing trend is found
            if (isIncreasing && arr[i - 1] > arr[i])
                isIncreasing = false;
            // 2. decreasing
            else if (!isIncreasing && arr[i - 1] < arr[i])
                return false;
        }
        return !isIncreasing;
    }

    /*  LeetCode Official Solution
        int n = arr.length, i = 0;
        // walk up
        while (i < n - 1 && arr[i] < arr[i + 1]) i++;
        // if there is no up OR no down then returns false
        if (i == 0 || i == n - 1) return false;
        // walk down
        while (i < n - 1 && arr[i] > arr[i + 1]) i++;
        return i == n - 1;
     */
}

/**
 * reference
 * https://leetcode.com/problems/valid-mountain-array/solution/
 */