import java.util.Arrays;

/**
 * @author wjx
 * @date 3/23/2024 2:45 AM
 */
public class SingleNumber3 {
    public static void main(String[] args) {
        SingleNumber3 singleNumber3 = new SingleNumber3();
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber3.singleNumber(nums)));
    }

    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
