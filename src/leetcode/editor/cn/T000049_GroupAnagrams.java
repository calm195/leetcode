//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 
//
// 示例 1: 
//
// 
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 
// 
//
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 解释： 
//
// 
// 在 strs 中没有字符串可以通过重新排列来形成 "bat"。 
// 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。 
// 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。 
// 
//
// 示例 2: 
//
// 
// 输入: strs = [""] 
// 
//
// 输出: [[""]] 
//
// 示例 3: 
//
// 
// 输入: strs = ["a"] 
// 
//
// 输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 
// 👍 2407 👎 0


package leetcode.editor.cn;

import java.util.*;

// 49 - 字母异位词分组
public class T000049_GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new T000049_GroupAnagrams().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.toString(strs));
        System.out.println(Arrays.toString(solution.groupAnagrams(strs).toArray()));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sortedString = String.copyValueOf(temp).intern();
            List<Integer> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(i);
            map.put(sortedString, list);
        }

        for (List<Integer> list: map.values()) {
            List<String> temp = new ArrayList<>();
            for (Integer i: list) {
                temp.add(strs[i]);
            }
            res.add(temp);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
