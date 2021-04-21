#include <iostream>
#include <vector>

using namespace std; 

//dp

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size(); 
        vector<vector<int>> dp (n, vector<int>(n));
        //initial
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++) {
            //every line left element
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for(int j = 1; j < i; ++j) {
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            //every line the most right element 
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }        
        return *min_element(dp[n-1].begin(), dp[n-1].end());
    }
};