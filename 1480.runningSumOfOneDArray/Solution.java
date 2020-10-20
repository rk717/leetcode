package runningSumOfOneDArray;

import java.util.*; 

class Solution {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0){
            return null; 
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i-1] + nums[i];
        }

        return result; 
    }
}

//1480 running sum of 1d Array
