package org.example;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 00:37:04
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 12:57:56
 * @Description: to be added
    You are given a string s containing lowercase letters and an integer k. You need to :

    First, change some characters of s to other lowercase English letters.
    Then divide s into k non-empty disjoint substrings such that each substring is a palindrome.
    Return the minimal number of characters that you need to change to divide the string.

    

    Example 1:

    Input: s = "abc", k = 2
    Output: 1
    Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
    Example 2:

    Input: s = "aabbc", k = 3
    Output: 0
    Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
    Example 3:

    Input: s = "leetcode", k = 8
    Output: 0
    

    Constraints:

    1 <= k <= s.length <= 100.
    s only contains lowercase English letters.
 */
public class Main {

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 7;
        System.out.println(palindromePartition(s, k));
    }

    public static int palindromePartition(String s, int k) {
        int len = s.length();
        if (len == k) {
            return 0;
        }
        if (k == 1) {
            return cost(s, 0, len - 1);
        }
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 1; i < len; i++) {
            dp[i + 1][1] = cost(s, 0, i);
        }
        for (int tk = 2; tk <= k; tk++) {
            for (int i = tk; i < len; i++) {
                int min = len;
                for (int ti = tk - 1; ti <= i; ti++) {
                    min = Math.min(min, dp[ti][tk - 1] + cost(s, ti, i));
                }
                dp[i + 1][tk] = min;
            }
        }

        return dp[len][k];
    }

    private static int cost(String s, int begin, int end) {
        int res = 0;
        while (begin < end) {
            if (s.charAt(end) != s.charAt(begin)) {
                res++;
            }
            begin++;
            end--;
        }
        return res;
    }
}
