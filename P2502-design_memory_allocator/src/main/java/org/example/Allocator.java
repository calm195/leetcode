package org.example;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 14:46:14
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-25 20:33:00
 * @Description: 
 * 
 * 第一版：失败，无法处理内存碎片，难以有效找出连续的内存序列。
 * 第二版：失败，边界问题难以解决
 * 第三版：成功，减少了复杂度，只维护占用的内存列表
 */
public class Allocator {

    private final List<Node> nodes;

    public Allocator(int n) {
        nodes = new ArrayList<>();
        nodes.add(new Node(0, 0, 0));
        nodes.add(new Node(n, n, 0));
    }

    public int allocate(int size, int mID) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            Node left = nodes.get(i);
            Node right = nodes.get(i + 1);
            int slog = right.begin - left.end;
            if (slog >= size) {
                nodes.add(i + 1, new Node(left.end, left.end + size, mID));
                return left.end;
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int res = 0;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            if (nodes.get(i).mID == mID) {
                res += nodes.get(i).end - nodes.get(i).begin;
                nodes.remove(i);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node node: nodes) {
            sb.repeat(Integer.toString(node.mID) + ", ", node.end - node.begin);
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node {

        int begin;
        int end;
        int mID;

        Node(int begin, int end, int mID) {
            this.begin = begin;
            this.end = end;
            this.mID = mID;
        }
    }
}
