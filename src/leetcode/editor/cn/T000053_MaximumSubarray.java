package leetcode.editor.cn;

// 53 - 最大子数组和
public class T000053_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new T000053_MaximumSubarray().new Solution();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }

        int maxSubArraySe(int[] nums) {
            return maxSubArray(0, nums.length - 1, nums);
        }

        int maxSubArray(int l, int r, int[] nums) {
            if (l == r) {
                return nums[l];
            }
            int m = (l + r) / 2;
            int Max = Math.max(maxSubArray(l, m, nums), maxSubArray(m + 1, r, nums));

            int suml = nums[m], t = 0;
            for (int i = m; i >= l; i--) {
                suml = Math.max(suml, t += nums[i]);
            }
            int sumr = nums[m + 1];
            t = 0;
            for (int i = m + 1; i <= r; i++) {
                sumr = Math.max(sumr, t += nums[i]);
            }

            return Math.max(Max, suml + sumr);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
