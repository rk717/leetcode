#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    typedef unsigned long long ull;
    int combinationSum4(vector<int>& nums, int target) {
        if(nums.empty()){
            return 0;
        }
        vector<ull> d(target+1,0);
        //std::vector<unsigned long long> d(target + 1, 0);
        for(int i=0;i<=target;++i){
            for(int j = 0;j<nums.size();++j){
                if(i > nums[j]){
                    d[i] += d[i - nums[j]];
                }else if(i == nums[j]){
                    d[i] += 1;
                }
            }
        } 
        return d[target];
    }

};

