package leetcodingchallenge.june2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: June 29, 2022
 * 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */

public class P406 {
    // time: O(n^2)
    // space: O(n)
    public int[][] reconstructQueue(int[][] people) {
        // takes O(nlog(n))
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        // System.out.println(Arrays.deepToString(people));
        List<int[]> ans = new ArrayList<>();
        // insertion takes O(n) * n people -> takes O(n^2)
        for (int[] person : people) ans.add(person[1], person);
        return ans.toArray(new int[people.length][2]);
    }
}

/**
 * references
 * https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
 * https://leetcode.com/problems/queue-reconstruction-by-height/discuss/2212363/Easy-Java-Solution
 */