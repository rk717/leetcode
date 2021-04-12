#include <iostream>
#include <vector>

using namespace std; 


class Solution {
public:
    vector<int> constructArray(int n, int k) {
        vector<int> res; 
        int i = 1; 
        int j = n; 
        while (i <= j) {
            if ( k > 1) {
                //按照交替 i, j 一小一大的方法生成前 k-1 个 数
                if (k % 2 != 0) {
                    res.push_back(i);
                    i++;
                } else {
                    res.push_back(j);
                    j--;
                }
                k--;
            } else {
                //按照升序的方法生成剩余排列
                res.push_back(i); 
                i++; 
            }
        }
        return res; 
    }
};