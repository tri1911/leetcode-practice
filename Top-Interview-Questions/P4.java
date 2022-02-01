package topInterviewQs;

/**
 * Date: Jan 31, 2022
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

// TODO: redo

public class P4 {
    // time: O(log(m + n))
    // space: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = m;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int left1 = partition1 > 0 ? nums1[partition1 - 1] : Integer.MIN_VALUE;
            int right1 = partition1 < m ? nums1[partition1] : Integer.MAX_VALUE;

            int left2 = partition2 > 0 ? nums2[partition2 - 1] : Integer.MIN_VALUE;
            int right2 = partition2 < n ? nums2[partition2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        P4 obj = new P4();
        System.out.println("Expected: 2. Received: " + obj.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println("Expected: 2.5. Received: " + obj.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println("Expected: 2.5. Received: " + obj.findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }
}

/**
 * https://www.youtube.com/watch?v=LPFhl65R7ww
 * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/268906/Java-Solution%3A(2ms)faster-than-100.00-(48.3)less-than-86.61.
 */
