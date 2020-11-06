package howManyNumbersAreSmallerThanTheCurrentNumber;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums){
        if(nums == null || nums.length <= 1){
            return nums; 
        } 

        int length = nums.length; 
        int[] result = new int[length];
        int[] counter = new int[101]; //出现的数字范围，0~100， 共101个
        
        //将nums数组中的数字，作为下标，记录每个数字出现次数
        for(int i = 0; i < length; i++){
            counter[nums[i]]++; 
        }

        for(int i = 1; i <= 100; i++){
            counter[i] += counter[i - 1];
        }

        for(int i = 0; i < length; i++){
            result[i] = nums[i] == 0 ? 0 : counter[nums[i] - 1];
        }

        return result; 
    }
}
