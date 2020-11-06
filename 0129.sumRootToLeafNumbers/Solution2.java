package sumRootToLeafNumbers;

class Solution{
    int res = 0; 
    public int sumNumbers(TreeNode root){
        if(root == null) return res; 
        helper(root, 0);
        return res; 
    }

    private void helper(TreeNode node, int val){
        if(node == null) return; 
        if(node.left == null && node.right == null){
            res += val * 10 + node.val; 
            return; 
        }

        helper(node.left, val*10 + node.val); 
        helper(node.right, val*10 + node.val);
    }
}

//https://www.youtube.com/watch?v=6fC6O5lkSkg&ab_channel=JacobHuang