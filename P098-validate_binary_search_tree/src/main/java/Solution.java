
import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-06-03 11:22:01
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-30 10:15:54
 * @Description: 
 * 
 * 暴力递归 
 * 中序遍历
 */

public class Solution {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max){
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public boolean inorder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        long pre = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 总是弹出中序节点
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }

            pre = root.val;
            root = root.right;
        }
        return true;
    } 
}
