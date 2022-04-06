package topInterviewQs;

/**
 * Date: April 05, 2022
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/
 */

// TODO: check out the time & space complexity AND find out better approach?

public class P38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        char[] arr = countAndSay(n - 1).toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                count++;
            } else {
                sb.append(count).append(arr[i]);
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P38 obj = new P38();
        System.out.println("Expected: 1211. Received: " + obj.countAndSay(4));
    }
}
