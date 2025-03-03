package org.example;

import java.util.LinkedList;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 15:24:03
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 15:47:06
 * @Description: to be added
 */


public class MinStack {

    LinkedList<Integer> list;
    LinkedList<Integer> minList;

    public MinStack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int val) {
        list.add(val);
        if (minList.isEmpty()) {
            minList.add(val);
            return;
        }
        if (minList.getLast() > val) minList.add(val);
        else minList.add(minList.getLast());
    }

    public void pop() {
        list.removeLast();
        minList.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return minList.getLast();
    }

    public void print() {
        list.stream().forEach(i -> System.out.print(i + ", "));
        System.out.println();
        minList.stream().forEach(i -> System.out.print(i + ", "));
        System.out.println();
        System.out.println();
    }
}
