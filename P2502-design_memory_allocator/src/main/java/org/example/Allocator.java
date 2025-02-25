package org.example;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 14:46:14
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-25 19:48:46
 * @Description: 
 * 
 * 第一版：失败，无法处理内存碎片，难以有效找出连续的内存序列。
 * 第二版：失败，边界问题难以解决
 */
public class Allocator {

    private Node root;
    private final int totalSize;

    public Allocator(int n) {
        root = new Node(0, n - 1, 0, null, null);
        this.totalSize = n;
    }

    public int allocate(int size, int mID) {
        Node temp = root;
        while (temp != null) {
            if (temp.mID != 0 && temp.end + 1 == this.totalSize) {
                return -1;
            }
            if (temp.size() < size || temp.mID != 0) {
                temp = temp.right;
            } else if (temp.size() == size) {
                temp.mID = mID;
                int begin = temp.begin;
                int end = temp.end;
                Node left = temp.left;
                Node right = temp.right;
                if (left != null && left.mID == mID) {
                    begin = temp.left.begin;
                    left = temp.left.left;
                }
                if (right != null && right.mID == mID) {
                    end = temp.right.end;
                    right = temp.right.right;
                }
                Node newNode = new Node(begin, end, mID, left, right);
                if (newNode.left != null) newNode.left.right = newNode;
                else this.root = newNode;
                if (newNode.right != null) newNode.right.left = newNode;
                return temp.begin;
            } else if (temp.size() > size) {
                Node newNode; 
                Node right = new Node(temp.begin + size, temp.end, 0, null, temp.right);
                if (temp.left != null && temp.left.mID == mID) newNode = new Node(temp.left.begin, temp.begin + size - 1, mID, temp.left.left, null);
                else newNode = new Node(temp.begin, temp.begin + size - 1, mID, temp.left, null);
                
                newNode.right = right;
                right.left = newNode;

                if (newNode.left != null) newNode.left.right = newNode;
                else this.root = newNode;
                return temp.begin;
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        Node node = root;
        int res = 0;
        while (node != null) {
            if (node.mID == mID) {
                res += node.size();
                node.mID = 0;
            }
            node = node.right;
        }

        node = root;
        boolean hasPre = false;
        int begin = -1;
        Node left = null;
        while (node != null ) {
            if (node.mID == 0) {
                if (!hasPre) {
                    begin = node.begin;
                    left = node.left;
                    hasPre = true;
                }
                node = node.right;
            } else {
                if (hasPre) {
                    Node newNode = new Node(begin, node.begin - 1, 0, left, node);
                    if (left != null) left.right = newNode;
                    node.left = newNode;
                    hasPre = false;
                }
                node = node.right;
            }
        }

        return res;
    }

    @Override
    public String toString() {
        Node node = root;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(node != null) {
            for (int i = 0; i < node.size(); i++) {
                sb.append(node.mID).append(", ");
            }
            node = node.right;
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node {

        int begin;
        int end;
        int mID;
        Node left;
        Node right;

        public Integer size() {
            return end - begin + 1;
        }

        Node(int begin, int end, int mID, Node left, Node right) {
            this.begin = begin;
            this.right = right;
            this.left = left;
            this.end = end;
            this.mID = mID;
        }
    }
}
