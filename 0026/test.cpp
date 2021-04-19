#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        const int N = nums.size(); 
        if (N == 0) return 0; 
        int left = 0; 
        for(int right = 1; right < N; ++right) {
            

            if(nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left+1; 
    }
};

/*
            如果快指针和慢指针指向的元素不等，
            则把快指针指向的元素放到慢指针的下一个位置。
            慢指针右移，把新的元素作为基准。
            */