#include <bits/stdc++.h>
using namespace std; 

//dp 

class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size(); 
        int n = word2.size(); 

        vector<vector<int>>dp (m+1, vector<int>(n+1)); 

        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if (word1[i-1] == word2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1; 
                } else {
                    dp[i][j] = max(dp[i][j-1], dp[i-1][j]); 
                }
            }
        }
        return m+n-2*dp[m][n]; 
    }
};

//https://leetcode-cn.com/problems/delete-operation-for-two-strings/solution/c-dong-tai-gui-hua-by-mei-you-ni-de-liu-yue-tian-2/

/*

相当于计算最长公共子序列，
利用动态规划计算得到最长公共子序列后由两个字符串的长度和减去即可
dp[i][j]保存的是第1个序列第i个元素和第2个序列第j个元素之前最长公共子串

*/