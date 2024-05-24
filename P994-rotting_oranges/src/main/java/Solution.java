/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-23 10:56:56
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-24 14:56:35
 * @Description: to be added
 */

import java.util.Iterator;
import java.util.Stack;

public class Solution {
    private class Point {
        int col;
        int row;

        Point(int col, int row) {
            this.col = col;
            this.row = row;
        }

        Point leftPoint() {
            return new Point(this.col - 1, row);
        }

        Point rightPoint() {
            return new Point(this.col + 1, row);
        }

        Point upPoint() {
            return new Point(this.col, this.row - 1);
        }

        Point downPoint() {
            return new Point(this.col, this.row + 1);
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

        if (stack.empty() && isRotted(grid)){
            return 0;
        }

        while (!stack.empty()) {
            Stack<Point> temPoints = new Stack<>();
            while (!stack.empty()) {
                oneDFS(grid, stack.pop(), temPoints);
            }
            //printGrid(grid);
            printStack(stack);

            stack = temPoints;
            times++;
        }

        if (!isRotted(grid)) {
            printGrid(grid);      
            return -1;
        }
        return times - 1;
    }

    private void printGrid(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    private void printStack(Stack<Point> stack){
        Iterator<Point> value = stack.iterator();
        while (value.hasNext()) {
            System.out.println(value.next().col + " " + value.next().row);
        }
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
        System.out.println(col + " + " + row);
        // printGrid(grid);
        if (col - 1 >= 0) {
            if (isLeftRotted(grid, col, row)) {
                grid[col - 1][row] = 2;
                temPoints.push(point.leftPoint());
            }
        }
        if (col + 1 < grid.length) {
            if (isRightRotted(grid, col, row)) {
                grid[col + 1][row] = 2;
                temPoints.push(point.rightPoint());
            }
        }
        if (row - 1 >= 0) {
            if (isUpRotted(grid, col, row)) {
                grid[col][row - 1] = 2;
                temPoints.push(point.upPoint());
            }
        }
        if (row + 1 < grid[0].length) {
            if (isDownRotted(grid, col, row)) {
                grid[col][row + 1] = 2;
                temPoints.push(point.downPoint());
            }
        }

    }

    private boolean isRightRotted(int[][] grid, int col, int row) {
        return grid[col + 1][row] == 1;
    }

    private boolean isLeftRotted(int[][] grid, int col, int row) {
        return grid[col - 1][row] == 1;
    }

    private boolean isUpRotted(int[][] grid, int col, int row) {
        return grid[col][row - 1] == 1;
    }

    private boolean isDownRotted(int[][] grid, int col, int row) {
        return grid[col][row + 1] == 1;
    }
}
