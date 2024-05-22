/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-22 11:39:27
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-22 11:40:32
 * @Description: to be added
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(grid));
    } 
}
