/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * 只会存在一个有效答案
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
 * <p>
 * Related Topics 数组 哈希表
 * 👍 20117 👎 0
 */

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

// 1 - 两数之和
public class T000001_TwoSum {
    public static void main(String[] args) {
        Solution solution = new T000001_TwoSum().new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    // 两个相同并且符合要求
                    if (target == nums[i] * 2) {
                        return new int[]{map.get(nums[i]), i};
                    }
                } else {
                    map.put(nums[i], i);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                int other = target - nums[i];
                // 排除自身
                if (other != nums[i] && map.containsKey(other)) {
                    return new int[]{i, map.get(other)};
                }
            }
            return new int[]{0, 0};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
