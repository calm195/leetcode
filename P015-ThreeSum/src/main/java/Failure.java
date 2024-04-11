import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author wjx
 * @date 4/10/2024 4:30 PM
 */
public class Failure {
    // time out
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int target = - (nums[i] + nums[j]);
                if (map.containsKey(target) && map.get(target) != i && map.get(target)!= j){
                    System.out.println(nums[i] + " " + nums[j] + " " + map.get(target));
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    Collections.sort(list);
                    if (!result.contains(list)) result.add(list);
                }
            }
        }
        return result;
    }
}
