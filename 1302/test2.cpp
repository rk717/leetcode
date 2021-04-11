//广度优先搜索

#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std; 

struct TreeNode {
    int val; 
    TreeNode* left; 
    TreeNode* right; 
    TreeNode() : val(0), left(nullptr), right(nullptr){}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

using PTI = pair<TreeNode*, int>; 

class Solution {
public:
    int deepestLeavesSum(TreeNode* root) {
        queue<PTI> q; 
        q.emplace(root, 0); 
        int maxdep = -1, total = 0; 
        while(!q.empty()) {
            TreeNode* node = q.front().first;
            int dep = q.front().second;
            q.pop();
            if(dep > maxdep) {
                maxdep = dep; 
                total = node->val; 
            }
            else if(dep == maxdep) {
                total += node->val; 
            }
            if(node->left) {
                q.emplace(node->left, dep+1); 
            }
            if(node->right) {
                q.emplace(node->right, dep+1);
            }
        }
        return total;        
    }
};