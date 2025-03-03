package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 15:52:12
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 16:14:31
 * @Description: to be added
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

    Example 1:
    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]

    Example 2:
    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]

    Example 3:
    Input: temperatures = [30,60,90]
    Output: [1,1,0]

    Constraints:
    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100
 */

public class Main {
    public static void main(String[] args) {
        int[] temperatures = {
            73,74,75,71,69,72,76,73
        };
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temps) {
        int len = temps.length;
        if (len == 1) return new int[]{0};
        List<Integer> stack = new ArrayList<>();
        stack.add(0);
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            int index = stack.getLast();
            while (temps[i] > temps[index]) {
                stack.removeLast();
                res[index] = i - index;
                if (stack.isEmpty()) break;
                index = stack.getLast();
            }
            stack.add(i);
        }
        return res;
    }
}