package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 18:09:13
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 18:09:15
 * @Description: to be added
 */

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length ;
        int a = nums[0] , b = nums[0] ;
        for(int i : nums) {
            if(i > a) {
                a = i ;
            }
            if(i < b) {
                b = i ;
            }
        }
        int[] count = new int[a - b + 1] ;
        int[] ans = new int[k] ;
        int temp = k ;
        for(int i = 0 ; i < n ; i++) {
            count[nums[i] - b]++ ;
        }
        while(temp > 0) {
            int max = 0 ; 
            for(int i = 0 ; i < count.length ; i++ ) {
                if(count[i] > max) {
                    max = count[i] ;
                }
            }
            for(int j = 0 ; j < count.length ; j++ ) {
                if(count[j] == max) {
                    ans[k - temp] = j + b ;
                    count[j] = 0 ;
                    temp-- ;
                }
            }
        }
        return ans ;
    }
}
