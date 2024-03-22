import java.util.HashSet;

/**
 * @author wjx
 * @date 3/23/2024 12:51 AM
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
        official.Solution official = new official.Solution();
        System.out.println(official.singleNumber(nums));
    }

    public int singleNumber(int[] nums){
        int len = nums.length;
        if (len < 1) {
            return len;
        }
        if (len == 1) {
            return nums[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        return (int) set.toArray()[0];

    }
}
