/**
 * @author wjx
 * @date 2024/02/14 07:32 PM
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int right_most = 0;
        for (int i = 0; i < len; i++) {
            if (i <= right_most) {
                right_most = Math.max(right_most, i + nums[i]);
            }
        }
        return right_most >= len - 1;
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int jump_time = 0;
        int right_most = nums[0];
        for (int i = 0; ; ) {
            int temp_index = i;
            if (right_most >= len - 1) {
                jump_time++;
                return jump_time;
            }
            for (int j = temp_index + 1; j <= temp_index + nums[temp_index]; j++) {
                if (j + nums[j] > right_most) {
                    right_most = j + nums[j];
                    i = j;
                }
            }
            jump_time++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(canJump(nums));
        System.out.println(jump(nums));
    }
}
