#include <bits/stdc++.h>

using namespace std; 
/*
对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
由于矩阵中的行列从0开始计数，因此对于矩阵中的元素 
matrix[row][col], 旋转后为 matrix[col][n-row-1]
*/

//使用辅助数组
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size(); 
        //cpp 里 这里的 = 拷贝 是 值拷贝， 会得到一个新的数组
        auto matrix_new = matrix; 
        /*
            是自动选 type
            就是 不用定义 vector
            这里就相当于 vector<vector<int>>
        */
        for (int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }
        //这里是值拷贝
        matrix = matrix_new; 
    }
};