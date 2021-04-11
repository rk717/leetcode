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

class Solution{
public: 
    int depth = -1; 
    int nowD = 0; 
    int sum = 0; 
    int maxDepth(TreeNode* root) {
        if(root == nullptr) {
            return 0; 
        }
        else {
            return max(maxDepth(root->left), maxDepth(root->right)) + 1; 
        } 
        
    }

    void preOrderTranverse(TreeNode* root, int d) {
        if(root == nullptr) {
            return; 
        }else{
            if(d == depth) {
                sum += root->val; 
            }
            preOrderTranverse(root->left, d+1);
            preOrderTranverse(root->right, d+1); 
        }
    }

    int deepestLeavesSum(TreeNode* root) {
        depth = maxDepth(root); 
        preOrderTranverse(root, 1); 
        return sum; 
    }
}; 