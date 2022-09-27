package leetcodingchallenge.september2022;

/**
 * Date: September 26, 2022
 * 990. Satisfiability of Equality Equations
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */

// TODO: review how to compute the time complexity of union-find

public class P990 {
    private int[] unions = new int[26];

    // time: O(nlog(n))
    // space: O(1)
    public boolean equationsPossible(String[] equations) {
        // initially, each character belongs to union which has only itself
        for (int i = 0; i < 26; i++) unions[i] = i;
        // build the unions based on the equality equation - takes O(n)
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unions[find(equation.charAt(0) - 'a')] = find(equation.charAt(3) - 'a');
            }
        }
        // verify the validity based on the in equality - takes O(n)
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    // helper function to locate the root of union in which this value belongs
    private int find(int val) {
        if (val != unions[val]) {
            // update the root value of the `val` character
            unions[val] = find(unions[val]);
        }
        return unions[val];
    }
}

/**
 * References
 * https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234486/JavaC%2B%2BPython-Easy-Union-Find
 */