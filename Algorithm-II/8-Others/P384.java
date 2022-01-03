package algorithm2.others;

// Date: Dec 24, 2021
// 384. Shuffle an Array
// https://leetcode.com/problems/shuffle-an-array/

import java.util.Arrays;
import java.util.Random;

// Fisher-Yates Algorithm
// time complexity: O(n)
// space complexity: O(n)
public class P384 {
    private int[] arr;
    private int[] original;

    Random rand = new Random();

    private int getRandomInt(int min, int max) {
        return min + rand.nextInt(max - min);
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public P384(int[] nums) {
        arr = nums;
        original = nums.clone();
    }

    public int[] reset() {
        return arr = original.clone();
    }

    public int[] shuffle() {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            swap(i, getRandomInt(i, n));
        }
        return arr;
    }

    public static void main(String[] args) {
        P384 obj = new P384(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

// reference
// https://leetcode.com/problems/shuffle-an-array/solution/