/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-06-03 11:29:03
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-06-03 11:30:20
 * @Description: to be added
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
