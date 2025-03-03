package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 16:14:29
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 18:06:45
 * @Description: to be added
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]
    

    Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

    Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {
            1, 1, 1, 2, 2, 3
        };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i ++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((i1, i2) -> map.get(i1) - map.get(i2));

        for (Integer key: map.keySet()) {
            if (heap.size() < k) heap.add(key);
            else if (map.get(key) > map.get(heap.peek())){
                heap.remove();
                heap.add(key);
            }
        }

        int i = 0;
        while (!heap.isEmpty()){
            res[i] = heap.poll();
            i ++;
        }

        return res;
    }
}