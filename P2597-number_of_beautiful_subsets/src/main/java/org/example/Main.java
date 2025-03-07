package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-07 14:06:03
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-07 16:33:49
 * @Description: to be added
    You are given an array nums of positive integers and a positive integer k.

    A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.

    Return the number of non-empty beautiful subsets of the array nums.
    A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. 
    Two subsets are different if and only if the chosen indices to delete are different.

    Example 1:
    Input: nums = [2,4,6], k = 2
    Output: 4
    Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
    It can be proved that there are only 4 beautiful subsets in the array [2,4,6].
    Example 2:
    Input: nums = [1], k = 1
    Output: 1
    Explanation: The beautiful subset of the array nums is [1].
    It can be proved that there is only 1 beautiful subset in the array [1].
    
    Constraints:
    1 <= nums.length <= 18
    1 <= nums[i], k <= 1000
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {
            //2, 4, 6
            4,2,5,9,10,3
        };
        int k = 1;
        System.out.println(new Solution().beautifulSubsets(nums, k));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return 1;
        int res = 0;

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len - 1; i ++) {
            list.add(nums[i]);
            for (int j = i + 1; j < len; j ++) {
                boolean tag = true;
                for (int num : list) {
                    if (num - nums[j] == k) {
                        tag = false;
                        break;
                    }
                }
                if (tag) list.add(nums[j]);
            }
            res += Math.pow(2, list.size()) - 1;
            list.clear();
        }

        return res;
    }
}