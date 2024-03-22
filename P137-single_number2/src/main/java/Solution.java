import java.util.HashSet;

/**
 * @author wjx
 * @date 3/23/2024 2:23 AM
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> exceptSet = new HashSet<>();
        HashSet<Integer> containSet = new HashSet<>();
        for (int num: nums){
            if (exceptSet.contains(num)){
                continue;
            }
            if (containSet.contains(num)){
                containSet.remove(num);
                exceptSet.add(num);
                continue;
            }
            containSet.add(num);
        }
        return (int) containSet.toArray()[0];
    }
}
