package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 20:44:23
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-25 20:56:26
 * @Description: to be added
 */

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
