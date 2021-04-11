//深度优先搜索

#include <iostream>
#include <vector>
#include <string>

using namespace std; 

struct TreeNode {
    int val; 
    TreeNode* left; 
    TreeNode* right; 
    TreeNode() : val(0), left(nullptr), right(nullptr){}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class Solution {
private: 
    int maxdep = -1; 
    int total = 0; 

public: 
    void dfs(TreeNode* node, int dep) {
        if(!node) {
            return; 
        }
        if(dep > maxdep) {
            maxdep = dep; 
            total = node->val;
        }
        else if(dep == maxdep) {
            total += node->val; 
        }

        dfs(node->left, dep+1);
        dfs(node->right, dep+1);
    }

    int deepestLeavesSum(TreeNode* root) {
        dfs(root, 0); 
        return total; 
    }
};