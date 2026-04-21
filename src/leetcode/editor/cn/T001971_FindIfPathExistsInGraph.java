/**
有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 
edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。 

 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。 

 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 
true，否则返回 false 。 

 

 示例 1： 
 
 
输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
输出：true
解释：存在由顶点 0 到顶点 2 的路径:
- 0 → 1 → 2 
- 0 → 2
 

 示例 2： 
 
 
输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
输出：false
解释：不存在由顶点 0 到顶点 5 的路径.
 

 

 提示： 

 
 1 <= n <= 2 * 10⁵ 
 0 <= edges.length <= 2 * 10⁵ 
 edges[i].length == 2 
 0 <= ui, vi <= n - 1 
 ui != vi 
 0 <= source, destination <= n - 1 
 不存在重复边 
 不存在指向顶点自身的边 
 

 Related Topics 深度优先搜索 广度优先搜索 并查集 图 
 👍 258 👎 0

*/

package leetcode.editor.cn;
// 1971 - 寻找图中是否存在路径
public class T001971_FindIfPathExistsInGraph{
    public static void main(String[] args) {
        Solution solution = new T001971_FindIfPathExistsInGraph().new Solution();
        int n = 10;
        int[][] edges = {{2,6}, {4,7}, {1,2}, {3,5}, {7,9}, {6,4}, {9,8}, {0,1}, {3,0}};
        int source = 3;
        int destination = 5;
        System.out.println(solution.validPath(n, edges, source, destination));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] indexes;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        for (int[] edge: edges) {
            union(edge[0], edge[1]);
        }
        return findRoot(indexes[source]) == findRoot(indexes[destination]);
    }

    private void union(int i, int j) {
        int a = findRoot(i);
        int b = findRoot(j);
        if (a != b) {
            indexes[a] = b;
        }
    }

    private int findRoot(int i) {
        if (indexes[i] == i) {
            return i;
        }
        indexes[i] = findRoot(indexes[i]);
        return indexes[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
