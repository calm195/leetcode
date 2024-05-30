/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-27 20:51:50
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 21:17:54
 * @Description: to be added
 */

public class Solution {
    public int majorityElement(int[] nums){
        int len = nums.length;
        int res = nums[0];
        int times = 1;
        for (int i = 1; i < len; i++) {
            if (res != nums[i]) {
                if (times > 0) {
                    times --;
                }
                else {
                    res = nums[i];
                    times = 1;
                }
            }
            else {
                times++;
            }
        }
        return res;
    }
}
