/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-27 22:13:45
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-28 12:45:10
 * @Description: 
 * 
 * 双指针 fail
 * 累加相减
 */
public class Solution {
    public int maxSubArray(int[] nums){
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];
        }
        
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < len; i++) {

        }
        return res;
    }
}
