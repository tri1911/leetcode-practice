package leetcodingchallenge.april2022;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: April 24, 2022
 * 1396. Design Underground System
 * https://leetcode.com/problems/design-underground-system/
 */

public class P1396 {
    // hash table with Key = customer id  | Value = [StartStation, start time]
    private Map<Integer, Pair<String, Integer>> customers;
    // hash table with Key = [StartStation, EndStation] | Value = [sum, # of customers]
    // note: we can concatenate start & end stations instead of use Pair (either way is ok)
    private Map<Pair<String, String>, Pair<Integer, Integer>> routes;

    public P1396() {
        customers = new HashMap<>();
        routes = new HashMap<>();
    }

    // time: O(1)
    public void checkIn(int id, String stationName, int t) {
        customers.put(id, new Pair<>(stationName, t));
    }

    // time: O(1)
    public void checkOut(int id, String stationName, int t) {
        // retrieve the customer's checkIn info (startStation, start time)
        Pair<String, Integer> checkIn = customers.get(id);

        // compose the route (start station & end station)
        Pair<String, String> route = new Pair<>(checkIn.getKey(), stationName);
        // calculate the time the customer takes to travel from one station to another
        int time = t - checkIn.getValue();

        // update the time & number of customers into the "routes" hash table
        // first, get the old information of the current route (including total time & number of customers)
        Pair<Integer, Integer> old = routes.getOrDefault(route, new Pair<>(0, 0));
        // then, update the time + number of customers in the "routes" hash table
        routes.put(route, new Pair<>(old.getKey() + time, old.getValue() + 1));
    }

    // time: O(1)
    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> route = routes.get(new Pair<>(startStation, endStation));
        return route.getKey() * 1.0 / route.getValue();
    }
}
