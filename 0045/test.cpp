/*
2021.05.05
t.ly/7nMDy
*/

#include <bits/stdc++.h>
using namespace std; 

class Solution {
public:
    int jump(vector<int>& nums) {
        int ans = 0; 
        int start = 0; 
        int end = 1; 
        while (end < nums.size()) {
            int maxPos = 0; 
            for(int i = start; i < end; i++) {
                //能跳到的最远距离
                maxPos = max(maxPos, i + nums[i]); 
            }
            start = end; 
            end = maxPos + 1; 
            ans++; 
        }
        return ans; 
    }
};