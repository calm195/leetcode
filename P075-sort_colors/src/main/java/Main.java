/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-27 21:18:48
 * @LastEditors: wx128 wx2048@protonmail.com
 * @LastEditTime: 2024-05-30 20:45:58
 * @Description: to be added
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {
            2,0,2,1,1,0
        };
        Solution solution = new Solution();
        solution.setColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
