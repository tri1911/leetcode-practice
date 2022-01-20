package leetcodingchallenge.january2022;

// Date: Jan 6, 2022
// 1094. Car Pooling
// https://leetcode.com/problems/car-pooling/

// similar problems
// 253. Meeting Rooms II
// 731. My Calendar II
// 732. My Calendar III
// 1109. Corporate Flight Bookings
// 218. The Skyline Problem

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// TODO: learn about difference array concept, TreeMap in Java
// TODO: check out the solution using Priority Queue

// Observation: the number of capacity is changed only at each stop

public class P1094 {
    /*  using TreeMap approach - this solution apply for general problem without making use of the constraint
        // time complexity: O(nlog(n))
        // space complexity: O(m) - where m is number of stops
        public boolean carPooling(int[][] trips, int capacity) {
            Map<Integer, Integer> map = new TreeMap<>(); // use TreeMap because it sorts entries by its key (in ascending order)
            // takes O(n*log(n)) - each insertion or removal takes O(log(n))
            for (int[] trip : trips) {
                map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
                map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
            }
            // takes O(n)
            for (int key : map.keySet()) {
                capacity -= map.get(key);
                if (capacity < 0)
                    return false;
            }
            return true;
        }
     */

    // solution takes advantage of the constraints
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean carPooling(int[][] trips, int capacity) {
        // the array records the number of passengers on the car at ith kilometer
        int[] passengers = new int[1001];
        // takes O(n)
        for (int[] trip : trips) {
            passengers[trip[1]] += trip[0]; // pick up
            passengers[trip[2]] -= trip[0]; // drop off
        }
        // simulation of picking up and dropping off passengers
        // takes O(1001)
        for (int i : passengers) {
            capacity -= i;
            if (capacity < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P1094 obj = new P1094();
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Expected: false. Received: " + obj.carPooling(trips, 4));
        System.out.println("Expected: true. Received: " + obj.carPooling(trips, 5));
    }
}

// reference
// https://www.youtube.com/watch?v=Z_YMtLAmLrM
// https://leetcode.com/problems/car-pooling/discuss/318138/C%2B%2B-Simple-solution-using-sorting-on-vectors
// https://leetcode.com/problems/car-pooling/discuss/317610/JavaC%2B%2BPython-Meeting-Rooms-III
// https://wcipeg.com/wiki/Prefix_sum_array_and_difference_array

// https://leetcode.com/problems/car-pooling/discuss/317887/JavaPython-3-Clean-codes-w-explanation-and-brief-analysis.

/*  solution with PQ and sort
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));
        for (int[] trip : trips) {
            while (!pq.isEmpty() && trip[1] >= pq.peek()[2]) // any passengers need to get off?
                capacity += pq.poll()[0]; // more capacity as passengers out.
            capacity -= trip[0]; // less capacity as passengers in.
            if (capacity < 0) return false; // not enough capacity.
            pq.offer(trip); // put into PriorityQueue the information at current location.
        }
        return true;
    }
 */