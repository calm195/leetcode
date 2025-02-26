package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-26 15:03:01
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-26 15:04:29
 * @Description: to be added
 */

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
