package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-26 15:58:10
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-02 21:44:35
 * @Description: to be added
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

    

    Example 1:


    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[7,4,1],[8,5,2],[9,6,3]]
    Example 2:


    Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    

    Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };

        print(matrix);
        System.out.println("---------");
        rotate(matrix);

        System.out.println(Arrays.deepToString(matrix));
        print(matrix);
    }

    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        m >>= 1;
        int n = matrix[0].length;
        int nl = n;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < nl - 1; j ++) {
                int ii = j;
                int jj = n - 1 - i;
                int temp = matrix[ii][jj];
                int tempii = ii;
                matrix[ii][jj] = matrix[i][j];
                matrix[i][j] = temp;

                ii = jj;
                jj = n - 1 - tempii;
                tempii = ii;
                temp = matrix[ii][jj];
                matrix[ii][jj] = matrix[i][j];
                matrix[i][j] = temp;

                ii = jj;
                jj = n - 1 - tempii;
                temp = matrix[ii][jj];
                matrix[ii][jj] = matrix[i][j];
                matrix[i][j] = temp;

                print(matrix);
            }
            nl-=1;
            System.out.println("-------------");
        }
    }

    private static void print(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}