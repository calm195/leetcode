/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-27 21:19:00
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 22:23:41
 * @Description: to be added
 */
public class Solution {
    public void setColors(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int middle = (right - left) >> 1 + left;
        int setted = 0;

        while (setted < nums.length) {
            while (nums[left] == 0) {
                left ++;
                setted ++;
            }
            while (nums[right] == 2) {
                right --;
                setted ++;
            }
            while (nums[left] == 2) {
                int temp = nums[right];
                nums[right] = 2;
                nums[left] = temp;
                right--;
                setted ++;
            }
            while (nums[right] == 0) {
                int temp = nums[left];
                nums[left] = 0;
                nums[right] = temp;
                left++;
                setted++;
            }
            while (nums[left] == 1) {
                middle = (left + right) >> 1;
                int temp = nums[middle];
                nums[left] = temp;
                nums[middle] = 1;
            }
        }
    }
}
