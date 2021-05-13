#include <bits/stdc++.h>
using namespace std; 

/*
2d coordinates like (1,3), (2, 0.5). 
then we remove all commas, decimal points, and spaces, 
and ended up with the string s. 
return a list of strings representing all possibilities 
for what our original coornates could have been. 
*/

class Solution {
public:

    int toNum(string s, vector<string> &res) {
        // 前后是0
        if (s[0] == '0' && s[s.size() - 1] == '0') {
            if (s.size() == 1) {
                res.push_back("0");
                return 1;
            } else return 0;
        }
        // 只前是0
        if (s[0] == '0') {
            res.push_back(s.substr(0, 1) + '.' + s.substr(1));
        } else {
            // 前后都不是0
            if (s[s.size() - 1] != '0') {
                for (int i=1; i<s.size(); i++) {
                    res.push_back(s.substr(0, i) + '.' + s.substr(i));
                }
            }
            // 只后是0
            res.push_back(s);
        }
        return res.size();
    }

    void join(vector<string> &left, vector<string> &right, vector<string> &res) {
        for (auto l:left) {
            for (auto r:right) {
                res.push_back('(' + l + ", "+ r + ')');
            }
        }
    }

    vector<string> ambiguousCoordinates(string S) {
        vector<string> res;
        S = S.substr(1, S.size() - 2);
        for (int i=1; i<S.size(); i++) {
            vector<string> left, right;
            if (toNum(S.substr(0, i), left) == 0) continue;
            if (toNum(S.substr(i), right) == 0) continue;
            join(left, right, res);
        }
        return res;
    }
};

作者：mszjaas
链接：https://leetcode-cn.com/problems/ambiguous-coordinates/solution/c-by-mszjaas-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。