/**
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 

 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 

 

 示例 1： 

 
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 

 示例 2： 

 
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 

 示例 3： 

 
输入：nums = [1,0,1,2]
输出：3
 

 

 提示： 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 Related Topics 并查集 数组 哈希表 
 👍 2631 👎 0

*/

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

// 128 - 最长连续序列
public class T000128_LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new T000128_LongestConsecutiveSequence().new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int i: nums) {
            set.add(i);
        }
        for (int i: set) {
            if (set.contains(i - 1)) continue;
            int temp = 1;
            while (set.contains(++i)) {
                temp ++;
            }
            res = Math.max(temp, res);
        }
        return res;
    }

    // timeout
    public int longestConsecutive2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int i: nums) {
            int temp = 1;
            int j = i;
            if (set.contains(i)) continue;
            set.add(i);
            while (set.contains(i - 1)) {
                temp++;
                i--;
            }
            while (set.contains(j + 1)) {
                j ++;
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
