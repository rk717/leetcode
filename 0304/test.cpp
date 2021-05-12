#include <bits/stdc++.h>

using namespace std; 

class NumMatrix {
    vector<vector<int>> all_sums;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        int m = matrix.size();
        if(m == 0) return;
        int n = matrix[0].size();
        all_sums.resize(m+1, vector<int>(n+1));
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0) all_sums[i][j] = 0;
                else all_sums[i][j] = matrix[i-1][j-1] + all_sums[i-1][j] + all_sums[i][j-1] - all_sums[i-1][j-1];
            }
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        return (all_sums[row2+1][col2+1] - all_sums[row2+1][col1] - all_sums[row1][col2+1] + all_sums[row1][col1]);
    }
};

作者：Little_God_of_Wealth
链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable/solution/xiao-cai-shen-zuo-ti-ji-304-qie-ji-hai-p-wj2y/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。