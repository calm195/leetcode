import java.util.HashSet;

/**
 * @author wjx
 * @date 4/5/2024 11:40 PM
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        HashSet<Integer> check_set = new HashSet<>();
        for (int num: nums){
            check_set.add(num);
        }
        for (int num : nums) {
            if(!check_set.contains(num-1)){
                int cur_num = num;
                int cur_len = 1;
                while (check_set.contains(cur_num + 1)){
                    cur_len++;
                    cur_num++;
                }
                longestLength = Math.max(longestLength, cur_len);
            }
        }

        return longestLength;
    }
}
