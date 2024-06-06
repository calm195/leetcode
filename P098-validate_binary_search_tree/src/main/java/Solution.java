/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-06-03 11:22:01
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-06-03 11:50:39
 * @Description: to be added
 */

public class Solution {
    public boolean isValidBST(TreeNode root){
        if (root == null) {
            return true;
        }
        boolean left = true, right = true;
        if (root.left != null) {
            if (root.left.val < root.val) {
                left = isValidBST(root.left);
            }
            else {
                left = false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val) {
                right = isValidBST(root.right);
            }
            else {
                right = false;
            }
        }
        return left && right;
    }
}
