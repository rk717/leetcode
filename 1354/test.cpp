#include <bits/stdc++.h>
using namespace std; 

class Solution {
public:
    bool isPossible(vector<int>& target) {
        long long sum = 0;
        priority_queue<long long> q;
        for(int ev: target){
            sum += ev;
            q.push(ev);
        }
        while(q.top() != 1){
            long long curMax = q.top(); q.pop();
            long long otherSum = sum - curMax;
            if(curMax - otherSum < 1 || otherSum == 0) return false;
            long long temp = curMax % otherSum;
            q.push(temp);
            sum = sum - curMax + temp;
        }
        return true;
    }
};

作者：Monologue-S
链接：https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums/solution/cni-tui-you-xian-dui-lie-by-monologue-s-dcso/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。