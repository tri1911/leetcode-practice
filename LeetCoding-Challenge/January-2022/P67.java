package leetcodingchallenge.january2022;

// Date: Jan 10, 2022
// 67. Add Binary
// https://leetcode.com/problems/add-binary/

public class P67 {
    // time complexity: O(m + n)
    // space complexity: O(1)
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        P67 obj = new P67();
        System.out.println("Expected: 100. Received: " + obj.addBinary("11", "1"));
        System.out.println("Expected: 10101. Received: " + obj.addBinary("1010", "1011"));
    }
}

// reference
// https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation

/*
    Example 1:
    Input: a = "11", b = "1"
    Output: "100"

    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"
 */