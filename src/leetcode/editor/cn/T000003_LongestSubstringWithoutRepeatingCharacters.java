/**
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 

 

 示例 1: 

 
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 

 示例 2: 

 
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 

 示例 3: 

 
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

 

 提示： 

 
 0 <= s.length <= 5 * 10⁴ 
 s 由英文字母、数字、符号和空格组成 
 

 Related Topics 哈希表 字符串 滑动窗口 
 👍 11425 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// 3 - 无重复字符的最长子串
public class T000003_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new T000003_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abca#bcbb"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

    class DequeSolution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2) {
                return s.length();
            }
            Deque<Character> deque = new ArrayDeque<>();
            int slow = 0;
            int fast = 0;
            int res = 0;

            while (res < s.length() - slow){
                while (deque.contains(s.charAt(fast)) && slow < fast) {
                    deque.pollFirst();
                    slow++;
                }
                deque.addLast(s.charAt(fast));
                fast ++;
                res = Math.max(res, fast - slow);
            }

            return res;
        }
    }

    class CacheSolution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2) {
                return s.length();
            }
            boolean[] dict = new boolean[26];
            char a = 'a';
            int slow = 0;
            int fast = 0;
            int res = 0;

            while (res < s.length() - slow){
                int dictIndex = s.charAt(fast) - a;
                while (dict[dictIndex]) {
                    dict[s.charAt(slow) - a] = false;
                    slow++;
                }
                fast ++;
                dict[dictIndex] = true;
                res = Math.max(res, fast - slow);
            }

            return res;
        }
    }
}
