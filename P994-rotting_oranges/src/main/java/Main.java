/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-23 10:56:36
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-23 11:07:57
 * @Description: to be added
 */
public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] grid = new int[][]{
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(solution.orangesRotting(grid)); 
    }
}
