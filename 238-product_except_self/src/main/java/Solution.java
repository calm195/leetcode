/**
 * @author wjx
 * @date 2024/02/16 06:07 PM
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] productExceptSelf(int[] nums) {
        // 空间复杂度为O(1)
            int len = nums.length;
            int[] result = new int[len];
            result[0] = 1;
            for (int i = 1; i < len; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = len - 1; i >= 0; i--) {
                result[i] *= right;
                right *= nums[i];
            }
            return result;

        /* 空间复杂度为O(n)
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;*/
    }
}
