/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-23 10:56:56
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-24 11:30:24
 * @Description: to be added
 */

import java.util.Stack;

public class Solution {
    private class Point {
        int col;
        int row;

        Point(int col, int row) {
            this.col = col;
            this.row = row;
        }

        Point leftPoint(){
            return new Point(this.col-1, row);
        }

        Point rightPoint(){
            return new Point(this.col + 1, row);
        }

        Point upPoint(){
            return new Point(this.col, this.row + 1);
        }

        Point downPoint(){
            return new Point(this.col, this.row - 1);
        }
    }

    public int orangesRotting(int[][] grid) {
        int col = grid.length;
        int row = grid[0].length;
        int times = 0;
        Stack<Point> stack = new Stack<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 2) {
                    stack.push(new Point(i, j));
                }
            }
        }

        while (!stack.empty()) {
            Stack<Point> temPoints = new Stack<>();
            while (!stack.empty()) {
                oneDFS(grid, stack.pop(), temPoints);
            }
            stack = temPoints;
            times++;
        }

        if (!isRotted(grid)) {
            return -1;
        }
        return times;
    }

    private boolean isRotted(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void oneDFS(int[][] grid, Point point, Stack<Point> temPoints) {
        int col = point.col;
        int row = point.row;
        if (point.col - 1 < 0) {
            if (isRightRotted(grid, col, row)){
                grid[point.col + 1][point.row] = '2';
                temPoints.push(point.rightPoint());
            }
        }
    }

    private boolean isRightRotted(int[][]grid, int col, int row){
        return grid[col + 1][row] == 1;
    }

    private boolean isLeftRotted(int[][]grid, int col, int row){
        return grid[col - 1][row] == 1;
    }

    private boolean isUpRotted(int[][] grid, int col, int row) {
        return grid[col][row + 1] == 1;
    }

    private boolean isDownRotted(int[][] grid, int col, int row) {
        return grid[col][row - 1] == 1;
    }
}
