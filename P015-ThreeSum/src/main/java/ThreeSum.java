import java.util.*;

/**
 * @author wjx
 * @date 4/9/2024 6:36 PM
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] num = {-2,0,0,2,2};
        ThreeSum test = new ThreeSum();
        System.out.println(test.threeSum(num));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                if (left > i + 1 && nums[left] == nums[left - 1]){
                    left ++;
                    continue;
                }
                if (right < len - 1 && nums[right] == nums[right + 1]){
                    right --;
                    continue;
                }
                while (left < right && nums[left] + nums[right] > target){
                    right--;
                }
                if (left < right && nums[left] + nums[right] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(-target);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    right--;
                }
                left++;
            }
        }

        return result;
    }
}
