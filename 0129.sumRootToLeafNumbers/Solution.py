Definition for a binary tree node.
Class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None 

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        ans = []
        if not root:
            return 0
        
        def dp(node: TreeNode, num):
            num += node.val
            if node.left:
                dp(node.left, num*10)
            if node.right:
                dp(node.right, num*10)
            if not node.left and not node.right:
                ans.append(num)
            if not node.right and node.right:
                ans.append(num)
            if node.right and not node.right:
                ans.append(num) 
        
        dp(root, 0)
        return sum(ans) 