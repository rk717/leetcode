#include <bits/stdc++.h>

using namespace std; 

/*
inorder (left, root, right)
preorder (root , left, right)
postorder (left, right root)
*/

class Node {
public:
    int val; 
    vector<Node*> children; 

    Node() {}

    Node(int _val) {
        val = _val; 
    }

    Node(int _val, vector<Node*> _children) {
        val = _val; 
        children = _children; 
    }
};

class Solution {
public: 
    vector<int> x; 
    void traverse(Node* root) {
        if(root) {
            x.push_back(root-> val);
            for(int i =0; i < root-> children.size(); i++) {
                traverse(root-> children[i]);
            }
        }
    }
    
    vector<int> preorder (Node* root) {
        traverse(root);
        return x; 
    }
};