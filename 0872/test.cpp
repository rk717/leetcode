#include <bits/stdc++.h>

using namespace std; 

//definition for a binary tree node
struct TreeNode {
    int val; 
    TreeNode* left; 
    TreeNode* right; 
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    void dfs (TreeNode* root, vector<int>& vec) {
        if (!root -> left && !root -> right) {
            vec.push_back(root->val); 
            return; 
        }

        if (root->left) dfs(root->left, vec); 
        if (root->right) dfs(root->right, vec); 
    }

    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> v1, v2; 
        dfs(root1, v1); 
        dfs(root2, v2); 
        return v1 == v2; 
    }
};

//https://leetcode-cn.com/problems/leaf-similar-trees/solution/xiao-ming-zhao-bu-tong-tong-bu-bian-li-b-0te2/