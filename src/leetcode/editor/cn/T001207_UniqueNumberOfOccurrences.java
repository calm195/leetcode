//给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 
//输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 
// 👍 245 👎 0


package leetcode.editor.cn;


import java.util.*;

// 1207 - 独一无二的出现次数
public class T001207_UniqueNumberOfOccurrences{
    public static void main(String[] args) {
        Solution solution = new T001207_UniqueNumberOfOccurrences().new Solution();
        // TO TEST
        int[] arr = new int[] {1,2};
        System.out.println(solution.uniqueOccurrences(arr));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 时间空间都消耗太大
    public boolean uniqueOccurrences2(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i: map.keySet()) {
            if (set.contains(map.get(i))) {
                return false;
            } else {
                set.add(map.get(i));
            }
        }
        return true;
    }

    // 时间消耗很少，但空间巨大
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i: arr) {
            i += 1000;
            count[i]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i: count) {
            if (i == 0) continue;
            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
