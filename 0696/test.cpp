#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution
{
public:
    int countBinarySubstrings(string s)
    {
        vector<int> counts; 
        int ptr = 0, n = s.size(); 

        while(ptr<n)
        {
            char c = s[ptr];
            int cnt = 0;
            while(ptr < n && s[ptr] == c)
            {
                ++ptr; 
                ++cnt; 
            }
            counts.push_back(cnt); 
        }
        int ans = 0;

        //我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案
        for(int i = 1; i < counts.size(); ++i) 
        {
            ans += min(counts[i], counts[i-1]);
        }
        return ans; 
    }
};