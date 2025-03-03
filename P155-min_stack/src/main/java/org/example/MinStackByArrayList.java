package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 15:49:22
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 15:49:24
 * @Description: to be added
 */

import java.util.ArrayList;
import java.util.List;

public class MinStackByArrayList {
    List<Integer> st1 = new ArrayList<>();
    List<Integer> st2 = new ArrayList<>();

    public MinStackByArrayList() {
    }

    public void push(int val) {
        st1.add(val);
        if (st2.isEmpty()) {
            st2.add(val);
        } else {
            st2.add(Math.min(val, st2.get(st2.size() - 1)));
        }
    }

    public void pop() {
        st1.remove(st1.size() - 1);
        st2.remove(st2.size() - 1);
    }

    public int top() {
        return st1.get(st1.size() - 1);
    }

    public int getMin() {
        return st2.get(st2.size() - 1);
    }
}
