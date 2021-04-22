#include <bits/stdc++.h>
#include <algorithm>
using namespace std; 

class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        unordered_map<int, int> mp; 
        int maxnum = 0; 
        for(auto wl : wall) 
        {
            int temp = 0; 
            for(int i = 0; i < wl.size() - 1; ++i)
            {
                temp += wl[i]; 
                mp[temp]++; 
                maxnum = max(maxnum, mp[temp]);
            }
        }
        return wall.size() - maxnum; 
    }
};