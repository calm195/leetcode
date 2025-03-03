package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-04 00:21:44
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-04 00:28:37
 * @Description: to be added
 */

public class Solution {
    public boolean checkPartitioning(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i < len; i ++) {
            for (int start = 0; start <= len - i; start++) {
                int end = start + i - 1;
                switch (i) {
                    case 1:
                        dp[start][end] = true;
                        break;
                    case 2:
                        dp[start][end] = s.charAt(start) == s.charAt(end);
                        break;
                    default:
                        dp[start][end] = (s.charAt(start) == s.charAt(end)) && dp[start + 1][end - 1];
                        break;
                }
            }
        }

        for (int start = 1; start < len - 1; start ++ ) {
            if(!dp[0][start - 1]) continue;
            for (int end = start; end < len - 1; end ++) {
                if (dp[start][end] && dp[end + 1][len - 1]) return true;
            }
        }
        return false;
    }
}
