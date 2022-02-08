package others;

/**
 * Date:
 * 2035. Partition Array Into Two Arrays to Minimize Sum Difference
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 */

// TODO: this problem is the similar to the MinAbsSum problem in Codility, review it

/*  first observation
    total = S1 + S2
    find the min of (total - 2 * S1) where S1 is the any sum of n elements => find all possible sum of n elements in array (takes O(n!) => bad)
    e.g, |22 - 2 * 12| = |22 - 2 * 10| = 2
 */

/*  another observation
    total = S1 + S2 => find maximum S1 <= total / 2
 */

public class P2035 {
    public int minimumDifference(int[] nums) {
        return 1;
    }
}

/**
 * reference
 * https://www.youtube.com/watch?v=UoKGRTIZvM0
 */