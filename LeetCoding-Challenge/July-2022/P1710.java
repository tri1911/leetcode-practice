package leetcodingchallenge.july2022;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: July 01, 2022
 * 1710. Maximum Units on a Truck
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */

public class P1710 {
    // first attempt
    // time: O(n*log(n))
    // space: O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(type -> type[1]));
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize > 0; i--) {
            int boxes = Math.min(truckSize, boxTypes[i][0]);
            ans += boxes * boxTypes[i][1];
            truckSize -= boxes;
        }
        return ans;
    }

    // use counting sort
    // time: O(n)
    // space: O(1)
    public int _maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        int ans = 0;
        for (int[] type : boxTypes) count[type[1]] += type[0];
        for (int i = 1000; i >= 1 && truckSize > 0; i--) {
            if (count[i] > 0) {
                int boxes = Math.min(truckSize, count[i]);
                ans += i * boxes;
                truckSize -= boxes;
            }
        }
        return ans;
    }
}
