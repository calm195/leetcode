package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 19:18:06
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-25 19:30:47
 * @Description: leetcode 官方题解，使用简单的数组扫描法
 */
public class Solution{
    private final int n;
    private final int[] memory;

    public Solution(int n) {
        this.n = n;
        this.memory = new int[n];
    }

    public int allocate(int size, int mID) {
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (memory[i] != 0) {
                count = 0;
            } else {
                ++count;
                if (count == size) {
                    for (int j = i - count + 1; j <= i; ++j) {
                        memory[j] = mID;
                    }
                    return i - count + 1;
                }
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (memory[i] == mID) {
                ++count;
                memory[i] = 0;
            }
        }
        return count;
    }
}
