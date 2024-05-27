/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-24 14:59:50
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 12:55:42
 * @Description: to be added
 */
public class Main {
    public static void main(String[] args){
        int numCourses = 4;
        int[][] prerequisites = new int[][] {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2},
            {1, 3}
            //{0, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}
