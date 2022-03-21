package programmingSkills1;

/**
 * Date: March 20, 2022
 * 1588. Sum of All Odd Length Sub-arrays
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */

public class P1588 {
    // intuition:
    // for each element at ith index, count the number of sub-arrays including it
    // the # of sub-array containing it = all possible ways - # not including it
    // = {n * (n + 1) - [i * (i + 1) + (n - 1 - i) * (n - i)]} / 2
    // = n * (i + 1) - i * (i + 1)
    // for this problem we only care about sub-arrays with odd length
    // => target = [n * (i + 1) - i * (i + 1) + 1] / 2
    // since, among n numbers, there is (n + 1) / 2 odd numbers

    // time: O(n)
    // space: O(1)
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = (n * (i + 1) - i * (i + 1) + 1) / 2;
            ans += arr[i] * count;
        }
        return ans;
    }

    public static void main(String[] args) {
        P1588 obj = new P1588();
        System.out.println("Expected: 58. Received: " + obj.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println("Expected: 3. Received: " + obj.sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println("Expected: 66. Received: " + obj.sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/854184/JavaC%2B%2BPython-O(N)-Time-O(1)-Space
 * https://www.geeksforgeeks.org/count-of-contiguous-subarrays-possible-for-every-index-by-including-the-element-at-that-index/
 */
