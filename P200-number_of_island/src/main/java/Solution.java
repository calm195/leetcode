/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-22 11:39:50
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-23 10:19:25
 * @Description: to be added
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int col_len = grid.length;
        int row_len = grid[0].length;
        for (int i = 0; i < col_len; i++) {
            for (int j = 0; j < row_len; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int col_len = grid.length;
        int row_len = grid[0].length;
        if ((row < 0 || col < 0) || (row >= row_len || col >= col_len)) {
            return;
        }
        if (grid[col][row] == '1') {
            grid[col][row] = '0';
            dfs(grid, col+1, row);
            dfs(grid, col-1, row);
            dfs(grid, col, row-1);
            dfs(grid, col, row+1);
            return;
        }
        return;
    }
}
