package topInterviewQs;

// Date: Dec 27, 2021
// 179. Largest Number
// https://leetcode.com/problems/largest-number

import java.util.Arrays;
import java.util.Comparator;

public class P179 {
    private class customComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return (str2 + str1).compareTo(str1 + str2);
        }
    }

    // time complexity: O(nlog(n))
    // space complexity: O(n)
    public String largestNumber(int[] nums) {
        // convert integer array into String array
        String[] asStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) asStrings[i] = String.valueOf(nums[i]);
        // sort the String array
        Arrays.sort(asStrings, new customComparator());
        System.out.println(Arrays.toString(asStrings));
        // handle edge cases
        if (asStrings[0].equals("0")) return "0";
        // build solution
        String ans = "";
        for (String s : asStrings) ans += s;
        return ans;
    }

    public static void main(String[] args) {
        P179 obj = new P179();
        System.out.println("Expect: 210. Output: " + obj.largestNumber(new int[]{10, 2}));
        System.out.println("Expect: 9534330. Output: " + obj.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println("Expect: 330. Output: " + obj.largestNumber(new int[]{3, 30}));
        System.out.println("Expect: 0. Output: " + obj.largestNumber(new int[]{0, 0}));
    }
}

// reference
// https://leetcode.com/problems/largest-number/solution
