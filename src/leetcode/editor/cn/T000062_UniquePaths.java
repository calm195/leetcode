package leetcode.editor.cn;

import java.util.Arrays;

// 62 - 不同路径
public class T000062_UniquePaths{
    public static void main(String[] args) {
        Solution solution = new T000062_UniquePaths().new Solution();
        int m = 3;
        int n = 3;
        System.out.println(solution.uniquePaths(m, n));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j - 1] ;
            }
        }
        return cur[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
