package official;

/**
 * @author wjx
 * @date 4/7/2024 9:29 PM
 */
public class MoveZeros2 {
    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }
}
