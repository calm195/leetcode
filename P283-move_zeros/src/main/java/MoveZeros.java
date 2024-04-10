import official.MoveZeros2;

import java.util.Arrays;

/**
 * @author wjx
 * @date 4/6/2024 7:51 PM
 */
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros test = new MoveZeros();
        MoveZeros2 off = new MoveZeros2();
        int[] nums = {0, 1, 2, 0, 0, 3, 12};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {0, 1, 2, 0, 0, 3, 12};
        off.moveZeroes2(nums2);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        int zero_index = -1;
        for (; index < len; index++) {
            if (nums[index] == 0) {
                if (zero_index == -1)
                    zero_index = index;
            } else {
                if (zero_index == -1) {
                    continue;
                }
                nums[zero_index] = nums[index];
                nums[index] = 0;
                zero_index++;
            }
//            System.out.println("zero index: " + zero_index + "  " + Arrays.toString(nums));
        }
    }
}
