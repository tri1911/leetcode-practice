package others;

// Date: Jan 9, 2022
// 1109. Corporate Flight Bookings
// https://leetcode.com/problems/corporate-flight-bookings/

import java.util.Arrays;

public class P1109 {
    /*  First Attempt
        // observation: can see the value of reservations only change at endpoints of each interval e.g. [1, 2], or [2, 3]
        // time complexity: O(n + k*log(k)) where k is the number of flight bookings
        // space complexity: O(k)
        public int[] corpFlightBookings(int[][] bookings, int n) {
            // records the changed number of reserved seats - takes O(k(log(k)) time
            Map<Integer, Integer> map = new TreeMap<>();
            for (int[] booking : bookings) {
                map.put(booking[0], map.getOrDefault(booking[0], 0) + booking[2]);
                map.put(booking[1] + 1, map.getOrDefault(booking[1] + 1, 0) - booking[2]);
            }
            // find solution - takes O(n)
            int[] answer = new int[n];
            // this is current state of reservation
            int current = 0;
            for (int flight = 1; flight <= n; flight++) {
                current += map.getOrDefault(flight, 0);
                answer[flight - 1] = current;
            }
            return answer;
        }
     */

    // optimized solution
    // time complexity: O(n)
    // space complexity: O(1)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        // records major changes in number of reserved seats on endpoints of interval
        for (int[] booking : bookings) {
            answer[booking[0] - 1] += booking[2];
            if (booking[1] < n) answer[booking[1]] -= booking[2];
        }
        // at this point the answer array only contains state changes
        // we need to update number of reserved seats based on the previous state + state change
        // at the beginning the change is 0, so answer[0] is correct already, we start from i = 1
        for (int i = 1; i < n; i++)
            answer[i] += answer[i - 1];
        return answer;
    }

    public static void main(String[] args) {
        P1109 obj = new P1109();
        int[] answer = obj.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        System.out.println("Expected: [10, 55, 45, 25, 25] \nReceived: " + Arrays.toString(answer));
    }
}

/*  Example
    Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
    Output: [10,55,45,25,25]
    Explanation:
    Flight labels:        1   2   3   4   5
    Booking 1 reserved:  10  10
    Booking 2 reserved:      20  20
    Booking 3 reserved:      25  25  25  25
    Total seats:         10  55  45  25  25
    Hence, answer = [10,55,45,25,25]
 */

// reference
// https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C%2B%2BJava-with-picture-O(n)