/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-27 18:41:14
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-27 19:34:58
 * @Description: 双指针解法，滑动窗口 
 */
public class Solution {
    public int takeCharacters(String s, int k) {
        int len = s.length();
        if (len < 3 * k) {
            return -1;
        }
        int[] nums = new int[3];
        for (int i = 0; i < len; i++){
            nums[s.charAt(i) - 'a'] ++;
        }
        if (nums[0] < k || nums[1] < k || nums[2] < k) {
            return -1;
        }

        int left = 0, right = 0, ans = len;
        for (; right < len; right++){
            nums[s.charAt(right) - 'a']--;
            if (left < right && (nums[0] < k || nums[1] < k || nums[2] < k)) {
                nums[s.charAt(left) - 'a'] ++;
                left ++;
            }
            if (nums[0] >= k && nums[1] >= k && nums[2] >= k) {
                ans = Math.min(ans, len + left - right - 1);
            }
        }

        return ans;
    }
}
