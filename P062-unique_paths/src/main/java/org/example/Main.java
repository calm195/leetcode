package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-04 09:45:59
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-04 13:21:30
 * @Description: to be added
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    The test cases are generated so that the answer will be less than or equal to 2 * 109.

    Example 1:
    Input: m = 3, n = 7
    Output: 28

    Example 2:
    Input: m = 3, n = 2
    Output: 3

    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Down -> Down
    2. Down -> Down -> Right
    3. Down -> Right -> Down

    Constraints:
    1 <= m, n <= 100
 */

public class Main {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 0;
        for (int i = 0; i < m; i ++) {
            dp[i + 1][1] = 1;
        }
        for (int i = 0; i < n; i++ ) {
            dp[1][i + 1] = 1;
        }

        for (int i = 2; i <= m; i ++) {
            for (int j = 2; j <= n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}