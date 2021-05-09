#include <bits/stdc++.h>
using namespace std; 

class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size();
        if(m*k > n) return -1;
        //left偷懒直接用1了，用min_element也没错
        int l = 1, r = *max_element(bloomDay.begin(), bloomDay.end());
        while(l < r)
        {
            int mid = (l+r) >> 1;
            int numMake = 0, numBloom = 0;
            for(int& x : bloomDay)
            {
                numBloom = x <= mid? numBloom + 1 : 0;
                if(numBloom == k)
                {
                    ++numMake;
                    numBloom = 0;
                }
            }

            if(numMake >= m) r = mid;
            else l = mid+1;
        }
        return l;   
    }
};

作者：Xiaohu9527
链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/solution/xiao-ming-chong-hua-by-xiaohu9527-5jf6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/solution/xiao-ming-chong-hua-by-xiaohu9527-5jf6/