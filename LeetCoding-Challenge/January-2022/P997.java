package leetcodingchallenge.january2022;

// Daily LeetCoding Challenge - Jan 3, 2022
// Date: Jan 2, 2022
// 997. Find the Town Judge
// https://leetcode.com/problems/find-the-town-judge/

public class P997 {
    // time complexity: O(n)
    // space complexity: O(n)
    public int findJudge(int n, int[][] trust) {
        // need to find the node that # of in-coming edges is n - 1
        // and # of out-coming edges is 0
        // in other words, sum of in-coming and out-coming at the town judge
        // need to be n - 1
        // Note: ith person only trust jth person at most once
        // (i, j) is unique
        int[] counter = new int[n + 1];
        for (int[] i : trust) {
            counter[i[1]]++;
            counter[i[0]]--;
        }
        for (int i = 1; i <= n; i++) {
            if (counter[i] == n - 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        P997 obj = new P997();
        int[][] trust = {{1, 2}};
        System.out.println("Expected: 2. Received: " + obj.findJudge(2, trust));
        trust = new int[][]{{1, 3}, {2, 3}};
        System.out.println("Expected: 3. Received: " + obj.findJudge(3, trust));
        trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        System.out.println("Expected: -1. Received: " + obj.findJudge(3, trust));
    }
}

// reference
// https://www.youtube.com/watch?v=FhuR5ITiRbo
// https://www.youtube.com/watch?v=2AdzmA1IC1k&t=187s