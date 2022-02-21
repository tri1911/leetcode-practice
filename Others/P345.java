package others;

/**
 * Date: Feb 18, 2022
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */

public class P345 {
    // time: O(n)
    // space: O(n)
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !isVowel(arr[left])) left++;
            while (left < right && !isVowel(arr[right])) right--;
            swap(arr, left++, right--);
        }
        return new String(arr);
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
