/**
给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [
ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的
元素。 

 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] 
（下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。 

 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。 

 

 示例 1： 

 输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
输出：1
解释：source 可以按下述方式转换：
- 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
- 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
 

 示例 2： 

 输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
输出：2
解释：不能对 source 执行交换操作。
source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。 

 示例 3： 

 输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3
],[1,4]]
输出：0
 

 

 提示： 

 
 n == source.length == target.length 
 1 <= n <= 10⁵ 
 1 <= source[i], target[i] <= 10⁵ 
 0 <= allowedSwaps.length <= 10⁵ 
 allowedSwaps[i].length == 2 
 0 <= ai, bi <= n - 1 
 ai != bi 
 

 Related Topics 深度优先搜索 并查集 数组 
 👍 88 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1722 - 执行交换操作后的最小汉明距离
public class T001722_MinimizeHammingDistanceAfterSwapOperations{
    public static void main(String[] args) {
        Solution solution = new T001722_MinimizeHammingDistanceAfterSwapOperations().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        // 路径压缩：直接指向根节点
        parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int i, int j) {
        int root_i = find(i);
        int root_j = find(j);
        if (root_i != root_j) {
            parent[root_i] = root_j;
        }
    }
}

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        // 允许交换的下标进行连通
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // 按连根节点对下标进行分组
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int matches = 0;

        // 遍历每一个连通分量
        for (List<Integer> indices : groups.values()) {
            // 统计当前分量中 source 里的元素频率
            Map<Integer, Integer> cnts = new HashMap<>();
            for (int idx : indices) {
                cnts.put(source[idx], cnts.getOrDefault(source[idx], 0) + 1);
            }

            // target 里的元素有多少能在 source 中找到匹配
            int match_in_group = 0;
            for (int idx : indices) {
                int val = target[idx];
                if (cnts.getOrDefault(val, 0) > 0) {
                    match_in_group += 1;
                    cnts.put(val, cnts.get(val) - 1);
                }
            }

            matches += match_in_group;
        }

        // 总长度 - 总匹配数
        return n - matches;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
