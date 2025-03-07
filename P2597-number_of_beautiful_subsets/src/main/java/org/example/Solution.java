package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-07 16:14:16
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-07 16:48:05
 * @Description: to be added
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    private int ans = 0;
    private final Map<Integer, Integer> map = new HashMap<>();

    public int remold(int[] nums, int k) {
        dfs(nums, k, 0);
        return ans - 1;
    }

    private void dfs(int[] nums, int k, int i) {
        if (i == nums.length) {
            ans ++;
            return;
        }

        dfs(nums, k, i + 1);
        // 选中时，相邻k的数不允许存在
        if (map.getOrDefault(nums[i] - k, 0) == 0 && map.getOrDefault(nums[i] + k, 0) == 0) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            dfs(nums, k, i + 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
        }
    }

    /**
     * 模K分组<p>
     * dp[i][0]：nums[i] 不加入子集<p>
     * dp[i][1]：nums[i] 加入子集<p>
     */
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int num : nums) {
            groups.computeIfAbsent(num % k, key -> new TreeMap<>()).merge(num, 1, Integer::sum);
        }
        int res = 1;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : groups.entrySet()) {
            Map<Integer, Integer> group = entry.getValue();
            int size = group.size();
            int[][] dp = new int[size][2];
            dp[0][0] = 1;
            dp[0][1] = (1 << group.get(group.keySet().iterator().next())) - 1;
            int i = 1;
            Iterator<Map.Entry<Integer, Integer>> it = group.entrySet().iterator();
            Map.Entry<Integer, Integer> pre = it.next();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> cur = it.next();
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                if (cur.getKey() - pre.getKey() == k) {
                    dp[i][1] = dp[i - 1][0] * ( (1 << cur.getValue()) - 1 );
                }
                else {
                    dp[i][1] = ( dp[i - 1][0] + dp[i - 1][1] ) * ( (1 << cur.getValue()) - 1 );
                }
                pre = cur;
                i ++;
            }
            res *= dp[size - 1][0] + dp[size - 1][1];
        }
        return res - 1;
    }
}
