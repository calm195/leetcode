package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-04 13:24:46
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-04 13:26:03
 * @Description: to be added
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}

