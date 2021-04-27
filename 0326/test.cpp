#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    bool isPowerOfThree(int n) {
        while(n <= 0) return false; 

        if(1162261467 % n == 0) return true; 
        else return false;  
    }
};