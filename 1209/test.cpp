#include <iostream>
#include <string>
#include <vector>
using namespace std; 

class Solution {
public:
    string removeDuplicates(string s, int k) {
        vector<pair<char,int>> st; 
        for(auto& i : s) {
            if(!st.empty() && st.back().first == i) {
                if(++st.back().second == k) st.pop_back(); 
            } else {
                st.push_back(make_pair(i, 1));
            }
        }
        string res;
        for(auto& i : st) {
            int l = i.second;
            while(l--) {
                res += i.first;
            }
        }
        return res; 
    }
};