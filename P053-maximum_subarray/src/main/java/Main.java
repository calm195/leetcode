/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-27 21:56:43
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-28 10:46:11
 * @Description:
 *  
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
