package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-26 15:08:55
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-26 15:54:39
 * @Description: to be added
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
    

    Example 1:


    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    Output: true
    Example 2:


    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
    Output: false
    

    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= n, m <= 300
    -109 <= matrix[i][j] <= 109
    All the integers in each row are sorted in ascending order.
    All the integers in each column are sorted in ascending order.
    -109 <= target <= 109
 */

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    static boolean res;
    static boolean[][] check;

    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        check = new boolean[matrix.length][matrix[0].length];
        search(i, j, matrix, target);

        return res;
    }
    
    private static void search(int i, int j, int[][] matrix, int target){
        if (matrix[i][j] > target && !check[i][j]) {
            check[i][j] = true;
            if (j - 1 >= 0) search(i, j - 1, matrix, target);
        } else if (matrix[i][j] == target) {
            res = true;
        } else if (matrix[i][j] < target && !check[i][j]) {
            check[i][j] = true;
            if (i + 1 < matrix.length) search(i + 1, j, matrix, target);
        }
    }
}