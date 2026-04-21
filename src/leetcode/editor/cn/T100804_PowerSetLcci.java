/**
幂集。编写一种方法，返回某集合的所有子集。集合中 不包含重复的元素。 

 说明：解集不能包含重复的子集。 

 示例： 

 
 输入：nums = [1,2,3]
 输出：
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 

 Related Topics 位运算 数组 回溯 
 👍 117 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 面试题 08.04 - 幂集
public class T100804_PowerSetLcci{
    public static void main(String[] args) {
        Solution solution = new T100804_PowerSetLcci().new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        res.add(new ArrayList<>());
        for (int num : nums) {
            for (int i = 0, j = res.size(); i < j; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

class BitSolution {
    public List<List<Integer>> subsets(int[] nums) {
        //子集的长度是2的nums.length次方，这里通过移位计算
        int length = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(length);
        //遍历从0到length中间的所有数字，根据数字中1的位置来找子集
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                //如果数字i的某一个位置是1，就把数组中对
                //应的数字添加到集合
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
}
