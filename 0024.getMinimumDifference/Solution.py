class Solution: 
    pre = 999
    diff = 999
    def getMinimumDifference(self, root: TreeNode) -> int: 
        
        def Search(root):
            if root == None:
                return
            Search(root.left)
            self.diff = min(self.diff, abs(self.pre - root.val))
            self.pre = root.val 
            Search(root.right)
        
        Search(root)

        return self.diff


#24