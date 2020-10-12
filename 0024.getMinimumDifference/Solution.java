package getMinimumDifference;


// public class TreeNode {
//     int val; 
//     TreeNode left; 
//     TreeNode right; 
//     TreeNode(int x) {val = x;}
// }

public class Solution {
    public static class TreeNode{
        int val; 
        TreeNode left; 
        TreeNode right; 
        TreeNode(int x ){val = x; }
    }

    int pre; 
    int ans; 

    public int getMinimumDifference(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1; 
        dfs(root);
        return ans; 
    }

    public void dfs(TreeNode root){
        if (root == null){
            return; 
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val; 
        }else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val; 
        }
        dfs(root.right);
    }
}


/*
class Node{
    int val; 
    Node left, right; 

    public Node(int val){
        this.val = val; 
        left = right = null; 
    }
}
*/

//24