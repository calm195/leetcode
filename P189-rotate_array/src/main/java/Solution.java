import java.util.Arrays;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (len < 2 || k <= 0) return;

        int temp = nums[0];
        int start = 0;
        int pos = (k + start) % len;
        int step = len;

        while (step > 0) {
            int tem = temp;
            temp = nums[pos];
            nums[pos] = tem;
            if (pos == start) {
                start++;
                pos++;
                temp = nums[pos];
            }
            pos = (k + pos) % len;
            step--;
        }
    }

    /**
     * 思路正确，但是没有考虑到是否覆盖到所有元素。
     * public static void rotate(int[] nums, int k) {
     * int len = nums.length;
     * if (len < 2) return;
     * if (k > len) k %= len;
     * int index = 0;
     * int pos = (index + k) % len;
     * int temp = nums[pos];
     * int tempIndex = nums[index];
     * int step = len;
     * while (step >= 0){
     * temp = nums[pos];
     * nums[pos] = tempIndex;
     * tempIndex = temp;
     * index = pos;
     * pos = (index + k) % len;
     * step--;
     * System.out.println(Arrays.toString(nums));
     * }
     * }
     * <p>
     * 复制粘贴 效率一般
     * public static void rotate(int[] nums, int k) {
     * int len = nums.length;
     * if (len < 2 )
     * return;
     * if (k > len)
     * k %= len;
     * int[] left = Arrays.copyOfRange(nums, 0, len - k);
     * int[] right = Arrays.copyOfRange(nums, len - k, len);
     * for (int i = 0; i < right.length; i++) {
     * nums[i] = right[i];
     * }
     * for (int i = right.length; i < len; i++) {
     * nums[i] = left[i - right.length];
     * }
     * }
     * <p>
     * 暴力解法 超时
     * public static void rotate(int[] nums, int k) {
     * int len = nums.length;
     * int temp = nums[len - 1];
     * while (k > 0){
     * for (int i = len - 1; i > 0; i--) {
     * nums[i] = nums[i - 1];
     * }
     * nums[0] = temp;
     * k--;
     * temp = nums[len - 1];
     * }
     * }
     */

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99}; // len - k = index
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 4;
        System.out.println("Origin: " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
