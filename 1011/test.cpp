#include <bits/stdc++.h>
using namespace std; 

class Solution {
public:
    int shipWithinDays(vector<int>& weights, int D) {
        //确定二分查找左右边界
        /*
            因为船的运载能力不小于所有包裹中最重的那个，所以，左边界为 weights 中元素的最大值
            右边界，船的运载能力也不会大于所有包裹的和，右边界为weights中元素的和
        */
        int left = *max_element(weights.begin(), weights.end());
        int right = accumulate(weights.begin(), weights.end(), 0); 


        while(left < right ) {
            int mid = (left + right) / 2;

            //need 为需要运送的天数
            //cur 为当前这一天已经运送的包裹重量之和

            int need = 1, cur = 0; 

            for(int weight : weights) {
                if (cur + weight > mid) {
                    ++need; 
                    cur = 0; 
                }
                cur += weight; 
            } 
            if(need <= D) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        return left; 
    }
};

//[1,2,3,4,5,6,7,8,9,10]  D = 5
/*
我们将「最少需要运送的天数」与 DD 进行比较，就可以解决这个判定问题。当其小于等于 DD 时，
我们就忽略二分的右半部分区间；当其大于 DD 时，我们就忽略二分的左半部分区间。

*/



int main() {
    Solution s; 
    vector <int>  v = {1,2,3,4,5,6,7,8,9,10};
    cout << s.shipWithinDays(v, 5); 

}