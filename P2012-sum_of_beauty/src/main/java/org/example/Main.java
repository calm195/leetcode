package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-11 00:25:31
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-11 01:06:09
 * @Description: to be added
    You are given a 0-indexed integer array nums. For each index i (1 <= i <= nums.length - 2) the beauty of nums[i] equals:

    2, if nums[j] < nums[i] < nums[k], for all 0 <= j < i and for all i < k <= nums.length - 1.
    1, if nums[i - 1] < nums[i] < nums[i + 1], and the previous condition is not satisfied.
    0, if none of the previous conditions holds.
    Return the sum of beauty of all nums[i] where 1 <= i <= nums.length - 2.

    Example 1:
    Input: nums = [1,2,3]
    Output: 2
    Explanation: For each index i in the range 1 <= i <= 1:
    - The beauty of nums[1] equals 2.

    Example 2:
    Input: nums = [2,4,6,4]
    Output: 1
    Explanation: For each index i in the range 1 <= i <= 2:
    - The beauty of nums[1] equals 1.
    - The beauty of nums[2] equals 0.
    
    Example 3:
    Input: nums = [3,2,1]
    Output: 0
    Explanation: For each index i in the range 1 <= i <= 1:
    - The beauty of nums[1] equals 0.
    
    Constraints:
    3 <= nums.length <= 105
    1 <= nums[i] <= 105
 */

public class Main {
    public static void main(String[] args) {
        int[] nums = {
            2, 4, 6, 4
        };
        
        System.out.println(sumOfBeauties(nums));
    }

    public static int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] beauties = new int[len];

        ArrayDeque<Integer> leftDeque = new ArrayDeque<>();
        ArrayDeque<Integer> leftMaxDeque = new ArrayDeque<>();
        ArrayDeque<Integer> rightDeque = new ArrayDeque<>();
        ArrayDeque<Integer> rightMinDeque = new ArrayDeque<>();
        leftDeque.offer(nums[0]);
        leftMaxDeque.offer(nums[0]);
        rightDeque.offer(nums[len - 1]);
        rightMinDeque.offer(nums[len - 1]);

        for (int i = len - 2; i > 1; i --) {
            rightDeque.offer(nums[i]);
            if (rightMinDeque.getLast() > nums[i]){
                rightMinDeque.offer(nums[i]);
            } else {
                rightMinDeque.offer(rightMinDeque.getLast());
            }
        }

        for (int i = 1; i < len - 1; i ++) {
            if (nums[i] <= leftDeque.getLast() || nums[i] >= rightDeque.getLast()) {
                beauties[i] = 0;
            }
            else if (nums[i] <= leftMaxDeque.getLast() || nums[i] >= rightMinDeque.getLast()) {
                beauties[i] = 1;
            }
            else if (nums[i] > leftMaxDeque.getLast() && nums[i] < rightMinDeque.getLast()) {
                beauties[i] = 2;
            }

            rightDeque.pollLast();
            rightMinDeque.pollLast();
            if (leftMaxDeque.getLast() < nums[i]) {
                leftMaxDeque.offer(nums[i]);
            } else {
                leftMaxDeque.offer(leftMaxDeque.getLast());
            }
            leftDeque.offer(nums[i]);
        }

        return Arrays.stream(beauties).sum();
    }
}