/*
 * @Author: wx128 wx2048@protonmail.com
 * @Date: 2024-06-01 16:26:48
 * @LastEditors: wx128 wx2048@protonmail.com
 * @LastEditTime: 2024-06-01 21:25:26
 * @Description: to be added
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{
            1,3,-1,-3,5,3,6,7
        };

        int k = 3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString( solution.maxSlidingWindow(nums, k) ));
    }
}