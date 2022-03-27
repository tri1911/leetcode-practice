package leetcodingchallenge.march2022;

/**
 * Date: March 27, 2022
 * 1337. The K Weakest Rows in a Matrix
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */

import java.util.ArrayList;
import java.util.Arrays;

public class P1337 {
    // first attempt using bucket sort
    // time: O(nm)
    // space: O(n)
    public int[] _kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        // bucket sort - takes O(n * m) time
        ArrayList<Integer>[] buckets = new ArrayList[m + 1];
        // outer loop takes O(n)
        for (int i = 0; i < n; i++) {
            int ones = 0;
            // inner loop takes O(m) -> optimize here -> using binary search -> from O(m) to O(log(m))
            for (int num : mat[i]) if (num == 1) ones++;
            if (buckets[ones] == null) buckets[ones] = new ArrayList<>();
            buckets[ones].add(i);
        }
        // fill solution array - takes O(k) time
        int[] ans = new int[k];
        int i = 0;
        for (ArrayList<Integer> list : buckets) {
            if (list != null) {
                for (int idx : list) {
                    ans[i++] = idx;
                    if (i == k) return ans;
                }
            }
        }
        return ans;
    }

    // optimized approach
    // time: O(n * log(m))
    // space: O(n)
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        // bucket sort - takes O(n * log(m)) time
        ArrayList<Integer>[] buckets = new ArrayList[m + 1];
        for (int i = 0; i < n; i++) {
            int ones = countOnes(mat[i]);
            if (buckets[ones] == null) buckets[ones] = new ArrayList<>();
            buckets[ones].add(i);
        }
        // fill solution array - takes O(k) time
        int[] ans = new int[k];
        int i = 0;
        for (ArrayList<Integer> list : buckets) {
            if (list != null) {
                for (int idx : list) {
                    ans[i++] = idx;
                    if (i == k) return ans;
                }
            }
        }
        return null;
    }

    // helper function to count the number of ones - takes O(log(n)) time
    private int countOnes(int[] arr) {
        int low = 0, high = arr.length - 1, mid;
        int counter = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == 0) high = mid - 1;
            else {
                counter = mid + 1;
                low = mid + 1;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        P1337 obj = new P1337();
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        System.out.println("Expected: [2, 0, 3]\nReceived: " + Arrays.toString(obj.kWeakestRows(mat, 3)));
        System.out.println("----");
        mat = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        System.out.println("Expected: [0, 2]\nReceived: " + Arrays.toString(obj.kWeakestRows(mat, 2)));
        System.out.println("----");
        mat = new int[][]{{1, 0}, {0, 0}, {1, 0}};
        System.out.println("Expected: [1, 0]\nReceived: " + Arrays.toString(obj.kWeakestRows(mat, 2)));
        System.out.println("----");
        mat = new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
        System.out.println("Expected: [0]\nReceived: " + Arrays.toString(obj.kWeakestRows(mat, 1)));
        System.out.println("----");
        mat = new int[][]{{1, 0}, {0, 0}, {1, 0}};
        System.out.println("Expected: [1, 0]\nReceived: " + Arrays.toString(obj.kWeakestRows(mat, 2)));
    }
}

/**
 * reference
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/discuss/496555/Java-Best-Solution-100-TimeSpace-Binary-Search-%2B-Heap
 */