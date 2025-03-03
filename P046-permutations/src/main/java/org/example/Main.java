package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 13:44:43
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 15:17:22
 * @Description: to be added
    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]

    Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> temp = permute(nums);
        for (List<Integer> elem : temp) {
            for (Integer e: elem) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }
        // System.out.println(Arrays.deepToString(permute(nums).toArray()));
    }
    
    static List<List<Integer>> res = new ArrayList<>();
    
    public static List<List<Integer>> permute(int[] nums){
        boolean[] mark = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(list, nums, mark);
        return res;
    }

    private static void dfs(List<Integer> list, int[] nums, boolean[] mark){
        if (list.size() == nums.length) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                list.add(nums[i]);
                mark[i] = true;
                dfs(list, nums, mark);
                mark[i] = false;
                list.remove(list.indexOf(nums[i]));
            }   
        }
    }
}