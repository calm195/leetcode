/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-27 22:13:45
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-28 12:57:54
 * @Description: 
 * 
 * 双指针 fail
 * 累加相减 complex
 * 动态规划 pass
 */
public class Solution {
    public int maxSubArray(int[] nums){
        int pre = 0, res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(pre, res);
        }
        return res;
    }
}
