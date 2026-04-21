package leetcode.editor.cn;

// 740 - 删除并获得点数
public class T000740_DeleteAndEarn{
    public static void main(String[] args) {
        Solution solution = new T000740_DeleteAndEarn().new Solution();
        int[] nums = {3,4,2};
        System.out.println(solution.deleteAndEarn(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
