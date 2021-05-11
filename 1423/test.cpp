#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        //滑动窗口
        int n = cardPoints.size();
        //窗口左右指针
        int l = n - k, r = n - 1; 
        int sum = accumulate(cardPoints.end() - k, cardPoints.end(), 0); 
        int res = sum; 
        while ( l < n) {
            //加上右侧新进入窗口元素， 减去左侧离开窗口元素
            sum += cardPoints[++r % n] - cardPoints[l++%n];
            res = max(res, sum); 
        }
        return res; 
    }
};