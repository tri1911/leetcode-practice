package others;

/**
 * Date: April 02, 2022
 * 852. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

public class P852 {
    // time: O(log(n))
    // space: O(1)
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1]) high = mid - 1;
            else low = mid + 1;
        }
        return arr[low] < arr[high] ? high : low;
    }
}
