/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-24 15:00:04
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 17:47:53
 * @Description: to be added
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] isVisited;
    boolean res = true;
    List<List<Integer>> lists;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        isVisited = new int[numCourses];
        lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] is : prerequisites) {
            lists.get(is[1]).add(is[0]);
        }
        //System.out.println(lists);

        for (int i = 0; i < numCourses && res; i++) {
            if (isVisited[i] == 0) {
                dfs(i);
            }
        }
        
        return res;
    }

    private void dfs(int i){
        isVisited[i] = 1;
        for (int next : lists.get(i)) {
            if (isVisited[next] == 0) {
                dfs(next);
                if (!res) {
                    return;
                }
            }
            else if (isVisited[next] == 1) {
                res = false;
                return;
            }
        }
        isVisited[i] = 2;
    }
}