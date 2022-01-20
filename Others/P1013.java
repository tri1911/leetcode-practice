package others;

/**
 * Date: Jan 15, 2022
 * 1013. Partition Array Into Three Parts With Equal Sum
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */

// TODO: find optimized implementation

public class P1013 {
    // time: O(n)
    // space: O(1)
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length, total = 0;
        for (int num : arr) total += num;
        if (total % 3 != 0) return false;
        int target = total / 3, current = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 && count == 1) return false;
            current += arr[i];
            if (current == target && count < 2) {
                current = 0;
                count++;
            }
        }
        return current == target && count + 1 == 3;
    }

    public static void main(String[] args) {
        P1013 obj = new P1013();
        System.out.println("Expected: true. Received: " + obj.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println("Expected: true. Received: " + obj.canThreePartsEqualSum(new int[]{0, 0, 0, 0}));
        System.out.println("Expected: false. Received: " + obj.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/discuss/260885/C%2B%2B-6-lines-O(n)-target-sum
 */
