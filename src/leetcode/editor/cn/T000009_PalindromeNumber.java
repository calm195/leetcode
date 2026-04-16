/**
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 

 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 

 
 例如，121 是回文，而 123 不是。 
 

 

 示例 1： 

 
输入：x = 121
输出：true
 

 示例 2： 

 
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 

 示例 3： 

 
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
 

 

 提示： 

 
 -2³¹ <= x <= 2³¹ - 1 
 

 

 进阶：你能不将整数转为字符串来解决这个问题吗？ 

 Related Topics 数学 
 👍 3173 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

// 9 - 回文数
public class T000009_PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new T000009_PalindromeNumber().new Solution();
        int x = 22;
        System.out.println(solution.isPalindrome(x));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class ArrayListSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (x > 0) {
            arrayList.add(x % 10);
            x /= 10;
        }

        int len = arrayList.size() >> 1;
        int size = arrayList.size();
        for (int i = 0; i < len; i ++) {
            if (!Objects.equals(arrayList.get(i), arrayList.get(size - i - 1))) {
                return false;
            }
        }

        return true;
    }
}
class DequeSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        while (x > 0) {
            int temp = x % 10;
            x /= 10;
            queue.add(temp);
        }
        while (!queue.isEmpty()) {
            if (!Objects.equals(queue.peekFirst(), queue.peekLast())) {
                return false;
            }
            queue.pollFirst();
            queue.pollLast();
        }
        return true;
    }
}


}
