/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-24 15:00:04
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 13:07:35
 * @Description: to be added
 */

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    HashMap<Integer, HashSet<Integer>> map;
    boolean[] isVisited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // printMap();
        isVisited = new boolean[numCourses];
        HashSet<Integer> historySet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                int res = dfs(i, historySet);
                if (res != -1 && !isVisited[res]) {
                    return false;
                }
                historySet.clear(); 
            }
        }

        return true;
    }

    int dfs(int i, HashSet<Integer> historySet){
        if (historySet.contains(i)) {
            isVisited[i] = false;
            return i;
        }
        else {
            isVisited[i] = true;
        }
        historySet.add(i);
        for (int one : map.get(i)) {
            int temp = dfs(one, historySet);
            if (temp != -1) {
                return temp;
            }
        }
        historySet.remove(i);
        return -1;
    }

    void printMap(){
        for (Integer key: map.keySet()) {
            System.out.println(key + ": " + map.get(key).toString());
        }
    }
}
