package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 12:57:42
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 13:41:04
 * @Description: to be added
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

    Example 1:
    Input: root = [3,1,4,null,2], k = 1
    Output: 1

    Example 2:
    Input: root = [5,3,6,2,4,null,null,1], k = 3
    Output: 3

    Constraints:
    The number of nodes in the tree is n.
    1 <= k <= n <= 104
    0 <= Node.val <= 104
    
    Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int solution(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        while(root != null || !queue.isEmpty()) {
            while(root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            k --;
            if (k <= 0) break;
            root = root.right;
        }
        return root.val;
    }

    public static int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);
        search(root, smallQueue, k);
        return smallQueue.peek();
    }

    private static void search(TreeNode node, PriorityQueue<Integer> queue, int k) {
        if (node == null) return;
        if (queue.size() < k) queue.add(node.val);
        else {
            if (node.val < queue.peek()) {
                queue.poll();
                queue.offer(node.val);
            }
        }
        search(node.left, queue, k);
        search(node.right, queue, k);
    }
}