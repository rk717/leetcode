#include <bits/stdc++.h>
using namespace std; 

//dfs 

//definition for singly-linked list
struct ListNode {
    int val; 
    ListNode* next; 
    ListNode(): val(0), next(nullptr) {} 
    ListNode(int x) : val(x), next(nullptr) {} 
    ListNode(int x, ListNode* next) : val(x), next(next) {}
}; 

//definition for a binary tree node 
struct TreeNode {
    int val; 
    TreeNode* left; 
    TreeNode* right; 
    TreeNode() : val(0), left(nullptr), right(nullptr) {} 
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {} 
};

class Solution {
public:
    TreeNode* dfs(vector<int>& num, int start, int end) {
        if(start > end) {
            return nullptr; 
        }

        int mid = start + (end-start) / 2; 
        TreeNode* node = new TreeNode(num[mid]);
        node -> left = dfs(num, start, mid-1); 
        node -> right = dfs(num, mid+1, end); 
        return node; 
    }

    TreeNode* sortedListToBST(ListNode* head) {
        vector<int> num; 
        while(head != nullptr) {
            num.push_back(head->val); 
            head = head->next; 
        }
        return dfs(num, 0, num.size()- 1); 
    }
};