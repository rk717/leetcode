#include <bits/stdc++.h>
using namespace std; 

/*
heights of building, some bricks, some ladders

start from building[0], 
move to the next building by posiibly using bricks or ladders 

if the current building's height is greater than or equal 
to the next building's height, you do not need a ladder or bricks. 

if the ... less than ... , 
you can either use one ladder 
or (h[i+1] - h[i]) bricks; 

return the furthest building index (0-indexed) 
you can reach if you use the given ladders and bricks optimally
*/

/*
梯子相当于一次性的无限量砖块，那么一定要慎重选择梯子。
也就是说，如果我们有 l 个梯子，我们会在 dealta h 最大的 那 次 使用梯子，
而在剩余的 情况下使用 砖块；
*/

class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        int n = heights.size(); 
        
        //由于我们需要维护最大的 l 个值， 因此使用小根堆
        priority_queue<int, vector<int>, greater<int>> q; 

        //需要使用砖块的delta h 的和
        int sumH = 0; 
        for(int i = 1; i < n; ++i) {
            int deltaH = heights[i] - heights[i-1];
            if (deltaH > 0) {
                q.push(deltaH);
                //如果优先队列已满，需要拿出一个其中的最小值，改为使用砖块
                if (q.size() > ladders) {
                    sumH += q.top(); 
                    q.pop(); 
                }
                if(sumH > bricks) {
                    return i-1; 
                }
            }
        }
        return n - 1; 
    }
};

int main() {
    Solution s; 
    vector<int> v = {4,12,2,7,3,18,20,3,19}; 
    
    cout << s.furthestBuilding(v, 10, 2); 
}