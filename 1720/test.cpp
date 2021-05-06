#include <bits/stdc++.h>

using namespace std; 


class Solution {
public:
    vector<int> decode(vector<int>& encoded, int first) {
        int n = encoded.size() + 1;
        vector<int> res(n, 0);
        res[0] = first;
        for (int i = 1; i < n; ++i)
        {
            res[i] = encoded[i-1] ^ res[i-1];
        }
        return res;
    }
};

作者：ffreturn
链接：https://leetcode-cn.com/problems/decode-xored-array/solution/1720-cji-hu-shuang-bai-de-zhi-bai-jie-fa-3r1n/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。