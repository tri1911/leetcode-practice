// Date: Sat, Sep 18, 2021

// 264. Ugly Number II
// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return the nth ugly number.

// Example 1:
// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

// Example 2:
// Input: n = 1
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

// Constraints:
// 1 <= n <= 1690

// Time complexity O(n) & Space complexity: O(n)
int nthUglyNumber(int n) {
    int i2, i3, i5;
    i2 = i3 = i5 = 0;
    vector<int> numbers(n);
    numbers[0] = 1;
    for (int i = 1; i < n; i++) {
        int next_2 = numbers[i2] * 2;
        int next_3 = numbers[i3] * 3;
        int next_5 = numbers[i5] * 5;
        numbers[i] = min(next_2, min(next_3, next_5));
        if (numbers[i] == next_2) i2++;
        if (numbers[i] == next_3) i3++;
        if (numbers[i] == next_5) i5++;
    }
    return numbers[n - 1];
}