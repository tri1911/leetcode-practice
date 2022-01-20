package leetcodingchallenge.january2022;

/**
 * Date: Jan 16, 2022
 * 849. Maximize Distance to Closest Person
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */

// TODO: implement 2 other approaches

public class P849 {
    // time: O(n)
    // space: O(1)
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int ans = 0, count = 0;
        // general case: empty seats between two people
        for (int seat : seats) {
            if (seat == 1) {
                count = 0;
            } else {
                count++;
                ans = Math.max(ans, (count + 1) / 2);
            }
        }
        // edge case 1: empty seats from the edge at the beginning to one person on the right
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                ans = Math.max(ans, i);
                break;
            }
        }
        // edge case 2: empty seats from one person to another edge at the end
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                ans = Math.max(ans, n - 1 - i);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P849 obj = new P849();
        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        System.out.println("Expected: 2. Received: " + obj.maxDistToClosest(seats));
        System.out.println("---");
        seats = new int[]{1, 0, 0, 0};
        System.out.println("Expected: 3. Received: " + obj.maxDistToClosest(seats));
        System.out.println("---");
        seats = new int[]{0, 1};
        System.out.println("Expected: 1. Received: " + obj.maxDistToClosest(seats));
        System.out.println("---");
        seats = new int[]{0, 0, 1};
        System.out.println("Expected: 2. Received: " + obj.maxDistToClosest(seats));
    }
}

/**
 * reference
 * https://leetcode.com/problems/maximize-distance-to-closest-person/solution/
 */
