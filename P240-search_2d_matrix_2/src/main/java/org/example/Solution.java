package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-26 15:42:20
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-26 15:42:40
 * @Description: to be added
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
