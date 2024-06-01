/*
 * @Author: wx128 wx2048@protonmail.com
 * @Date: 2024-06-01 16:29:05
 * @LastEditors: wx128 wx2048@protonmail.com
 * @LastEditTime: 2024-06-01 21:23:50
 * @Description: to be added
 */

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k){
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[ deque.peekLast() ]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] result = new int[len - k + 1];
        result[0] = nums[deque.peekFirst()];

        for (int i = k; i < len; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - k + 1 > deque.peekFirst()) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }

}
