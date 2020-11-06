import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
首先看到题目是二叉树题目，一般二叉树的题目，就是考察遍历

这道题，我们可以转变成求每个节点的和，那么我们的问题就变成层楼求每个叶子节点的和；
而每个节点的和又等于父节点的和*10 + 自身 的和
*/
class Solution {
    public int sumNumbers(TreeNode root) {
        //如果节点为空，直接返回0
        if (root == null) return 0; 

        //两个栈，一个存储的节点，一个存储的是节点对应的值
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        //全局的，统计所有路径的和
        int res = 0; 
        nodeStack.add(root);
        valueStack.add(root.val);

        while(!nodeStack.isEmpty()){
            //当前节点和当前节点的值同时出栈
            TreeNode node = nodeStack.pop();
            int value = valueStack.pop();
            if(node.left == null && node.right == null){
                //如果当前节点是叶子节点，说明找到了一条路径，把这条路径的值加入到全局变量 res 中
                res += value; 
            }else{
                //如果不是叶子节点就执行下面的操作
                if(node.right != null){
                    //把子节点和子节点的值分别加入到栈中，这里子节点的值就是父节点的值*10 + 当前节点的值
                    nodeStack.push(node.right);
                    valueStack.push(value*10 + node.right.val);
                }
                if(node.left != null){
                    nodeStack.push(node.left);
                    valueStack.push(value*10 +node.left.val);
                }
            }
        }
        return res; 
    }
}