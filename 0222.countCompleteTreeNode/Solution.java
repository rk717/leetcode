/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//完全二叉树
//它是一颗空树，或者他的叶子节点只出现在最后两层，
//若最后一层不满， 则叶子节点只在最左侧

class Solution {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}