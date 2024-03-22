package official;

/**
 * @author wjx
 * @date 3/23/2024 1:16 AM
 */
public class Solution {
    public int singleNumber(int[] nums){
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
