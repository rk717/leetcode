#include <bits/stdc++.h>
using namespace std; 

class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        int n = jobs.size();
        vector<int> tot(1 << n, 0);
        for (int i = 1; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) continue;
                int left = (i - (1 << j));
                tot[i] = tot[left] + jobs[j];
                break;
            }
        }
        
        vector<vector<int>> dp(k, vector<int>(1 << n, -1));
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = tot[i];
        }
        
        for (int j = 1; j < k; j++) {
            for (int i = 0; i < (1 << n); i++) {
                int minv = INT_MAX;
                for (int s = i; s; s = (s - 1) & i) { // 枚举 i 的全部子集
                    int left = i - s;
                    int val = max(dp[j-1][left], tot[s]);
                    minv = min(minv, val);
                }
                dp[j][i] = minv;
            }
        }
        return dp[k-1][(1<<n)-1];
    }
};

作者：Arsenal-591
链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/zhuang-ya-dp-jing-dian-tao-lu-xin-shou-j-3w7r/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。