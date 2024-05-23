/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-22 09:16:29
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-23 10:20:51
 * @Description: to be added
 */
package official;

/**
 * @author wjx
 * @date 3/23/2024 2:38 AM
 */
public class Solution {
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    // 数字电路设计
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }

    // 优化
    public int singleNumber3(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}
