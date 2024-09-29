import java.util.Arrays;

/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-29 13:26:22
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-29 14:20:41
 * @Description: 
 * 
 * 二叉搜索树 + 合并区间 complex
 * 单元素深度搜索   timeout
 * 左端点排序 pass
 */
public class Solution {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        int mergedIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[mergedIndex][1] >= intervals[i][0]){
                intervals[mergedIndex][1] = Math.max(intervals[mergedIndex][1],intervals[i][1]);
            } else {
                mergedIndex++;
                intervals[mergedIndex][0] = intervals[i][0];
                intervals[mergedIndex][1] = intervals[i][1];
            }
        }
        return Arrays.copyOfRange(intervals, 0, mergedIndex + 1);
    }
}
