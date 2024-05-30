/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-27 21:19:00
 * @LastEditors: wx128 wx2048@protonmail.com
 * @LastEditTime: 2024-05-30 20:48:13
 * @Description: to be added
 */
public class Solution {
    public void setColors(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i <= right; i++) {
            while(i <= right && nums[i] == 2){
                int tmp = nums[right];
                nums[right] = 2;
                nums[i] = tmp;
                right--;
            }
            if (nums[i] == 0) {
                int tmp = nums[left];
                nums[left] = 0;
                nums[i] = tmp; 
                left++;
            }
        }
    }
}
