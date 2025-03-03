package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-04 00:00:32
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-04 00:29:07
 * @Description: to be added
    Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​
    A string is said to be palindrome if it the same string when reversed.

    Example 1:
        Input: s = "abcbdd"
        Output: true
        Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.

    Example 2:
        Input: s = "bcbddxy"
        Output: false
        Explanation: s cannot be split into 3 palindromes.

    Constraints:
        3 <= s.length <= 2000
        s​​​​​​ consists only of lowercase English letters.
 */

public class Main {
    public static void main(String[] args) {
        String s = "bpomo";
        System.out.println(checkPartitioning(s));
        System.out.println(new Solution().checkPartitioning(s));
    }

    // timeout
    public static boolean checkPartitioning(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][4];
        for (int i = 0; i < len; i++) {
            dp[i + 1][1] = isPartitioning(s, 0, i);
        }

        for (int j = 2; j < 4; j++) {
            for (int i = 0; i < len; i ++) {
                boolean temp = false;
                for (int tj = j - 1; tj <= i; tj ++) {
                    if (temp) break;
                    temp = dp[tj][j - 1] && isPartitioning(s, tj, i);
                }
                dp[i + 1][j] = temp;
            }
        }
        return dp[len][3];
    }

    public static boolean isPartitioning(String s, int begin, int end) {
        while (begin <= end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end --;
        }
        return true;
    }
}