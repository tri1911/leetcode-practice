package topInterviewQs;

// Date: Jan 6, 2022
// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/

import java.util.*;

public class P56 {
    // time complexity: O(nlog(n))
    // space complexity: O(1)
    public int[][] merge(int[][] intervals) {
        // takes O(nlog(n))
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        List<int[]> ans = new ArrayList<>();
        // takes O(n)
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0])
                ans.add(interval);
            else
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

// reference
// https://stackoverflow.com/questions/5803619/convert-a-list-of-array-into-an-array-of-array
// https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
// https://leetcode.com/problems/merge-intervals/solution/