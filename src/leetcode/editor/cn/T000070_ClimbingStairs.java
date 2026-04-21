/**
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 

 

 示例 1： 

 
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶 

 示例 2： 

 
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 

 

 提示： 

 
 1 <= n <= 45 
 

 Related Topics 记忆化 数学 动态规划 
 👍 4058 👎 0

*/

package leetcode.editor.cn;
// 70 - 爬楼梯
public class T000070_ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new T000070_ClimbingStairs().new Solution();
        int n = 5;
        System.out.println(solution.climbStairs(n));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int p = 1, q = 2, r = 3;
        for (int i = 4; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// time out
class RecluceSolution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
}
