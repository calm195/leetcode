package org.example;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-26 13:04:36
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-26 15:01:43
 * @Description: to be added
    Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

    

    Example 1:

    Input: nums = [1,2,0]
    Output: 3
    Explanation: The numbers in the range [1,2] are all in the array.
    Example 2:

    Input: nums = [3,4,-1,1]
    Output: 2
    Explanation: 1 is in the array but 2 is missing.
    Example 3:

    Input: nums = [7,8,9,11,12]
    Output: 1
    Explanation: The smallest positive integer 1 is missing.
    

    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
 */

public class Main {
    public static void main(String[] args) {
        int[] nums =  {1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i ++){
            if (nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i --;
            }
        }
        for (int i = 0; i < len; i ++){
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}