/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-22 11:39:27
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-23 10:41:23
 * @Description: to be added
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][]{
            {'1', '0', '1', '1','0','1','1'},
            //{'1','1','0','1','0'},
            //{'0','1','0','0','0'},
            //{'0','0','0','0','1'}
        };
        System.out.println(grid.length);
        System.out.println(solution.numIslands(grid));
    } 
}
