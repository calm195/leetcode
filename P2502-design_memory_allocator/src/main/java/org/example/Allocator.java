package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 14:46:14
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-25 15:52:13
 * @Description: 
 * 
 * 第一版：失败，无法处理内存碎片，难以有效找出连续的内存序列。
 */
public class Allocator {

    private final Integer[] arr;
    private final Map<Integer, HashSet<Integer>> map;
    private final Queue<Integer> queue;
    
    public Allocator(int n) {
        arr = new Integer[n];
        map = new HashMap<>();
        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i ++) {
            queue.add(i);
        }
    }

    public int allocate(int size, int mID) {
        if (queue.isEmpty()) {
            return -1;
        }
        HashSet<Integer> set = map.get(mID);
        if (set == null) {
            set = new HashSet<>();
        }

        List<Integer> temp = new ArrayList<>();
        int res = queue.peek();
        int begin = queue.peek() - 1;

        while (size > 0) {
            if (queue.isEmpty()) {
                return -1;
            }

            int tem = queue.poll();
            if (begin + 1 != tem) {
                continue;
            }
            temp.add(tem);
            set.add(tem);
            size--;
        }

        temp.stream().forEach(s -> arr[s] = mID);
        map.put(mID, set);
        return res;
    }

    public int freeMemory(int mID) {
        HashSet<Integer> set = map.get(mID);
        if (set == null) {
            return 0;
        }
        int res = set.size();
        for (Integer index : set) {
            arr[index] = 0;
            queue.add(index);
        }
        return res;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(arr);
    }
}
